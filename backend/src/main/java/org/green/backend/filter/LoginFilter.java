package org.green.backend.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.global.common.ApiResponse;
import org.green.backend.global.common.ErrorResponse;
import org.green.backend.service.common.CustomUserDetails;
import org.green.backend.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Map;

/**
 * 2024-12-29(한우성)
 * 로그인 성공 및 실패를 처리하는 필터
 * 성공시 쿠키에 jwt 토큰을 담고  username,role을 반환
 */
@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> jsonRequest = objectMapper.readValue(body, Map.class);

            String username = jsonRequest.get("username");
            String password = jsonRequest.get("password");

            if (username == null || password == null) {
                throw new RuntimeException("Username 또는 Password가 비었음 하지만 프론트에서 처리했기 때문에 안오겠지?");
            }

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
            return authenticationManager.authenticate(authToken);

        } catch (IOException e) {
            throw new RuntimeException("파싱 오류 ", e);
        }
    }


    /**
     * 로그인 성공 처리
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공이요");

        CustomUserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();
        String username = userDetails.getUsername();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        String name = userDetails.getName();

        String token = jwtUtil.createJwt(username, role, 60 * 60 * 24 * 1000L);


        Cookie cookie = new Cookie("Authorization", token);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);


        log.info("JWT 쿠키 설정 완료: {}", token);
        Map<String, String> userInfo = Map.of("username", username, "role", role ,"name",name);
        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>(
                ApiResponse.ApiStatus.SUCCESS,
                userInfo,
                false
        );


        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));

        log.info("로그인 성공: username={}, role={}", username, role);
    }

    /**
     * 로그인 실패 처리
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        log.error("로그인 실패 이유: {}", failed.getMessage());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ErrorResponse errorResponse = new ErrorResponse(null, "아이디 또는 비밀번호를 확인해주세요.", HttpStatus.UNAUTHORIZED);

        ApiResponse<ErrorResponse> apiResponse = new ApiResponse<>(
                ApiResponse.ApiStatus.ERROR,
                errorResponse,
                false
        );

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
    }

}
