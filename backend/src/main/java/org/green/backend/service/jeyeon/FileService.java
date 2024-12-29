package org.green.backend.service.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.repository.jpa.jeyeon.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FileService {
    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    private final FileRepository fileRepository;

    public void saveFile(MultipartFile file, String fileGubnCode, int fileRefNo) throws IOException {
        File directory = new File(uploadDir);

        //디렉토리가 없으면 생성
        if(!directory.exists()){
            directory.mkdirs();
        }

        // 1. 파일명에 밀리세컨드를 포함한 고유 파일명 생성 (file_old_name)
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String fileOldName = currentTime + "_" + file.getOriginalFilename();

        // 2. 실제 파일명 (file_new_name) 저장
        String fileNewName = file.getOriginalFilename();

        // 3. 서버에 저장할 파일 경로 생성
        File serverFile = new File(uploadDir + "/" + fileOldName);

        // 4. 파일을 서버에 저장
        file.transferTo(serverFile);

        // 5. 파일 정보를 DB에 저장 (빌더 패턴 사용)
        org.green.backend.entity.File fileEntity = org.green.backend.entity.File.builder()
                .fileGubnCode(fileGubnCode)       // 파일 구분 코드
                .fileRefNo(fileRefNo)             // 파일 참조 번호
                .fileOldName(fileOldName)         // 밀리세컨드를 포함한 파일명
                .fileNewName(fileNewName)         // 실제 파일명
                .fileSize((int) file.getSize() / (1024 * 1024))  // 파일 크기 (MB 단위)
                .fileUrl(uploadDir + "/" + fileOldName)  // 파일 경로
                .build();

        // DB에 저장
        fileRepository.save(fileEntity);
    }

}
