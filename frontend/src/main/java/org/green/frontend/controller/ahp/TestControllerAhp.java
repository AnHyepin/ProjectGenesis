package org.green.frontend.controller.ahp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControllerAhp {

    @GetMapping("/test")
    public String root() {
        return "/layout-test/company-main-layout";
    }
    @GetMapping("/test1")
    public String test1() {
        return "/layout-test/user-main-layout";
    }

    @GetMapping("/test2")
    public String test2() {
        return "/layout-test/guest-main-layout";
    }

    @GetMapping("/test3")
    public String test3() {
        return "/layout-test/deployment";
    }

    @GetMapping("/test4")
    public String test4() {
        return "/layout-test/layout-test2";
    }

}
