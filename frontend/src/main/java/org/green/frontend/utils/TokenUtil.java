package org.green.frontend.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

    private static final String TOKEN_COOKIE_NAME = "Authorization";

    /**
     * 쿠키에서 토큰을 추출하여 반환.
     * 토큰없을 때 이미 webClicent에서 처리해놨기 떄문에
     * 따로 예외처리 필요없음
     * TODO : 추후 상세한 예외 필요하다면 추가될 수 있음
     */

    public static String getTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Authorization".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
