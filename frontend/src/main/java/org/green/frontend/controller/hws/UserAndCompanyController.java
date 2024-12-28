package org.green.frontend.controller.hws;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAndCompanyController {


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
}
