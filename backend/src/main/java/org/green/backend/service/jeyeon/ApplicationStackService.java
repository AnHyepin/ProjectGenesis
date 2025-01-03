package org.green.backend.service.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.entity.ApplicationStack;
import org.green.backend.repository.jpa.jeyeon.ApplicationStackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 공고별 기술 스택 Service입니다.
 */
@Service
@RequiredArgsConstructor
public class ApplicationStackService {

    private final ApplicationStackRepository applicationStackRepository;

    public void saveApplicationStack(ApplicationStack applicationStack) {

        ApplicationStack aStack = ApplicationStack.builder()
                .applicationNo(applicationStack.getApplicationNo())  // applicationNo 설정
                .stackCode(applicationStack.getStackCode())          // stackCode 설정
                .build();
        applicationStackRepository.save(aStack);
    }

    public List<ApplicationStack> getApplicationStack(int applicationNo) {
        return applicationStackRepository.findByApplicationNo(applicationNo);
    }
}
