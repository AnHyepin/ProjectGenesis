package org.green.backend.service.hyepin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hyepin.*;
import org.green.backend.repository.dao.hyepin.CareerDao;
import org.green.backend.repository.dao.hyepin.CertificateDao;
import org.green.backend.repository.dao.hyepin.EducationDao;
import org.green.backend.repository.dao.hyepin.StackDao;
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
    private final EducationDao educationDao;
    private final CareerDao careerDao;
    private final CertificateDao certificateDao;
    private final StackDao stackDao;


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
