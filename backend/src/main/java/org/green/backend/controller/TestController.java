package org.green.backend.controller;


import org.green.backend.dto.TestDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "12345512313213ccccccccc1231zzzzzzzzzzzzzzzzzdddddddddddddddd2312312355";
    }

    @PostMapping("/test2")
    public String postTest(@RequestBody TestDto request) {
        System.out.println("테스트@@@@@@@@@@@@@@@@@@@@@@@ " + request.toString());
        return "success";
    }

    @PutMapping("/test3")
    public String putTest(@RequestBody TestDto request) {
        System.out.println("테스트@@@@@@@@@@@@@@@@@@@@@@@ " + request.toString());

        return "success";
    }

    @DeleteMapping("/test4")
    public String deleteTest(@RequestParam String id) {
        System.out.println("테스트@@@@@@@@@@@@@@@@@@@@@@@ " + id);

        return "success";
    }

}
