package org.green.backend.controller.hws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.CompanyDetailsDto;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.dto.hws.RatingDto2;
import org.green.backend.service.hws.CompanyService;
import org.green.backend.utils.JWTUtil;
import org.green.backend.utils.TokenGetUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 12-27 (작성자: 한우성)
 * 기업 전용 컨트롤러
 * 01-02 (작성자: 노관현)
 * 기업정보조회, 수정 추가
 */
@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    private final TokenGetUtil tokenGetUtil;
    private final JWTUtil jwtUtil;


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

    @GetMapping("/{username}")
    public CompanyDto getUser(@PathVariable String username) {
        return companyService.getCompanyByUsername(username);
    }

    @PutMapping
    public String updateCompany(@ModelAttribute CompanyDto companyDto) throws IOException {

        log.info(companyDto.toString());
        companyService.updateCompany(companyDto);

        return null;
    }

    @GetMapping("/detail/{companyName}")
    public CompanyDetailsDto companyDetail(@PathVariable String companyName, @RequestParam String username) {
        return companyService.companyDetails(companyName, username);
    }

    @PostMapping("/rating")
    public String ratingSave(@RequestBody RatingDto2 rating) {
        log.info("ratingadsfasf{}",rating);
        return companyService.ratingSave(rating);
    }

    @PutMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        return companyService.deleteUser(username);
    }

}

