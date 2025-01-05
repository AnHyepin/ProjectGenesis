package org.green.frontend.controller.hws;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.dto.hws.UserDto;
import org.green.frontend.dto.kwanhyun.CompanyDto;
import org.green.frontend.dto.kwanhyun.CompanyScoreDto;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.green.frontend.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserAndCompanyController {

    private final ApiRequestService apiRequestService;

    @GetMapping("/login")
    public String login() {
        return "hws/login";
    }

    @GetMapping("/join/user")
    public String userJoin() {
        return "hws/join-user";
    }

    @GetMapping("/join/company")
    public String companyJoin() {
        return "hws/join-company";
    }

    @GetMapping("/user-edit")
    public String userEdit(HttpSession session, Model model) {
        UserDto user = SessionUtil.getUser(session);
/*
        if (user == null) {
            log.warn("세션에 유저 정보가 없습니다.");
            return "redirect:/login";
        }*/
        var apiResponse = apiRequestService.fetchData("/api/user/" + "yiok79");
        log.info("apiResponse: {}", apiResponse.getBody());

        Map<String, Object> responseData = (Map<String, Object>) apiResponse.getBody();

        model.addAttribute("user", responseData.get("user"));
        model.addAttribute("file", responseData.get("file"));
        return "hws/user-edit";
    }

    @GetMapping("/company-detail/{company}")
    public String companyDetail(@PathVariable String company, HttpSession session, Model model) {
        UserDto user = SessionUtil.getUser(session);
        Map<String, String> params = new HashMap<>();
        params.put("username", user != null ? user.getUsername() : null);
        
        var apiResponse = apiRequestService.fetchData("/api/company/detail/" + company, params, true);

        model.addAttribute("company", apiResponse.getBody());
        return "hws/company-detail";
    }

    @GetMapping("/company-edit")
    public String companyEdit(HttpSession session, Model model) {
        UserDto company = SessionUtil.getUser(session);

        if (company == null) {
            log.warn("세션에 기업 정보가 없습니다.");
            return "redirect:/login";
        }

        var apiResponse = apiRequestService.fetchData("/api/company/" + company.getUsername());
        log.info("apiResponse: {}", apiResponse.getBody());

        Map<String, Object> responseData = (Map<String, Object>) apiResponse.getBody();

        model.addAttribute("company", apiResponse.getBody());
        return "kwanhyun/company-edit";
    }

    @GetMapping("/companyscore")
    public String companyScore(HttpSession session, Model model) {
        UserDto user = SessionUtil.getUser(session);

        if (user == null) {
            log.warn("세션에 유저 정보가 없습니다.");
            return "redirect:/login";
        }

        var apiResponse = apiRequestService.fetchData("/api/user/companyscore/" + user.getUsername());
        log.info("apiResponse: {}", apiResponse.getBody());

        model.addAttribute("companyScoreList",  apiResponse.getBody());

        return "kwanhyun/companyscore";
    }

    @GetMapping("/bookmarkCompany")
    public String bookmarkCompany(HttpSession session, Model model) {
        UserDto user = SessionUtil.getUser(session);
/*
        if (user == null) {
            log.warn("세션에 유저 정보가 없습니다.");
            return "redirect:/login";
        }*/

        var apiResponse = apiRequestService.fetchData("/api/user/bookmarkCompany/" + user.getUsername());
        log.info("apiResponse: {}", apiResponse.getBody());

        model.addAttribute("bookmarkCompanyList", apiResponse.getBody());

        return "kwanhyun/bookmarkCompany";
    }
}