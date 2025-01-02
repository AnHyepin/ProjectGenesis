package org.green.frontend.utils;

import jakarta.servlet.http.HttpSession;
import org.green.frontend.dto.hws.UserDto;
import org.green.frontend.dto.kwanhyun.CompanyDto;

public class SessionUtil {

    private static final String USER_SESSION_KEY = "user";

    /**
     * 세션에서 UserDto를 가져옴
     * @return UserDto 세션에 저장된 유저 정보, 없으면 null
     */
    public static UserDto getUser(HttpSession session) {
        Object attribute = session.getAttribute(USER_SESSION_KEY);
        if (attribute instanceof UserDto) {
            return (UserDto) attribute;
        }
        return null;
    }

 /*   private static final String COMPANY_SESSION_KEY = "company";

    public static CompanyDto getCompany(HttpSession session) {
        Object attribute = session.getAttribute(COMPANY_SESSION_KEY);
        if (attribute instanceof CompanyDto) {
            return (CompanyDto) attribute;
        }
        return null;
    }*/

}