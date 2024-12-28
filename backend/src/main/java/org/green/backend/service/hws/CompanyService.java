package org.green.backend.service.hws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.entity.Company;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.repository.jpa.hws.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public void saveCompany(CompanyDto company) {
        log.info("save company {}", company);

        Boolean isExist = companyRepository.existsByUsername(company.getUsername());

        if (isExist) {
            throw new UserAlreadyExistsException("해당 아이디 : '" + company.getUsername() + "' 중복된 아이디 입니다. ");
        }

        Company companyEntity = modelMapper.map(company, Company.class);
        companyEntity.setPassword(passwordEncoder.encode(companyEntity.getPassword()));
        companyEntity.setDeleteYn('N'); //TODO: 유저쪽과 더불어 추후제거 일단임시

        companyRepository.save(companyEntity);
    }

    public Page<CompanyDto> getAllUsers(Pageable pageable) {

        Page<Company> companyPage = companyRepository.findAll(pageable);
        return companyPage.map(company -> modelMapper.map(company, CompanyDto.class));
    }

    public String companyStatusChange(String username) {
        Company company = companyRepository.findByUsername(username);

        if (company == null) {
            return "변경 실패";
        }

        log.info(company.toString());

        company.setDeleteYn(company.getDeleteYn().equals('Y') ? 'N' : 'Y');

        companyRepository.save(company);
        return "변경 성공";
    }
}