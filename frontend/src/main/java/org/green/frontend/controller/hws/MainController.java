package org.green.frontend.controller.hws;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.dto.hws.NonLoginMainDto;
import org.green.frontend.dto.hws.UserDto;
import org.green.frontend.service.ApiRequestService;
import org.green.frontend.service.MainService;
import org.green.frontend.utils.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        TokenUtil.verifyTokenAndSetSession(token, apiRequestService, session);

        model.addAttribute("mainData", mainData);
        log.info("메인 데이터: {}", mainData);

        return "main";
    }

    @GetMapping("/company")
    public String companyMain(HttpServletRequest request, HttpSession session, Model model) {
        String token = TokenUtil.getTokenFromCookies(request);

        UserDto user = TokenUtil.verifyTokenAndSetSession(token, apiRequestService, session);

        if (user == null || (!"ROLE_COMPANY".equals(user.getRole()) && !"ROLE_ADMIN".equals(user.getRole()))) {
            log.warn("권한 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return "redirect:/login";
        }

        var apiResponse = apiRequestService.fetchData("/api/main/company/" + user.getUsername());
        log.info("메인 데이터 {}", apiResponse.getBody());

        model.addAttribute("mainData", apiResponse.getBody());

        return "/company-main";
    }
}
