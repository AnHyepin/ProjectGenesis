package org.green.backend.controller.hws;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.CompanyMainDto;
import org.green.backend.dto.hws.MainPageDataDto;
import org.green.backend.service.hws.MainService;
import org.green.backend.utils.JWTUtil;
import org.green.backend.utils.TokenGetUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/main")
public class MainController {

    private final MainService mainService;
    private final TokenGetUtil tokenGetHeaderUtil;
    private final JWTUtil jwtUtil;

    @GetMapping
    public MainPageDataDto nonLoginMain(HttpServletRequest request) {
        String token = tokenGetHeaderUtil.extractToken(request);

        return mainService.getNonLoginPageData(token != null ? jwtUtil.getUsername(token) : null);
    }

    @GetMapping("/company/{username}")
    public CompanyMainDto companyMian(@PathVariable(required = false) String username){
        return mainService.getApplicantsWithDetails(username);
    }

}
