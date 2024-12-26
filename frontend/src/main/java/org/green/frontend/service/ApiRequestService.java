package org.green.frontend.service;

import lombok.extern.slf4j.Slf4j;
import org.green.frontend.global.ApiResponse;
import org.springframework.stereotype.Service;
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
     *
     * 파라미터가 있는 GET 요청
     * Map<String, String> params = Map.of("key", "value");
     * ApiResponse response = apiRequestService.fetchData("/login", params);
     *
     * TODO: 파라미터 있는 요청은 아직 테스트 안 해봤음. 때문에 테스트 후 수정 될 수 있음.
     *
     */
    public ApiResponse fetchData(String uri, Map<String, String> params) {
        return webClient
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path(uri);
                    if (params != null && !params.isEmpty()) {
                        params.forEach(uriBuilder::queryParam);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .onErrorResume(e -> {
                    log.error("APi 에러 떴어용", e);
                    return Mono.just(new ApiResponse<>(ApiResponse.ApiStatus.ERROR, e.getMessage()));
                })
                .block();
    }

    public ApiResponse fetchData(String uri) {
        return fetchData(uri, null);
    }
}