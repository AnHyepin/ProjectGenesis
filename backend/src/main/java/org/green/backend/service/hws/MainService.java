package org.green.backend.service.hws;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.MainPageDataDto;
import org.green.backend.dto.hws.PopularApplicationDto;
import org.green.backend.dto.hws.RatingApplicationDTO;
import org.green.backend.entity.Application;
import org.green.backend.entity.File;
import org.green.backend.repository.jpa.common.FileRepository;
import org.green.backend.repository.jpa.hws.ApplicationRepository;
import org.green.backend.repository.jpa.hws.ApplyStatusRepository;
import org.green.backend.repository.jpa.hws.RatingRepository;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2024-12-29 한우성
 * 메인화면에 들어가는 데이터 서비스
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final ApplyStatusRepository applyStatusRepository;
    private final RatingRepository ratingRepository;
    private final ApplicationRepository applicationRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;


    /**
     * 비회원 메인 화면 데이터
     */
    public MainPageDataDto getNonLoginPageData() {
        List<RatingApplicationDTO> topRatedCompanies = getTopRatingApplication(3);
        List<PopularApplicationDto> popularApplications = getPopularApplications();

        return new MainPageDataDto(topRatedCompanies, popularApplications);
    }


    /**
     * 별점 높은 기업 의 공고 한개씩 들고오는거
     */
    public List<RatingApplicationDTO> getTopRatingApplication(int limit) {
        List<RatingApplicationDTO> topCompanies = ratingRepository.findTopRatedCompanies();
        log.info("asdadasfa111111111s{}", topCompanies);
        topCompanies.forEach(dto -> {
            Application latestApplication = applicationRepository.findLatestApplicationByCompany(dto.getUsername());
            if (latestApplication != null) {
                List<File> files = fileRepository.findFilesByApplicationNo(latestApplication.getApplicationNo());
                dto.setApplication(latestApplication);
                dto.setFiles(files);
            }
            dto.setApplication(latestApplication);
        });
        return topCompanies.stream().limit(limit).collect(Collectors.toList());
    }


    /**
     * 인기순 공고 조회
     * 인기순 기준은 이력서 신청 이력이 많은 공고 순임
     */
    private List<PopularApplicationDto> getPopularApplications() {
        return applyStatusRepository.findPopularApplications()
                .stream()
                .limit(2)
                .map(application -> mapToDto(application))
                .collect(Collectors.toList());
    }

    private PopularApplicationDto mapToDto(Application application) {
        PopularApplicationDto dto = modelMapper.map(application, PopularApplicationDto.class);
        try {
            if (application.getCompany() != null) {
                Hibernate.initialize(application.getCompany());
                dto.setName(application.getCompany().getName());
            }
            List<File> files = fileRepository.findFilesByApplicationNo(application.getApplicationNo());
            dto.setFiles(files);
        } catch (Exception e) {
            log.error("@@@@@@아 뭔가 테스트 데이터가 잘못 들어가있다@@@@@@ {}: {}", application.getApplicationNo(), e.getMessage());
        }

        return dto;
    }


}
