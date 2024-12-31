package org.green.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.utils.PagingBtn;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 12-27 (작성자: 한우성)
 * 관리자 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final ApiRequestService apiRequestService;
    private final ObjectMapper objectMapper;
    private static final int PAGE_BUTTON_COUNT = 5;

    /**
     * 관리자 사용자 정보를 조회.
     */
    public Map<String, Object> getAdminUsers(int page, int size, String token) {
        return fetchAndProcessData("/api/admin", page, size,token);
    }

    /**
     * 관리자 회사 정보를 조회.
     */
    public Map<String, Object> getAdminCompany(int page, int size,String token) {
        return fetchAndProcessData("/api/admin/company", page, size,token);
    }

    private Map<String, Object> fetchAndProcessData(String endpoint, int page, int size,String token) {

        var response = apiRequestService.fetchData(endpoint, Map.of("page", String.valueOf(page), "size", String.valueOf(size)), token,false);

        log.info(String.valueOf(response));

        var body = response.getBody();

        if (body instanceof Map) {
            Map bodyMap = objectMapper.convertValue(body, Map.class);

            int totalElements = (int) bodyMap.get("totalElements");
            int currentPage = (int) bodyMap.get("number") + 1;
            PagingBtn pagingBtn = new PagingBtn(totalElements, currentPage, size, PAGE_BUTTON_COUNT);

            return Map.of(
                    "users", bodyMap.get("content"),
                    "paging", pagingBtn
            );
        }
        return Map.of();
    }
}
