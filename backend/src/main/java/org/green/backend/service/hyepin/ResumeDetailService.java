package org.green.backend.service.hyepin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.common.GubnDto;
import org.green.backend.dto.hyepin.*;
import org.green.backend.repository.dao.hyepin.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 01-03 (작성자: 안혜빈)
 * 이력서 상세보기 페이지를 관리하는 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeDetailService {

    private final EducationDao educationDao;
    private final CareerDao careerDao;
    private final CertificateDao certificateDao;
    private final StackDao stackDao;
    private final ResumeDao resumeDao;
    private final PortfolioDao portfolioDao;

    public ResumeDto getResumeByResumeNo (int resumeNo) {
        ResumeDto resume =  resumeDao.getResumeByResumeNo(resumeNo);
        return resume;
    }

    public List<GubnDto> getStackListByResumeNo (int resumeNo) {
        List<GubnDto> stackList = stackDao.getStackListByResumeNo(resumeNo);
        return stackList;
    }

    public List<EducationDto> getEducationListByResumeNo (int resumeNo) {
        List<EducationDto> educationList = educationDao.getEducationListByResumeNo(resumeNo);
        return educationList;
    }

    public List<CareerDto> getCareerListByResumeNo (int resumeNo) {
        List<CareerDto> careerList = careerDao.getCareerListByResumeNo(resumeNo);
        return careerList;
    }

    public List<CertificateDto> getCertificateListByResumeNo (int resumeNo) {
        List<CertificateDto> certificateList = certificateDao.getCertificateListByResumeNo(resumeNo);
        return certificateList;
    }

    public List<PortfolioDto> getPortfolioListByResumeNo (int resumeNo) {
        List<PortfolioDto> portfolioList = portfolioDao.getPortfolioListByResumeNo(resumeNo);
        return portfolioList;
    }


}
