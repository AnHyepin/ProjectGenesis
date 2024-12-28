package org.green.backend.service.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.repository.dao.jeyeon.ApplicationDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 채용공고 Service입니다.
 */
@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationDao applicationDao;

    public void registApplication(ApplicationRequestDto applicationRequestDto) {
        applicationDao.insertApplication(applicationRequestDto);

        int lastApplicationNo = getLastApplicationNo();

        List<String> skillList = applicationRequestDto.getSkillList();
        /*if(!skillList.isEmpty()) {
            for (String skill : skillList) {

            }
        }*/
    }

    private int getLastApplicationNo() {
        int lastApplicationNo = applicationDao.selectLastApplicationNo();
        System.out.println(lastApplicationNo);

        return lastApplicationNo;
    }
}
