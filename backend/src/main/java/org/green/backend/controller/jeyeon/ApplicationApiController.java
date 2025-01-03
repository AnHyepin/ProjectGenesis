package org.green.backend.controller.jeyeon;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.common.GubnDto;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.dto.jeyeon.ApplicationResponseDto;
import org.green.backend.entity.Application;
import org.green.backend.entity.Company;
import org.green.backend.service.common.GubnService;
import org.green.backend.service.hws.CompanyService;
import org.green.backend.service.jeyeon.ApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고 RestController입니다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationApiController {

    private final ApplicationService applicationService;
    private final GubnService gubnService;

    @PostMapping("/regist")
    public void register(@ModelAttribute ApplicationRequestDto applicationRequestDto,
                         @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {

        System.out.println("폼 데이터: " + applicationRequestDto);

        applicationService.registApplication(applicationRequestDto, files);
    }

    @GetMapping("/detail/{applicationNo}")
    public ApplicationResponseDto detail(@PathVariable("applicationNo") int applicationNo) {
        return applicationService.getApplication(applicationNo);
    }

    @GetMapping("/detail/company/{username}")
    public Company getCompany(@PathVariable("username") String username) {
        return applicationService.getApplicationCompany(username);
    }

    @GetMapping("/{stackCode}")
    public List<GubnDto> getGubnList(@PathVariable String stackCode) {
        return gubnService.getSkillName(stackCode);
    }

    @GetMapping("/list")
    public List<ApplicationResponseDto> getApplicationList() {
        return applicationService.getApplicationList();
    }
}
