package org.green.backend.service.hws;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.common.FileDto;
import org.green.backend.dto.hws.*;
import org.green.backend.entity.Application;
import org.green.backend.entity.Company;
import org.green.backend.entity.File;
import org.green.backend.repository.dao.hws.MainDao;
import org.green.backend.repository.jpa.common.FileRepository;
import org.green.backend.repository.jpa.hws.ApplicationRepository;
import org.green.backend.repository.jpa.hws.ApplyStatusRepository;
import org.green.backend.repository.jpa.hws.LikeRepository;
import org.green.backend.repository.jpa.hws.RatingRepository;
import org.green.backend.utils.DateUtil;
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
    private final LikeRepository likeRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;
    private final MainDao mainDao;


    /**
     * 비회원 메인 화면 데이터
     */
    public MainPageDataDto getNonLoginPageData(String username) {
        List<RatingApplicationDto> topRatedCompanies = getTopRatingApplication(3);
        List<PopularApplicationDto> popularApplications = getPopularApplications();
        if (username != null) {
            log.info("username is " + username);
            List<LikeApplicationDto> likeApplications = getLikedApplications(username);
            List<BookmarkApplicationDto> bookmarkedApplications = getBookmarkedApplications(username);
            List<Integer> scrappedApplicationIds = getScrappedApplicationIds(username);
            return new MainPageDataDto(topRatedCompanies, popularApplications, likeApplications, bookmarkedApplications, scrappedApplicationIds);
        }
        return new MainPageDataDto(topRatedCompanies, popularApplications);
    }

    /**
     * 스크랩한 공고 ID 조회
     */
    private List<Integer> getScrappedApplicationIds(String username) {
        if (username == null) {
            return List.of();
        }
        return likeRepository.findScrappedApplicationIds(username);
    }

    /**
     * 구독한 기업의 최신 공고 3개를 가져오는 메서드
     */
    private List<BookmarkApplicationDto> getBookmarkedApplications(String username) {
        List<Company> subscribedCompanies = likeRepository.findSubscribedCompanies(username);

        List<String> companyUsernames = subscribedCompanies.stream()
                .map(Company::getUsername)
                .collect(Collectors.toList());

        List<Application> applications = applicationRepository.findBookmarkedApplications(companyUsernames)
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        return applications.stream().map(application -> {
            List<File> files = fileRepository.findFilesByApplicationNo(application.getApplicationNo(), "application_no");
            List<FileDto> fileDtos = files.stream()
                    .map(file -> modelMapper.map(file, FileDto.class))
                    .collect(Collectors.toList());

            return new BookmarkApplicationDto(application.getCompany().getName(), application, fileDtos);
        }).collect(Collectors.toList());
    }


    /**
     * 별점 높은 기업 의 공고 한개씩 들고오는거
     */
    public List<RatingApplicationDto> getTopRatingApplication(int limit) {
        List<RatingApplicationDto> topCompanies = ratingRepository.findTopRatedCompanies();

        topCompanies.forEach(dto -> {
            Application latestApplication = applicationRepository.findLatestApplicationByCompany(dto.getUsername());
            if (latestApplication != null) {
                List<File> files = fileRepository.findFilesByApplicationNo(latestApplication.getApplicationNo(), "application_no");

                dto.setApplication(latestApplication);
                dto.setFiles(files);
            }

            dto.setAverageStar(Math.round(dto.getAverageStar() * 100.0) / 100.0);
        });

        return topCompanies.stream()
                .limit(limit)
                .collect(Collectors.toList());
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

    /**
     * 인기 공고 데이터 처리
     */
    private PopularApplicationDto mapToDto(Application application) {
        PopularApplicationDto dto = modelMapper.map(application, PopularApplicationDto.class);
        try {
            if (application.getCompany() != null) {
                Hibernate.initialize(application.getCompany());
                dto.setName(application.getCompany().getName());
            }
            List<File> files = fileRepository.findFilesByApplicationNo(application.getApplicationNo(), "application_no");
            dto.setFiles(files);
        } catch (Exception e) {
            log.error("@@@@@@아 뭔가 테스트 데이터가 잘못 들어가있다@@@@@@ {}: {}", application.getApplicationNo(), e.getMessage());
        }
        return dto;
    }

    /**
     * 스크랩한 공고 조회
     */
    private List<LikeApplicationDto> getLikedApplications(String username) {
        return likeRepository.findLikeApplications(username).stream().limit(3).map(likeApplicationDto -> {
            List<File> files = fileRepository.findFilesByApplicationNo(likeApplicationDto.getApplication().getApplicationNo(), "application_no");
            likeApplicationDto.setFiles(files.stream()
                    .map(file -> modelMapper.map(file, FileDto.class))
                    .collect(Collectors.toList()));
            return likeApplicationDto;
        }).collect(Collectors.toList());
    }


    /**
     *  기업메인 데이터
     */
    public CompanyMainDto getApplicantsWithDetails(String companyUsername) {

        List<Applicant> applicants = mainDao.getApplicantsForCompany(companyUsername);
        List<CApplicationDto> applications = mainDao.getApplications(companyUsername);

        for (CApplicationDto cApplicationDto : applications) {
            cApplicationDto.setDaysLeft(DateUtil.calculateDaysLeft(cApplicationDto.getDeadlineDate()));
        }
        for (Applicant applicant : applicants) {

            Integer totalCareer = mainDao.getTotalCareerByResumeNo(applicant.getResumeNo());
            totalCareer = totalCareer != null ? totalCareer : 0;
            String formattedCareer = formatCareer(totalCareer);
            applicant.setTotalCareerDescription(formattedCareer);

            List<String> topSkills = mainDao.getTopSkillsByResumeNo(applicant.getResumeNo());
            applicant.setTopSkills(topSkills);
        }

        return new CompanyMainDto(applicants, applications);
    }


    //TODO: 시간관계상 여기서 처리
    private String formatCareer(int totalDays) {
        if (totalDays <= 0) {
            return null;
        }

        int years = totalDays / 365;
        int remainingDays = totalDays % 365;
        int months = remainingDays / 30;

        if (years == 0 && months == 0) {
            return null;
        }

        return String.format("%d년 %d개월", years, months);
    }
}
