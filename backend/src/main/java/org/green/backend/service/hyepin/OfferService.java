package org.green.backend.service.hyepin;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hyepin.OfferDto;
import org.green.backend.dto.hyepin.ResumeDto;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.dto.jeyeon.ApplicationResponseDto;
import org.green.backend.repository.dao.hyepin.EducationDao;
import org.green.backend.repository.dao.hyepin.OfferDao;
import org.green.backend.repository.dao.hyepin.ResumeDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 01-05 (작성자: 안혜빈)
 * 포지션 제안을 관리하는 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OfferService {

    private final OfferDao offerDao;

    //포지션 제안등록
    public int registOffer (OfferDto offerDto) {
        int result = 0;
        for(Integer offer : offerDto.getCheckList() ){
            result = offerDao.save(offer, offerDto.getApplicationNo(), offerDto.getUesrname());
            if(result == 0){
                return result;
            }
        }
        return 1;
    }

    //매칭 리스트 뽑아오기
    public List<ResumeDto> getResumeMatchingList () {
        List<ResumeDto> resumeList = offerDao.getResumeMatchingList();
        // 기술 스택 리스트를 "," 기준으로 분리
        for(ResumeDto resume : resumeList){
            if (resume.getStackCodes() != null && !resume.getStackCodes().isEmpty()) {
                List<String> stackList = new ArrayList<>();
                stackList.addAll(Arrays.asList(resume.getStackCodes().split(",")));
                resume.setStackList(stackList);
            }
        }
        return resumeList;
    }


    public List<ApplicationResponseDto> getApplicaionList(String username){
        List<ApplicationResponseDto> applicationList = offerDao.getApplicaionList(username);
        return applicationList;
    }

}
