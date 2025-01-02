package org.green.frontend.controller.hws;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * TODO : 추후 리펙토링 필요
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainService mainService;
    private final ApiRequestService apiRequestService;

    @GetMapping("/")
    public String nonLoginMain(Model model, HttpServletRequest request, HttpSession session) {
        String token = TokenUtil.getTokenFromCookies(request);
        NonLoginMainDto mainData = mainService.nonLoginMain(token);

        if (token != null) {
            var response = apiRequestService.postDataWithToken("/api/verify-token", null, token);
            if (response.getStatus() == ApiResponse.ApiStatus.SUCCESS && response.getBody() instanceof Map) {

                Map<String, Object> userData = (Map<String, Object>) response.getBody();
                UserDto user = new UserDto();
                user.setUsername((String) userData.get("username"));
                user.setName((String) userData.get("name"));
                user.setRole((String) userData.get("role"));
                session.setAttribute("user", user);

                log.info("세션에 유저 정보 저장: {}", user);
            } else {
                log.warn("유효하지 않은 응답입니다: {}", response);
            }
        } else {
            log.warn("토큰이 존재하지 않습니다.");
        }

        model.addAttribute("mainData", mainData);
        log.info("Main data added to model: {}", mainData);

        return "main";
    }
}