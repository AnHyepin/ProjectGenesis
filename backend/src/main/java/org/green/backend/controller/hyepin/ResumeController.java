package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.hyepin.ResumeDto;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;
import org.green.backend.service.hyepin.ResumeService;
import org.green.backend.service.jeyeon.ApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-30 (작성자: 안혜빈)
 * 이 클래스는 이력서 전용 컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public void register(@ModelAttribute ResumeDto resumeDto,
                         @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {

        System.out.println("폼 데이터: " + resumeDto);

        resumeService.registResume(resumeDto, files);
    }
}
