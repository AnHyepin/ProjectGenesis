package org.green.backend.controller.hws;
import org.green.backend.dto.hws.UserDto;

import lombok.RequiredArgsConstructor;
import org.green.backend.service.hws.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public String createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "회원가입 성공";
    }

}

