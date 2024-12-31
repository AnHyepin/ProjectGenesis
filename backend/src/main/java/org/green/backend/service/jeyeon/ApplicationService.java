package org.green.backend.service.jeyeon;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.dto.jeyeon.ApplicationResponseDto;
import org.green.backend.entity.Application;
import org.green.backend.entity.ApplicationStack;
import org.green.backend.entity.Company;
import org.green.backend.entity.File;
import org.green.backend.repository.dao.jeyeon.ApplicationDao;
import org.green.backend.service.common.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 채용공고 Service입니다.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final ApplicationDao applicationDao;
    private final ApplicationStackService applicationStackService;
    private final FileService fileService;

    public void registApplication(ApplicationRequestDto applicationRequestDto, List<MultipartFile> files) throws IOException {
        applicationDao.insertApplication(applicationRequestDto);

        int lastApplicationNo = getLastApplicationNo();

        List<String> skillList = applicationRequestDto.getSkillList();

        if(!skillList.isEmpty()) {
            for (String skillCode : skillList) {

                ApplicationStack aStack = ApplicationStack.builder()
                        .applicationNo(lastApplicationNo)  // applicationNo 설정
                        .stackCode(skillCode)          // stackCode 설정
                        .build();
                applicationStackService.saveApplicationStack(aStack);
            }
        }


        log.error("파일 확인 {}",files.get(0).getOriginalFilename());
        if (!files.get(0).getOriginalFilename().isEmpty()) {
            for (MultipartFile file : files) {
                fileService.saveFile(file, "application_no", String.valueOf(lastApplicationNo), applicationRequestDto.getUsername());
            }
        }
    }

    private int getLastApplicationNo() {
        int lastApplicationNo = applicationDao.selectLastApplicationNo();
        System.out.println(lastApplicationNo);

        return lastApplicationNo;
    }

    public ApplicationResponseDto getApplication(int applicationNo) {
        ApplicationResponseDto application = applicationDao.selectApplication(applicationNo);
        System.out.println(application);
        return application;
    }

    public Company getApplicationCompany(String username) {
        return applicationDao.selectApplicatinCompany(username);
    }
}
