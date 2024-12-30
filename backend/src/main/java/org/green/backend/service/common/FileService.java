package org.green.backend.service.common;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.common.FileDto;
import org.green.backend.entity.File;
import org.green.backend.repository.jpa.common.FileRepository;
import org.green.backend.utils.FileUploadUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 12-27 (작성자: 한우성)
 * 공통으로 사용가능한 파일서비스 입니다
 * 저장에 실패 시 파일을 삭제함.
 */
@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final FileUploadUtil fileUploadUtil;
    private final ModelMapper modelMapper;

    public void saveFile(MultipartFile file,
                         String fileGbnCd,
                         String fileRefId,
                         String userId) throws IOException {

        FileDto fileDto = fileUploadUtil.saveFile(file, fileGbnCd, fileRefId, userId);

        try {
            System.out.println(fileDto.toString() +" asdasdasdasd");
            File fileEntity = modelMapper.map(fileDto,File.class);
            System.out.println(fileEntity.toString() + "aaaaaaaaaaaaaaaa");
            fileRepository.save(fileEntity);
            System.out.println("내이름은 황승현 눈이 작지");
        } catch (Exception e) {
            fileUploadUtil.deleteFile(fileDto.getFileUrl());
            throw new RuntimeException("파일 데이터 저장 실패: " + e.getMessage(), e);
        }
    }
}
