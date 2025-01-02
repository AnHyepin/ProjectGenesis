package org.green.backend.controller.common;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.common.LikeDto;
import org.green.backend.service.common.LikeService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    /**
     * 좋아요 , 북마크
     *  username 사용자 이름
     *  likeCode 좋아요 코드 (예: S, G)
     *  likeId   좋아요 ID (예: 채용공고 ID, 회사 ID)
     */
    @PostMapping("/toggle")
    public String toggleLike(@RequestBody LikeDto likeDto) {
        log.info("toggleLike {}", likeDto);
        likeService.toggleLike(likeDto.getUsername(), likeDto.getLikeCode(), likeDto.getLikeId());
        return "성공";
    }
}
