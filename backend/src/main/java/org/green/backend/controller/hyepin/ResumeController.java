package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.hws.UserDto;
import org.green.backend.dto.hyepin.*;
import org.green.backend.entity.File;
import org.green.backend.entity.User;
import org.green.backend.entity.common.Address;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.service.common.FileService;
import org.green.backend.service.hyepin.ResumeService;
import org.green.backend.service.hyepin.UserServiceAhp;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 12-30 (작성자: 안혜빈)
 * 이 클래스는 이력서 전용 RestController컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;
    private final UserServiceAhp userService;
    private final FileService fileService;


    @GetMapping
    public ResumeUserDto resumeRegist(@RequestParam String username) {
        //임시저장인 이력서가 있으면 삭제하고, 임시저장 이력서 생성
        resumeService.savedraftResume(username);

        //이력서 등록 페이지에 유저정보 가져오기
        User user = userService.getUser(username);
        File file = fileService.findFileByFileRefNoAndFileGubnCode(username, "profile_user");

        ResumeUserDto resumeUser = ResumeUserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .fileUrl(file.getFileUrl())
                .build();
        System.out.println(user.toString());
        return resumeUser;
    }

    @PostMapping("/education")
    public String createEducation(@ModelAttribute EducationDto educationDto) throws IOException {

        System.out.println("여기는 create education / educationDto 값:" + educationDto);
        //구직자의 가장 마지막 이력서 번호 꺼내기
        int maxNum = userService.getResumeMaxNumByUsername(educationDto.getUsername());
        //educationDto에 번호 넣기
        educationDto.setResumeNo(maxNum);
        int result =  resumeService.educationResist(educationDto);
        if(result == 1) {
            return "학력 저장 성공";
        }else{
            return "학력 저장 실패";
        }
    }


    @PostMapping("/career")
    public String createCareer(@ModelAttribute CareerDto careerDto) throws IOException {

        System.out.println("여기는 createCareer / CareerDto 값:" + careerDto);
        //구직자의 가장 마지막 이력서 번호 꺼내기
        int maxNum = userService.getResumeMaxNumByUsername(careerDto.getUsername());
        //careerDto에 번호 넣기
        careerDto.setResumeNo(maxNum);
        int result =  resumeService.careerResist(careerDto);
        if(result == 1) {
            return "경력 저장 성공";
        }else{
            return "경력 저장 실패";
        }
    }

    @PostMapping("/certificate")
    public String createCertificate(@ModelAttribute CertificateDto certificateDto) throws IOException {
        System.out.println("여기는 createCareer / CareerDto 값:" + certificateDto);
        //구직자의 가장 마지막 이력서 번호 꺼내기
        int maxNum = userService.getResumeMaxNumByUsername(certificateDto.getUsername());
        //certificateDto에 번호 넣기
        certificateDto.setResumeNo(maxNum);
        int result =  resumeService.certificateResist(certificateDto);
        if(result == 1) {
            return "자격증 저장 성공";
        }else{
            return "자격증 저장 실패";
        }
    }

    @PostMapping("/skill")
    public String createSkill(@ModelAttribute StackDto stackDto) throws IOException {
        System.out.println("여기는 createSkill / stackDto 값:" + stackDto);
        //구직자의 가장 마지막 이력서 번호 꺼내기
        int maxNum = userService.getResumeMaxNumByUsername(stackDto.getUsername());
        //stackDto에 번호 넣기
        stackDto.setResumeNo(maxNum);
        int result =  resumeService.stackResist(stackDto);
        if(result == 1) {
            return "스택 저장 성공";
        }else{
            return "스택 저장 실패";
        }
    }

    @PostMapping("/portfolio")
    public String createPortfolio(@ModelAttribute PortfolioDto portfolioDto, @RequestParam(value = "portfolioFile", required = false)
                                    MultipartFile portfolioFile) throws IOException {
        System.out.println("여기는 createPortpolio / portfolioDto 값:" + portfolioDto);
        System.out.println("여기는 createPortpolio / portfolioFile 값:" + portfolioFile);

        // 날짜 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(portfolioDto.getResumePortfolioStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(portfolioDto.getResumePortfolioEndDate(), formatter);


        //구직자의 가장 마지막 이력서 번호 꺼내기
        int maxNum = userService.getResumeMaxNumByUsername(portfolioDto.getUsername());
        //portfolioDto에 번호 넣기
        portfolioDto.setResumeNo(maxNum);

        int result = resumeService.savePortfolio(portfolioDto, portfolioFile);
        if(result == 1) {
            return "포트폴리오 저장 성공";
        }else{
            return "포트폴리오 저장 실패";
        }
    }

    //이력서 최종 저장
    @PostMapping("/resumeSubmit")
    public String resumeSubmit(@ModelAttribute ResumeDto resumeDto) throws IOException {
        System.out.println("여기는 api 컨트롤러");
        int maxNum = userService.getResumeMaxNumByUsername(resumeDto.getUsername());
        //careerDto에 번호 넣기
        resumeDto.setResumeNo(maxNum);
        System.out.println(resumeDto);
        //구직자의 가장 마지막 이력서 번호로 저장완료하기
        int result =  resumeService.resumeSubmit(resumeDto);
        if(result == 1) {
            return "이력서 저장 성공";
        }else{
            return "이력서 저장 실패";
        }
    }

    @GetMapping("/list")
    public List<ResumeDto> getResumeList(@RequestParam String username){
        List<ResumeDto> reseumeList = resumeService.getResumeList(username);
        return reseumeList;
    }

    @GetMapping("/count")
    public int getResumeCount(@RequestParam String username){
        int resumeCount = resumeService.getResumeCount(username);
        return resumeCount;
    }

    @PostMapping("/positionUpdate")
    public String resumePositionUpdate(@RequestParam("resumeNo") int resumeNo) throws IOException {
        int result = resumeService.updatePosition(resumeNo);
        if(result == 1) {
            return "포지션 제안받기 성공";
        }else{
            return "포지션 제안받기 실패";
        }
    }

    @GetMapping("/applyList")
    public List<ApplyApplycationDto> applyList (@RequestParam("resumeNo") int resumeNo) throws IOException {
        List<ApplyApplycationDto> applyList = resumeService.getApplyList(resumeNo);
        return applyList;
    }

    @GetMapping("/applyStatus")
    public List<ApplyStatusDto> applyStatusList (@RequestParam("username") String  username) throws IOException {
        List<ApplyStatusDto> applyStatusList = resumeService.getApplyStatusList(username);
        for(ApplyStatusDto a : applyStatusList) {
            System.out.println(a.toString());
        }
        return applyStatusList;
    }

}
