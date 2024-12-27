package org.green.frontend.controller.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고 화면이동 컨트롤러입니다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {


    private final ApiRequestService apiService;


    @GetMapping("/regist")
    public String applicationRegist(Model model) {
        var careerResponse = apiService.fetchData("/api/gubn/career");
        var positionResponse = apiService.fetchData("/api/gubn/position");
        var educationResponse = apiService.fetchData("/api/gubn/education");
        var employmentResponse = apiService.fetchData("/api/gubn/employment");
        var stackResponse = apiService.fetchData("/api/gubn/stack");
        var stack1thResponse = apiService.fetchData("/api/gubn/stack1th");
        var applicationResponse = apiService.fetchData("/api/gubn/application");

        /*System.out.println(applicationResponse.getBody());
          System.out.println(positionResponse);*/

        var careerList =  careerResponse.getBody();
        var positionList = positionResponse.getBody();
        var educationList = educationResponse.getBody();
        var employmentList = employmentResponse.getBody();
        var stackList = stackResponse.getBody();
        var stack1thList = stack1thResponse.getBody();
        var applicationList = applicationResponse.getBody();

        model.addAttribute("careerList", careerList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employmentList", employmentList);
        model.addAttribute("stackList", stackList);
        model.addAttribute("stack1thList", stack1thList);
        model.addAttribute("applicationList", applicationList);

        return "/jeyeon/application-regist";
    }
}
