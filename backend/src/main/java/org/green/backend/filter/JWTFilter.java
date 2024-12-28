package org.green.backend.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.entity.Company;
import org.green.backend.entity.User;
import org.green.backend.global.common.ApiResponse;
import org.green.backend.global.common.ErrorResponse;
import org.green.backend.service.common.CustomUserDetails;
import org.green.backend.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

/*
    //TODO: 추후 수정 아직 어떻게 처리할 지 명확하지 않음.
    private static final List<String> EXCLUDED_PATHS = List.of("/login", "/api/company", "/api/user");

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return EXCLUDED_PATHS.stream().anyMatch(path::equals);
    }
*/


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        String token = extractToken(request);

        if (token == null) {
            log.error("유효하지 않은 토큰");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            if (jwtUtil.isExpired(token)) {
                log.error("토큰이 만료되었습니다");
                sendErrorResponse(response, "토큰이 만료되었습니다", HttpStatus.UNAUTHORIZED);
                return;
            }
        } catch (ExpiredJwtException e) {
            log.error("토큰 만료 예외 발생: {}", e.getMessage());
            sendErrorResponse(response, "토큰이 만료되었습니다", HttpStatus.UNAUTHORIZED);
            return;
        } catch (Exception e) {
            log.error("JWT 검증 실패: {}", e.getMessage());
            sendErrorResponse(response, "유효하지 않은 토큰", HttpStatus.UNAUTHORIZED);
            return;
        }


        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        log.info("JWT 추출  - username: {}, role: {}", username, role);

        try {
            setAuthentication(username, role);
        } catch (IllegalArgumentException e) {
            log.error("인증 실패: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("누구냐 넌?");
            return;
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Authorization 헤더에서 JWT 토큰을 추출
     */
    private String extractToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.split(" ")[1];
        }
        return null;
    }

    /**
     * username과 role 정보를 사용해 SecurityContext에 인증 정보 저장
     */
    private void setAuthentication(String username, String role) {
        Object entity = createEntity(username, role);

        if ("ROLE_USER".equals(role) && entity instanceof User userEntity) {
            CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
            saveToSecurityContext(customUserDetails, username, role);

        } else if ("ROLE_ADMIN".equals(role) && entity instanceof User userEntity) {
            CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
            saveToSecurityContext(customUserDetails, username, role);

        } else if ("ROLE_COMPANY".equals(role) && entity instanceof Company companyEntity) {
            CustomUserDetails customUserDetails = new CustomUserDetails(companyEntity);
            saveToSecurityContext(customUserDetails, username, role);

        } else {
            throw new IllegalArgumentException("누구냐 넌 : " + role);
        }
    }

    /**
     * SecurityContext에 인증 정보를 저장
     */
    private void saveToSecurityContext(CustomUserDetails customUserDetails, String username, String role) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                customUserDetails, null, customUserDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
        log.info("SecurityContext에 인증 정보 저장 완료: username={}, role={}", username, role);
    }

    /**
     * 역할(role)에 따라 유저 또는 기업 엔티티 생성
     */
    private Object createEntity(String username, String role) {
        if ("ROLE_USER".equals(role) || "ROLE_ADMIN".equals(role)) {
            User userEntity = new User();
            userEntity.setUsername(username);
            userEntity.setPassword("temppassword");
            userEntity.setRole(role);
            return userEntity;

        } else if ("ROLE_COMPANY".equals(role)) {
            Company companyEntity = new Company();
            companyEntity.setUsername(username);
            companyEntity.setPassword("temppassword");
            companyEntity.setRole(role);
            return companyEntity;

        } else {
            throw new IllegalArgumentException("누구냐 넌? : " + role);
        }
    }

    /**
     * 에러 응답을 생성하여 클라이언트로 전송
     * TODO: 추후 수정
     */
    private void sendErrorResponse(HttpServletResponse response, String message, HttpStatus status) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse(null, message, status);

        ApiResponse<ErrorResponse> apiResponse = new ApiResponse<>(
                ApiResponse.ApiStatus.ERROR,
                errorResponse,
                false
        );

        ObjectMapper objectMapper = new ObjectMapper();

        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
    }

}