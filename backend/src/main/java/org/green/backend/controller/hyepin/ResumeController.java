package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.green.backend.service.hyepin.ResumeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 12-30 (작성자: 안혜빈)
 * 이력서 전용 컨트롤러
 */
@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/")
    public void registResume() {
        System.out.println("백엔드 서비스 와지냐?");
    }
}
