package org.green.backend.controller.hws;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.hws.CompanyDetailsDto;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.service.hws.CompanyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-27 (작성자: 한우성)
 * 기업 전용 컨트롤러
 */
@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    public String createCompany(
            @ModelAttribute CompanyDto companyDto,
            @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture,
            @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {

        companyService.saveCompany(companyDto, profilePicture, files);

        return "회원가입 성공";
    }

    @GetMapping("/check/{username}")
    public String duplicateCheck(@PathVariable String username) {
        return companyService.duplicateCheck(username);
    }

    @GetMapping("/{companyName}")
    public CompanyDetailsDto companyDetail(@PathVariable String companyName){
        companyService.companyDetails(companyName,"yiok79");
        return companyService.companyDetails(companyName,"yiok79");
    }

}

