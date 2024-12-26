package org.green.frontend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final ApiRequestService testService;

    @RequestMapping("/")
    public String index() {

        ApiResponse apiResponse = testService.fetchData("/");
        log.info("tttttttttttttttttttttt {}", apiResponse.getBody());

        return "main";
    }
}