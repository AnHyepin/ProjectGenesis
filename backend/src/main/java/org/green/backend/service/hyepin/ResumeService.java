package org.green.backend.service.hyepin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hyepin.ResumeDto;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.entity.ApplicationStack;
import org.green.backend.service.common.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-30 (작성자: 안혜빈)
 * 이력서를 관리하는 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeService {

    private final FileService fileService;

    public void registResume(ResumeDto resumeDto, List<MultipartFile> files) throws IOException {

        /* 여기 */
        //applicationDao.insertApplication(applicationRequestDto);

        /* 여기 */
        String username = null;

        /* 여기 */
        int lastresumeNo = 0;

        log.error("파일 확인 {}",files.get(0).getOriginalFilename());
        if (!files.get(0).getOriginalFilename().isEmpty()) {
            for (MultipartFile file : files) {
                fileService.saveFile(file, "resume_no", String.valueOf(lastresumeNo), username);
            }
        }
    }

}
