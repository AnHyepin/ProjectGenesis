package org.green.backend.controller.hws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.UserDto;
import org.green.backend.service.hws.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * 12-27 (작성자: 한우성)
 * 구직자 전용 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createUser(@ModelAttribute UserDto userDto, @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture) throws IOException {
        userService.saveUser(userDto, profilePicture);
        return "회원가입 성공";
    }

    @GetMapping("/{username}")
    public String duplicateCheck(@PathVariable String username) {
        return userService.duplicateCheck(username);
    }

}