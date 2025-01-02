package org.green.backend.service.hws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.CompanyDetailsDto;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.entity.Company;
import org.green.backend.entity.common.Address;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.repository.dao.hws.CompanyDao2;
import org.green.backend.repository.dao.kwanhyun.CompanyDao;
import org.green.backend.repository.jpa.hws.CompanyRepository;
import org.green.backend.service.common.FileService;
import org.green.backend.utils.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 12-27 (작성자: 한우성)
 * 기업 정보를 관리하는 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final FileService fileService;
    private final CompanyDao companyDao;
    private final CompanyDao2 companyDao2;

    /**
     * 회사 정보를 저장하고 프로필 및 관련 파일을 저장
     */
    public void saveCompany(CompanyDto company, MultipartFile profilePicture, List<MultipartFile> files) throws IOException {
        log.info("save company {}", company);

        Boolean isExist = companyRepository.existsByUsername(company.getUsername());

        if (isExist) {
            throw new UserAlreadyExistsException("해당 아이디 : '" + company.getUsername() + "' 중복된 아이디 입니다. ");
        }

        Company companyEntity = modelMapper.map(company, Company.class);
        companyEntity.setPassword(passwordEncoder.encode(companyEntity.getPassword()));
        Address address = company.toAddress();
        companyEntity.setAddress(address);
        companyEntity.setDeleteYn('N');

        companyRepository.save(companyEntity);

        if (profilePicture != null && !profilePicture.isEmpty()) {
            fileService.saveFile(profilePicture, "profile_company", company.getUsername(), company.getUsername());
        }

        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                fileService.saveFile(file, "company_detail", company.getUsername(), file.getOriginalFilename());
            }
        }
    }

    /**
     * 모든 회사 사용자 정보를 페이징  조회
     */
    public Page<CompanyDto> getAllUsers(Pageable pageable) {

        Page<Company> companyPage = companyRepository.findAll(pageable);
        return companyPage.map(company -> modelMapper.map(company, CompanyDto.class));

    }

    /**
     * 회사의 상태(삭제 여부)를 변경
     */
    public String companyStatusChange(String username) {

        Company company = companyRepository.findByUsername(username);

        if (company == null) {
            return "변경 실패";
        }

        company.setDeleteYn(company.getDeleteYn().equals('Y') ? 'N' : 'Y');
        companyRepository.save(company);

        return "변경 성공";
    }

    /**
     * 회사 사용자 아이디의 중복 여부 체크
     */
    public String duplicateCheck(String username) {
        return companyRepository.findByUsername(username) != null ? "중복됨" : "사용 가능";
    }

    /**
     * 회사 정보 조회 - 관현(25.01.02. 12:30)
     */
    public CompanyDto getCompanyByUsername(String username) {
        CompanyDto company = companyDao.findCompanyByUsername(username);
        company.setAddress(company.toAddress());


        if (company != null) {
            return company;
        }
        return null;
    }

    /**
     * 회사 정보 수정 - 관현(25.01.02. 14:00)
     */
    public String updateCompany(CompanyDto companyDto) {
        CompanyDto company = companyDao.findCompanyByUsername(companyDto.getUsername());
        companyDao.updateCompany(company);

        return "성공";
    }


    public CompanyDetailsDto companyDetails(String companyName, String username) {
        List<CompanyDetailsDto> companyDetailsList = companyDao2.companyDetails(companyName, username);

        if (companyDetailsList.isEmpty()) {
            return null;
        }

        CompanyDetailsDto newDetails = companyDetailsList.get(0);

        List<CompanyDetailsDto.InnerApplication> applications = new ArrayList<>();

        for (CompanyDetailsDto details : companyDetailsList) {
            if (details.getApplications() != null) {
                for (CompanyDetailsDto.InnerApplication app : details.getApplications()) {
                    if (!applications.contains(app)) {
                        if (app.getFiles() == null || app.getFiles().isEmpty()) {
                            app.setFiles(null);
                        }
                        app.setDaysLeft(DateUtil.calculateDaysLeft(app.getDeadlineDate()));
                        applications.add(app);
                    }
                }
            }
        }

        newDetails.setApplications(applications);
        return newDetails;
    }


}
