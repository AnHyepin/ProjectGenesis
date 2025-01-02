package org.green.frontend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서 관련 화면이동 컨트롤러입니다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    private final ApiRequestService apiService;

    @GetMapping
    public String resumeRegist(Model model) {
        // 파라미터를 Map 형태로 구성
        Map<String, String> params = Map.of("username", "혜빈");
        var userResponse = apiService.fetchData("/api/resume",  params, true);
        var user =  userResponse.getBody();


        var jobListResponse = apiService.fetchData("/api/gubn/job");
        var certificateResponse = apiService.fetchData("/api/gubn/certificate");
        var stackResponse = apiService.fetchData("/api/gubn/stack2nd");

        var jobList =  jobListResponse.getBody();
        var stackList =  stackResponse.getBody();
        var certificateList =  certificateResponse.getBody();

        model.addAttribute("user", user);
        model.addAttribute("jobList", jobList);
        model.addAttribute("stackList", stackList);
        model.addAttribute("certificateList", certificateList);


        System.out.println("job 리스트 : " + jobList);
        System.out.println("stack 리스트 : " +stackList);
        System.out.println("certificate 리스트 : " +certificateList);
        return "/hyepin/resume-regist";
    }


}
