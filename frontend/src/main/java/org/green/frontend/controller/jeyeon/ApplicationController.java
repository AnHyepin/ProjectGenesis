package org.green.frontend.controller.jeyeon;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.jeyeon.ApplicationResponseDto;
import org.green.frontend.service.ApiRequestService;
import org.green.frontend.service.jeyeon.ApplicaitonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고 화면이동 컨트롤러입니다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApiRequestService apiService;
    private final ApplicaitonService applicaitonService;

    @GetMapping("/regist")
    public String applicationRegist(Model model) {
        var careerResponse = apiService.fetchData("/api/gubn/career");
        var positionResponse = apiService.fetchData("/api/gubn/position");
        var educationResponse = apiService.fetchData("/api/gubn/education");
        var employmentResponse = apiService.fetchData("/api/gubn/employment");
        var stackResponse = apiService.fetchData("/api/gubn/stack2nd");
        var jobResponse = apiService.fetchData("/api/gubn/job");
        var applicationResponse = apiService.fetchData("/api/gubn/application");
        var procedureResponse = apiService.fetchData("/api/gubn/procedure");

        /*System.out.println(jobResponse.getBody());
          System.out.println(jobResponse);*/

        var careerList =  careerResponse.getBody();
        var positionList = positionResponse.getBody();
        var educationList = educationResponse.getBody();
        var employmentList = employmentResponse.getBody();
        var stackList = stackResponse.getBody();
        var jobList = jobResponse.getBody();
        var applicationList = applicationResponse.getBody();
        var procedureList = procedureResponse.getBody();

        model.addAttribute("careerList", careerList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employmentList", employmentList);
        model.addAttribute("stackList", stackList);
        model.addAttribute("jobList", jobList);
        model.addAttribute("applicationList", applicationList);
        model.addAttribute("procedureList", procedureList);

        return "/jeyeon/application-regist";
    }

    @GetMapping("/detail/{applicationNo}")
    public String applicationDetail(@PathVariable("applicationNo") int applicationNo, Model model) {
        var applicationResponse = apiService.fetchData("/api/application/detail/" + applicationNo);

        // ObjectMapper를 사용하여 LinkedHashMap을 DTO로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        ApplicationResponseDto applicationDto = objectMapper.convertValue(applicationResponse.getBody(), ApplicationResponseDto.class);

         String content = applicaitonService.createJobPost(applicationDto.getContent());

        var companyResponse = apiService.fetchData("/api/application/detail/company/" + applicationDto.getUsername());

        model.addAttribute("companyResponse", companyResponse.getBody());
        model.addAttribute("fileList",applicationDto.getFileList());
        model.addAttribute("content", content);
        model.addAttribute("skillList",applicationDto.getSkillList());
        model.addAttribute("applicationResponse", applicationResponse.getBody());
        return "/jeyeon/application-detail";
    }


}
