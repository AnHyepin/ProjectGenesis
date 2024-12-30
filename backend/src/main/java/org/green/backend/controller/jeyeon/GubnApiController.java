package org.green.backend.controller.jeyeon;

import org.green.backend.dto.common.GubnDto;
import org.green.backend.service.common.GubnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 구분 RestController입니다.
 */
@RestController
@RequestMapping("/api/gubn")
public class GubnApiController {

    @Autowired
    private GubnService gubnService;

    @GetMapping("/{gubnCode}")
    public List<GubnDto> getGubnList(@PathVariable String gubnCode) {
        return gubnService.getGubnList(gubnCode + "_code");
    }

    @GetMapping("/stack2nd")
    public List<GubnDto> getSkillList() {
        return gubnService.getSkillList();
    }

}
