package org.green.frontend.controller.hyepin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.hws.UserDto;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TestControllerAhp {

    private final ApiRequestService apiService;

    @GetMapping("/test")
    public String root() {
        return "/layout-test/company-main-layout";
    }
    @GetMapping("/test1")
    public String test1() {
        return "/layout-test/user-main-layout";
    }

    @GetMapping("/test2")
    public String test2() {
        return "/layout-test/guest-main-layout";
    }

    @GetMapping("/test3")
    public String test3() {
        return "/layout-test/deployment";
    }

    @GetMapping("/test4")
    public String test4() {
        return "/layout-test/layout-test2";
    }


    //여기는 세션 값 확인 안하고 들어갈 때
    @GetMapping("/resume/detail/company")
    public String resumeDetailCompany(@RequestParam("resumeNo") int resumeNum,
                                      Model model, HttpSession session) {

        // 이력서 번호로 이력서 상세내용 가져오기
        Map<String, String> resumeNo = Map.of("resumeNo", String.valueOf(resumeNum));
        var resumeResponse = apiService.fetchData("/api/resume/detail/resume", resumeNo, true);

        // 이력서 객체를 원하는 타입으로 변환
        Map<String, Object> resume = (Map<String, Object>) resumeResponse.getBody();
        String username = (String) resume.get("username");

        // 이력서 번호의 유저 상세정보 가져오기
        Map<String, String> params = Map.of("username", username);
        var userResponse = apiService.fetchData("/api/resume", params, true);
        var user = userResponse.getBody();

        //이력서 번호로 기술스택 들고오기
        var stackResponse = apiService.fetchData("/api/resume/detail/stack",  resumeNo, true);
        //이력서 번호로 학력 들고오기
        var educationResponse = apiService.fetchData("/api/resume/detail/education",  resumeNo, true);
        //이력서 번호로 경력 들고오기
        var careerListResponse = apiService.fetchData("/api/resume/detail/career",  resumeNo, true);
        //이력서 번호로 자격증 들고오기
        var certificateResponse = apiService.fetchData("/api/resume/detail/certificate",  resumeNo, true);
        //이력서 번호로 포트폴리오 들고오기
        var portfolioResponse = apiService.fetchData("/api/resume/detail/portfolio",  resumeNo, true);

        var stackList =  stackResponse.getBody();
        var educationList =  educationResponse.getBody();
        var careerList =  careerListResponse.getBody();
        var certificateList =  certificateResponse.getBody();
        var portfolioList =  portfolioResponse.getBody();

        model.addAttribute("user", user);
        model.addAttribute("resume", resume);
        model.addAttribute("stackList", stackList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("careerList", careerList);
        model.addAttribute("certificateList", certificateList);
        model.addAttribute("portfolioList", portfolioList);

        System.out.println("resume : " +resume);
        System.out.println("stack 리스트 : " +stackList);
        System.out.println("educationList 리스트 : " +educationList);
        System.out.println("career 리스트 : " + careerList);
        System.out.println("certificate 리스트 : " +certificateList);
        System.out.println("portfolioList 리스트 : " +portfolioList);

        return "/hyepin/resume-detail-company";
    }

    //기업 매칭 페이지
    @GetMapping("/resume/matching")
    public String resumeMatching(Model model, HttpSession session){
        //UserDto user = (UserDto) session.getAttribute( "user");
        //Map<String, String> params = Map.of("username", user.getUsername());

        //가라값
        Map<String, String> params = Map.of("username", "혜빈컴퍼니");
        
        var resumeResponse = apiService.fetchData("/api/resume/company/matching", params, true);
        var resumeList = resumeResponse.getBody();

        System.out.println("프론트 컨트롤러: " + resumeList);
        model.addAttribute("resumeList", resumeList);
        return "/hyepin/resume-matchingList";
    }




}
