package org.green.frontend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.jeyeon.GubnDto;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Map<String, String> params = Map.of("username", "안혜빈");
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

    @GetMapping("/list")
    public String resumeList(Model model) {
        //유저 이력서 가져오기
        Map<String, String> params = Map.of("username", "안혜빈");
        //지원한 숫자까지 포함해서 가져오기
        var resumeListResponse = apiService.fetchData("/api/resume/list",  params, true);
        var applyCountResponse = apiService.fetchData("/api/resume/count",  params, true);
        var resumeList =  resumeListResponse.getBody();
        var applyCount =  applyCountResponse.getBody();

        model.addAttribute("resumeList", resumeList);
        model.addAttribute("count", applyCount);
        return "/hyepin/resume-list";
    }

    @GetMapping("/detail")
    public String resumeDetail(@RequestParam("resumeNo") int resumeNo,
                                Model model) {
        System.out.println("resumeNo: " + resumeNo);
        return "/hyepin/resume-detail";
    }

}
