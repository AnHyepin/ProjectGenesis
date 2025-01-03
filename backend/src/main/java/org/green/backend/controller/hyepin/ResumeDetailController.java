package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.common.GubnDto;
import org.green.backend.dto.hyepin.*;
import org.green.backend.repository.dao.hyepin.ResumeDao;
import org.green.backend.service.hyepin.ResumeDetailService;
import org.green.backend.service.hyepin.ResumeService;
import org.green.backend.service.hyepin.UserServiceAhp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 01-03 (작성자: 안혜빈)
 * 이 클래스는 이력서디테일 전용 RestController컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/resume/detail")
@RequiredArgsConstructor
public class ResumeDetailController {

    private final ResumeDetailService resumeDeatilService;

    @GetMapping("/resume")
    public ResumeDto resumeList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        ResumeDto resume = resumeDeatilService.getResumeByResumeNo(resumeNo);
        return resume;
    }

    @GetMapping("/stack")
    public List<GubnDto> stackList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<GubnDto> stackList = resumeDeatilService.getStackListByResumeNo(resumeNo);
        return stackList;
    }

    @GetMapping("/education")
    public List<EducationDto> educationList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<EducationDto> educationList = resumeDeatilService.getEducationListByResumeNo(resumeNo);
        return educationList;
    }

    @GetMapping("/career")
    public List<CareerDto> careerList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<CareerDto> careerList = resumeDeatilService.getCareerListByResumeNo(resumeNo);
        return careerList
                ;
    }

    @GetMapping("/certificate")
    public List<CertificateDto> certificateList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<CertificateDto> certificateList = resumeDeatilService.getCertificateListByResumeNo(resumeNo);
        return certificateList;
    }

    @GetMapping("/portfolio")
    public List<PortfolioDto>  portfolioList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<PortfolioDto> portfolioList = resumeDeatilService.getPortfolioListByResumeNo(resumeNo);
        return portfolioList;
    }

}
