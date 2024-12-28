package org.green.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.utils.PagingBtn;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final ApiRequestService apiRequestService;
    private final ObjectMapper objectMapper;
    private static final int PAGE_BUTTON_COUNT = 5;

    public Map<String, Object> getAdminUsers(int page, int size) {
        return fetchAndProcessData("/api/admin", page, size);
    }

    public Map<String, Object> getAdminCompany(int page, int size) {
        return fetchAndProcessData("/api/admin/company", page, size);
    }

    private Map<String, Object> fetchAndProcessData(String endpoint, int page, int size) {
        // TODO: 토큰 삭제 해야함 테스트를 위한 임시용임
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Inlpb2s3OSIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzM1MzYyMTcyLCJleHAiOjE3MzU0NDg1NzJ9.5VWkK-DnRNu7A7qCMXowX1Ohf4mfK5IzR5yb4Mex-sI";

        var response = apiRequestService.fetchData(endpoint, Map.of("page", String.valueOf(page), "size", String.valueOf(size)), token);

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
