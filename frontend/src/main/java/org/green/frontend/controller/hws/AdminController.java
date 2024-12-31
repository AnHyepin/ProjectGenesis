package org.green.frontend.controller.hws;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.service.AdminService;
import org.green.frontend.utils.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminController {


    private final AdminService adminService;

    @GetMapping
    public String adminUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request,
            Model model
    ) {
        String token = TokenUtil.getTokenFromCookies(request);
        log.info(token+"ASdfsafdsaf");

        var result = adminService.getAdminUsers(page, size, token);

        model.addAttribute("users", result.get("users"));
        model.addAttribute("paging", result.get("paging"));

        return "/hws/admin-user";
    }

    @GetMapping("/company")
    public String adminCompany(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,            HttpServletRequest request,

            Model model
    ) {
        String token = TokenUtil.getTokenFromCookies(request);

        var result = adminService.getAdminCompany(page, size, token);
        model.addAttribute("users", result.get("users"));
        model.addAttribute("paging", result.get("paging"));

        return "/hws/admin-company";
    }

}
