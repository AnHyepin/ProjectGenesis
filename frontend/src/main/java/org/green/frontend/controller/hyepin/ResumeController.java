package org.green.frontend.controller.hyepin;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.hyepin.ApplyStatusDto;
import org.green.frontend.dto.jeyeon.GubnDto;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서 관련 화면이동 컨트롤러입니다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    private final ApiRequestService apiService;

    //이력서 등록 페이지
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

    //이력서 목록 페이지
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

    //이력서 상세내용 페이지
    @GetMapping("/detail")
    public String resumeDetail(@RequestParam("resumeNo") int resumeNum,
                                Model model) {

        //유저 상세정보 들고오기
        Map<String, String> params = Map.of("username", "안혜빈");
        var userResponse = apiService.fetchData("/api/resume",  params, true);

        //이력서 번호로 이력서 상세내용 들고오기
        Map<String, String> resumeNo = Map.of("resumeNo", String.valueOf(resumeNum));
        var resumeResponse = apiService.fetchData("/api/resume/detail/resume",  resumeNo, true);
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

        var user =  userResponse.getBody();
        var resume =  resumeResponse.getBody();
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

        return "/hyepin/resume-detail";
    }

    //입사지원현황 리스트 페이지
    @GetMapping("/applyStatus")
    public String resumeApplyStatus(Model model) {

        //지원완료(submitCnt) = list.size()
        //전형진행중(processCnt) = if(list.getApply_status_gbn_code.equals("H"))
        //최종발표(finalCnt) = else

        List<ApplyStatusDto> applyStatusList = new ArrayList<>();

        int submitCnt = 0;
        int processCnt = 0;
        int finalCnt = 0;

        //유저 지원현황 가져오기
        Map<String, String> params = Map.of("username", "안혜빈");
        
        //이거 for문 돌리는 로직
        ApiResponse<?> response = apiService.fetchData("/api/resume/applyStatus", params, true);
        Object body = response.getBody();

        if (body instanceof List) {
           applyStatusList = ((List<?>) body).stream()
                    .map(item -> new ObjectMapper().convertValue(item, ApplyStatusDto.class))
                    .collect(Collectors.toList());

            submitCnt = applyStatusList.size();

            for (ApplyStatusDto applyStatus : applyStatusList) {
                if(applyStatus.getApplyStatusGbnCode().equals("H")){
                    processCnt++;
                }else {
                    finalCnt++;
                }
            }
        } else {
            throw new IllegalStateException("body가 List<ApplyStatusDto>가 아님");
        }

        model.addAttribute("applyStatusList", applyStatusList);
        model.addAttribute("submitCnt", submitCnt);
        model.addAttribute("processCnt", processCnt);
        model.addAttribute("finalCnt", finalCnt);
        return "/hyepin/resume-applyStatus";
    }

}
