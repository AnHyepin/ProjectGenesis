package org.green.backend.controller.hws;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.TokenUserDto;
import org.green.backend.utils.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class TokenCheck {

    private final JWTUtil jwtUtil;

    public TokenCheck(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/verify-token")
    public TokenUserDto verifyToken(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        log.info("Authorization 헤더 값: {}", authorization);

        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);

            String username = jwtUtil.getUsername(token);
            String role = jwtUtil.getRole(token);
            String name = jwtUtil.getName(token);

            log.info(" 유저 정보 - username: {}, role: {}, name: {}", username, role, name);

            TokenUserDto userDto = new TokenUserDto();
            userDto.setUsername(username);
            userDto.setRole(role);
            userDto.setName(name);

            return userDto;
        }
        log.error("Authorization 헤더가 없거나 올바르지 않습니다.");
        return null;
    }
}
