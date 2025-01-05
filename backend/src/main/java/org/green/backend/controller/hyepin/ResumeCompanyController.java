package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.common.LikeDto;
import org.green.backend.dto.hyepin.ResumeDto;
import org.green.backend.repository.dao.common.LikeDao;
import org.green.backend.service.common.LikeService;
import org.green.backend.service.hyepin.ResumeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 01-04(작성자: 안혜빈)
 * 이 클래스는 기업용 이력서 전용 RestController컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/resume/company")
@RequiredArgsConstructor
public class ResumeCompanyController {

    private final LikeService likeService;
    private final LikeDao likeDao;

    @GetMapping("/bookmark")
    public int getBookmarkCheck(@RequestParam("username") String username,
                                @RequestParam("likeCode") String likeCode,
                                @RequestParam("likeId") String likeId) throws IOException {
        int bookmarkCheck = likeDao.checkLike(username, likeCode, likeId);
        return bookmarkCheck;
    }



}
