package org.green.backend.service.hyepin;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.common.FileDto;
import org.green.backend.dto.hyepin.*;
import org.green.backend.entity.File;
import org.green.backend.repository.dao.hyepin.*;
import org.green.backend.service.common.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final EducationDao educationDao;
    private final CareerDao careerDao;
    private final CertificateDao certificateDao;
    private final StackDao stackDao;
    private final ResumeDao resumeDao;
    private final PortfolioDao portfolioDao;


    //처음 이력서 작성 생성할 때 임시저장 이력서 삭제
    public int savedraftResume(String username) {
        //임시저장 이력서 삭제
        List<ResumeDto> savedraftResume = resumeDao.getSavedraft(username);
        if(!savedraftResume.isEmpty()){
            resumeDao.savedraftDelete(username);
        }
        //임시저장으로 이력서 생성
        int result = resumeDao.create(username);

        return result;
    }

    //학력저장
    public int educationResist(EducationDto education) {
        System.out.println("서비스: education" + education);
        int result = educationDao.save(education);
        return result;
    }
    
    //경력저장
    public int careerResist(CareerDto career) {
        System.out.println("서비스: career" + career);
        int result = careerDao.save(career);
        return result;
    }

    //자격증저장
    public int certificateResist(CertificateDto certificateDto) {
        System.out.println("서비스: certificateDto" + certificateDto);
        int result = certificateDao.save(certificateDto);
        return result;
    }
    
    //스택저장
    public int stackResist(StackDto stackDto) {
        System.out.println("서비스: stackDto" + stackDto);

        //이력서 번호로 스택 저장된 것 있으면 모두 삭제
        List<String> stackList = stackDao.getByResumeNo(stackDto.getResumeNo());
        if(!stackList.isEmpty()) {
            stackDao.delete(stackDto.getResumeNo());
        }

        int result = 0;

        // 그리고 다시 저장
        for (String stack : stackDto.getStackCode()) {
            result = stackDao.save(stackDto.getResumeNo(), stack);
            if(result != 1){
                return result;
            }
        }
        return result;
    }

    //포트폴리오 저장 / 파일 저장
    public int savePortfolio(PortfolioDto portfolioDto, MultipartFile portfolioFile) throws IOException {
        int result = portfolioDao.save(portfolioDto);
        //방금 저장한 포트폴리오 번호 꺼내서 저장하기
        portfolioDto.setResumePortfolioNo(portfolioDao.maxNumByResumeNo(portfolioDto.getResumeNo()));

        if (portfolioFile != null && !portfolioFile.isEmpty()) {
            fileService.saveFile(portfolioFile, "portfolio_no", String.valueOf(portfolioDto.getResumePortfolioNo()), portfolioDto.getUsername());
        }
        return result;
    }

    //이력서 최종 저장
    public int resumeSubmit(ResumeDto resumeDto) {
        int result = resumeDao.save(resumeDto);
        return result;
    }

    //유저 ID로 이력서 목록 가져오기
    public List<ResumeDto> getResumeList(String username) {
        List<ResumeDto> resumeList = resumeDao.getResumeListByUsername(username);
        return resumeList;
    }

    //유저 ID로 이력서 카운트
    public int getResumeCount(String username) {
        int resumeCount = resumeDao.getResumeCount(username);
        return resumeCount;
    }

    //포지션제안 받기로 업데이트
    public int updatePosition(int resumeNo){
        int result = resumeDao.updatePosition(resumeNo);
        return result;
    }

    //이력서 번호별 지원 현황
    public List<ApplyApplycationDto> getApplyList(int resumeNo){
        List<ApplyApplycationDto> applyList = resumeDao.getApplyList(resumeNo);
        return applyList;
    }

    //지원현황 리스트
    public List<ApplyStatusDto>  getApplyStatusList(String username){
        List<ApplyStatusDto> applyStatusListList = resumeDao.getApplyStatusList(username);
        return applyStatusListList;
    }


}

