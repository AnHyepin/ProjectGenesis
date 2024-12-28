package org.green.frontend.service;

import lombok.extern.slf4j.Slf4j;
import org.green.frontend.exception.UnauthorizedAccessException;
import org.green.frontend.global.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
public class ApiRequestService {

    private final WebClient webClient;

    public ApiRequestService(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * 사용방법
     * 파라미터 없는 GET 요청
     * ApiResponse response = apiRequestService.fetchData("/login");
     * <p>
     * 파라미터가 있는 GET 요청
     * Map<String, String> params = Map.of("key", "value");
     * ApiResponse response = apiRequestService.fetchData("/login", params);
     * <p>
     */
    public ApiResponse fetchData(String uri, Map<String, String> params, String token) {
        try {
            return webClient
                    .get()
                    .uri(uriBuilder -> {
                        uriBuilder.path(uri);
                        if (params != null && !params.isEmpty()) {
                            params.forEach(uriBuilder::queryParam);
                        }
                        return uriBuilder.build();
                    })
                    .headers(headers -> {
                        if (token != null && !token.isEmpty()) {
                            headers.setBearerAuth(token);
                        }
                    })
                    .exchangeToMono(this::handleResponseWithAuthCheck)
                    .block();
        } catch (UnauthorizedAccessException e) {
            throw e;
        }
    }

    public ApiResponse fetchData(String uri) {
        return fetchData(uri, null, null);
    }

    public ApiResponse fetchData(String uri, Map<String, String> params) {
        return fetchData(uri, params, null);
    }


    //TODO: 차후 기능 개선
    private Mono<ApiResponse> handleResponseWithAuthCheck(ClientResponse response) {
        HttpStatus statusCode = (HttpStatus) response.statusCode();

        if (statusCode == HttpStatus.FORBIDDEN) {
            return response.bodyToMono(String.class)
                    .flatMap(errorBody -> {
                        log.error("403 Forbidden 에러 발생: {}", errorBody);
                        throw new UnauthorizedAccessException("권한 없음");
                    });
        }

        if (statusCode == HttpStatus.UNAUTHORIZED) {
            return response.bodyToMono(String.class)
                    .flatMap(errorBody -> {
                        log.error("401 Unauthorized 에러 발생: {}", errorBody);
                        throw new UnauthorizedAccessException("인증 실패: 유효하지 않은 토큰");
                    });
        }
        return response.bodyToMono(Map.class)
                .map(body -> {
                    if (statusCode.is2xxSuccessful()) {
                        ApiResponse<Object> apiResponse = new ApiResponse<>(ApiResponse.ApiStatus.SUCCESS, body.get("body"));
                        log.info("데이터 {} ", apiResponse);
                        return apiResponse;
                    } else {
                        log.error("HTTP {} 에러: {}", statusCode.value(), body);
                        return new ApiResponse<>(ApiResponse.ApiStatus.ERROR, "HTTP " + statusCode.value() + " - " + body, statusCode.value());
                    }
                });
    }
}