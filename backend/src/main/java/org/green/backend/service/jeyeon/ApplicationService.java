package org.green.backend.service.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.entity.ApplicationStack;
import org.green.backend.entity.File;
import org.green.backend.repository.dao.jeyeon.ApplicationDao;
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
public class ApplicationService {

    private final ApplicationDao applicationDao;
    private final ApplicationStackService applicationStackService;
    private final FileService fileService;

    public void registApplication(ApplicationRequestDto applicationRequestDto, MultipartFile file) throws IOException {
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

        if(file != null) {
            fileService.saveFile(file,"application_no",lastApplicationNo);
        }

    }

    private int getLastApplicationNo() {
        int lastApplicationNo = applicationDao.selectLastApplicationNo();
        System.out.println(lastApplicationNo);

        return lastApplicationNo;
    }
}
