package org.green.frontend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.dto.hws.NonLoginMainDTO;
import org.green.frontend.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인 페이지 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String nonLoginMain(Model model) {
        NonLoginMainDTO mainData = mainService.nonLoginMain();

        model.addAttribute("mainData", mainData);

        log.info("메인 데이터 모델에 추가 완료: {}", mainData);
        log.info("메인 데이터 모델에 추가 완료1: {}", mainData.getPopularApplications());
        log.info("메인 데이터 모델에 추가 완료2: {}", mainData.getTopRatedCompanies());

        return "main";
    }
}
