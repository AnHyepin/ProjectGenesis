package org.green.backend.controller.jeyeon;

import org.green.backend.dto.jeyeon.GubnDto;
import org.green.backend.service.jeyeon.GubnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/career")
    public List<GubnDto> careerList() {
        List<GubnDto> careerList = gubnService.getCareerList();
        return careerList;
    }

    @GetMapping("/position")
    public List<GubnDto> positionList() {
        List<GubnDto> positionList = gubnService.getPostionList();
        return positionList;
    }

    @GetMapping("/education")
    public List<GubnDto> educationList() {
        List<GubnDto> educationList = gubnService.getEducationList();
        return educationList;
    }

    @GetMapping("/employment")
    public List<GubnDto> employmentList() {
        List<GubnDto> employmentList = gubnService.getEmploymentList();
        return employmentList;
    }

    @GetMapping("/stack")
    public List<GubnDto> stackList() {
        List<GubnDto> stackList = gubnService.getStackList();
        return stackList;
    }

    @GetMapping("/stack1th")
    public List<GubnDto> stack1thList() {
        List<GubnDto> stack1thList = gubnService.getStack1thList();
        return stack1thList;
    }

    @GetMapping("/application")
    public List<GubnDto> applicationList() {
        List<GubnDto> applicationList = gubnService.getApplicationList();
        return applicationList;
    }

    @GetMapping("/procedure")
    public List<GubnDto> procedureList() {
        List<GubnDto> procedureList = gubnService.getProcedureList();
        return procedureList;
    }
}
