package org.green.frontend.controller.hws;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.green.frontend.dto.hws.NonLoginMainDto;
import org.green.frontend.dto.hws.UserDto;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.green.frontend.service.MainService;
import org.green.frontend.utils.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 메인 페이지 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainService mainService;
    private final ApiRequestService apiRequestService;

    @GetMapping("/")
    public String nonLoginMain(Model model, @RequestParam(required = false) UserDto userDto, HttpServletRequest request) {
        NonLoginMainDto mainData = mainService.nonLoginMain();


        Map<String, String> params = Map.of("id", "테스트용");
        
        ApiResponse apiResponse = apiRequestService.fetchData("/test5",params,true);

        log.info(apiResponse.toString() +" aaaaa");

        String token = TokenUtil.getTokenFromCookies(request);

        ApiResponse response = apiRequestService.postDataWithToken("/api/verify-token", null, token);
        log.info(response.toString());

        //log.info("유저 체크 {} ", userDto);

        model.addAttribute("mainData", mainData);

/*        log.info("메인 데이터 모델에 추가 완료: {}", mainData);
        log.info("메인 데이터 모델에 추가 완료1: {}", mainData.getPopularApplications());
        log.info("메인 데이터 모델에 추가 완료2: {}", mainData.getTopRatedCompanies());
        log.info("메인 데이터 모델에 추가 완료3: {}", mainData.getLikeApplications());
        log.info("메인 데이터 모델에 추가 완료4: {}", mainData.getBookmarkApplications());*/

        return "main";
    }
}
