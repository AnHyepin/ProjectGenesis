package org.green.backend.controller.hyepin;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.green.backend.controller.common.LikeController;
import org.green.backend.dto.common.LikeDto;
import org.green.backend.dto.hyepin.OfferDto;
import org.green.backend.dto.hyepin.ResumeDto;
import org.green.backend.repository.dao.common.LikeDao;
import org.green.backend.service.hyepin.OfferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 01-04(작성자: 안혜빈)
 * 이 클래스는 기업용 이력서 전용 RestController컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/resume/company")
@RequiredArgsConstructor
public class ResumeCompanyController {

    private final LikeDao likeDao;
    private final OfferService offerService;

    @GetMapping("/bookmark")
    public int getBookmarkCheck(@RequestParam("username") String username,
                                @RequestParam("likeCode") String likeCode,
                                @RequestParam("likeId") String likeId) throws IOException {
        int bookmarkCheck = likeDao.checkLike(username, likeCode, likeId);
        return bookmarkCheck;
    }

    @GetMapping("/offer")
    public String offer(OfferDto offerDto) throws IOException {
        int result = offerService.registOffer(offerDto);
        if(result == -1) {
            return "포지션 제안 성공";
        }else{
            return "포지션 제안 실패";
        }
    }

    @GetMapping("/matching")
    public List<ResumeDto> resumeMatching (@RequestParam("username") String username) throws IOException {
        List<ResumeDto> resumeList = offerService.getResumeMatchingList();
        for(ResumeDto resume : resumeList){
            int bmCheck = getBookmarkCheck(username, "S", String.valueOf(resume.getResumeNo()));
            System.out.println("username: " + username + "resumeNo: " + resume.getResumeNo());
            System.out.println("bmCheck: " + bmCheck);
            boolean bookmarkCheck = false;
            if(bmCheck == 1){
                bookmarkCheck = true;
            }
            resume.setBookmarkCheck(bookmarkCheck);
        }

        System.out.println("백 컨트롤러: " + resumeList);
        return resumeList;
    }


}
