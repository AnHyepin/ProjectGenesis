package org.green.backend.controller.hws;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.MainPageDataDto;
import org.green.backend.service.hws.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/main")
public class MainController {

    private final MainService mainService;

    @GetMapping
    public MainPageDataDto nonLoginMain() {
        return mainService.getNonLoginPageData();
    }

}
