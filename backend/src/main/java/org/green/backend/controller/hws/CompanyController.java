package org.green.backend.controller.hws;

import lombok.RequiredArgsConstructor;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.service.hws.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping()
    public String createCompany(@RequestBody CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
        return "회원가입 성공";
    }

}
