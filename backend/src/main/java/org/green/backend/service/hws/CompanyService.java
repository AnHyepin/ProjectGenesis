package org.green.backend.service.hws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.entity.Company;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.repository.jpa.hws.CompanyRepository;
import org.modelmapper.ModelMapper;
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

        companyRepository.save(companyEntity);
    }
}