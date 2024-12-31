package org.green.frontend.controller.jeyeon;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.jeyeon.ApplicationResponseDto;
import org.green.frontend.service.ApiRequestService;
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

    @GetMapping("/regist")
    public String applicationRegist(Model model) {
        var careerResponse = apiService.fetchData("/api/gubn/career");
        var positionResponse = apiService.fetchData("/api/gubn/position");
        var educationResponse = apiService.fetchData("/api/gubn/education");
        var employmentResponse = apiService.fetchData("/api/gubn/employment");
        var stackResponse = apiService.fetchData("/api/gubn/stack2nd");
        var stack1thResponse = apiService.fetchData("/api/gubn/stack");
        var applicationResponse = apiService.fetchData("/api/gubn/application");
        var procedureResponse = apiService.fetchData("/api/gubn/procedure");

        /*System.out.println(applicationResponse.getBody());
          System.out.println(positionResponse);*/

        var careerList =  careerResponse.getBody();
        var positionList = positionResponse.getBody();
        var educationList = educationResponse.getBody();
        var employmentList = employmentResponse.getBody();
        var stackList = stackResponse.getBody();
        var stack1thList = stack1thResponse.getBody();
        var applicationList = applicationResponse.getBody();
        var procedureList = procedureResponse.getBody();

        model.addAttribute("careerList", careerList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employmentList", employmentList);
        model.addAttribute("stackList", stackList);
        model.addAttribute("stack1thList", stack1thList);
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

         String content = createJobPost(applicationDto.getContent());

        var companyResponse = apiService.fetchData("/api/application/detail/company/" + applicationDto.getUsername());

        model.addAttribute("companyResponse", companyResponse.getBody());
        model.addAttribute("content", content);
        model.addAttribute("applicationResponse", applicationResponse.getBody());
        return "/jeyeon/application-detail";
    }

    private String createJobPost(String content) {
        // 정규식을 사용하여 두 개 이상의 줄바꿈을 기준으로 항목별로 나누기
        String[] sections = content.split("\\r\\n\\r\\n");  // 2개 이상의 줄바꿈을 기준으로 분리
        StringBuilder htmlContent = new StringBuilder();

        // 섹션 제목 목록
        String[] sectionTitles = {"담당업무", "우대사항", "근무조건", "접수 기간 및 방법", "복리후생"};

        // 섹션 이름에 맞는 스타일 클래스 추가
        for (String section : sections) {
            System.out.println(section + "--------------section");  // 섹션 출력

            // 각 섹션을 제목과 항목으로 분리
            String[] lines = section.split("\\r\\n");  // 각 섹션을 줄바꿈 기준으로 분리
            String title = lines[0].trim();  // 제목은 첫 번째 항목

            // 제목이 sectionTitles 배열에 포함되는지 확인
            boolean isValidTitle = false;
            for (String sectionTitle : sectionTitles) {
                System.out.println(title + "---------");
                System.out.println(sectionTitle);
                if (title.equals(sectionTitle)) {
                    isValidTitle = true;
                    break;
                }
            }

            // 유효한 제목이 있으면 섹션을 추가
            if (isValidTitle) {
                htmlContent.append("<div class=\"section\"><p class=\"section-title\">" + title + "</p><ul class=\"section-content\">");

                // 항목들을 <li> 태그로 추가
                for (int i = 1; i < lines.length; i++) {
                    String item = lines[i].trim(); // 공백 제거
                    if (!item.isEmpty()) { // 빈 항목은 추가하지 않음
                        htmlContent.append("<li>" + item + "</li>");
                    }
                }

                htmlContent.append("</ul></div>");
            }
        }

        System.out.println(htmlContent.toString());  // 생성된 HTML 출력
        return htmlContent.toString();
        }
}
