package org.green.frontend.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final ApiRequestService testService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies(); // 요청에서 쿠키 가져오기

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("쿠키 이름: {}, 쿠키 값: {}", cookie.getName(), cookie.getValue());
            }
        } else {
            log.info("요청에 쿠키가 없습니다.");
        }

        ApiResponse apiResponse = testService.fetchData("/");
        log.info("tttttttttttttttttttttt {}", apiResponse.getBody());

        return "main";
    }

}