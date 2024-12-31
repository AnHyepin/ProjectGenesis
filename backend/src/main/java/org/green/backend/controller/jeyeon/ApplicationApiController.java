package org.green.backend.controller.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.service.jeyeon.ApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고 RestController입니다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application/regist")
public class ApplicationApiController {

    private final ApplicationService applicationService;

    @PostMapping
    public void register(@ModelAttribute ApplicationRequestDto applicationRequestDto,
                         @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {

        System.out.println("폼 데이터: " + applicationRequestDto);

        applicationService.registApplication(applicationRequestDto, files);
    }
}
