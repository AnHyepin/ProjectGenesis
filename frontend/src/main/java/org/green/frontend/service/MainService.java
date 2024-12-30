package org.green.frontend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.dto.hws.ApplicationDTO;
import org.green.frontend.dto.hws.NonLoginMainDTO;
import org.green.frontend.dto.hws.PopularApplicationDTO;
import org.green.frontend.dto.hws.TopRatedCompanyDTO;
import org.green.frontend.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 메인 서비스
 *
 * 비회원 메인 화면 데이터를 처리,  데이터를 DTO로 매핑하여 반환
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final ApiRequestService apiRequestService;

    /**
     * 비회원 메인 데이터 처리
     */
    public NonLoginMainDTO nonLoginMain() {
        Map<String, Object> mainData = (Map<String, Object>) apiRequestService.fetchData("/api/main").getBody();

        return NonLoginMainDTO.builder()
                .topRatedCompanies(mapList(mainData.get("topRatedCompanies"), this::mapToTopRatedCompanyDTO))
                .popularApplications(mapList(mainData.get("popularApplications"), this::mapToPopularApplicationDTO))
                .build();
    }

    /**
     * 회사 데이터를 TopRatedCompanyDTO로 매핑
     */
    private TopRatedCompanyDTO mapToTopRatedCompanyDTO(Map<String, Object> companyData) {
        return TopRatedCompanyDTO.builder()
                .username((String) companyData.get("username"))
                .name((String) companyData.get("name"))
                .applicationData(mapToApplicationDTO((Map<String, Object>) companyData.get("application")))
                .averageStar((Double) companyData.get("averageStar"))
                .build();
    }

    /**
     * 공고 데이터를 PopularApplicationDTO로 매핑
     */
    private PopularApplicationDTO mapToPopularApplicationDTO(Map<String, Object> applicationData) {
        return PopularApplicationDTO.builder()
                .applicationData(mapToApplicationDTO(applicationData))
                .companyName((String) applicationData.get("name"))
                .build();
    }

    /**
     * 공고 데이터를 ApplicationDTO로 매핑
     */
    private ApplicationDTO mapToApplicationDTO(Map<String, Object> applicationData) {
        if (applicationData == null) return null;

        return ApplicationDTO.builder()
                .applicationNo((int) applicationData.get("applicationNo"))
                .username((String) applicationData.get("username"))
                .applicationTitle((String) applicationData.get("applicationTitle"))
                .startDate((String) applicationData.get("startDate"))
                .deadlineDate((String) applicationData.get("deadlineDate"))
                .applicationCode((String) applicationData.get("applicationCode"))
                .salary((int) applicationData.get("salary"))
                .careerCode((String) applicationData.get("careerCode"))
                .positionCode((String) applicationData.get("positionCode"))
                .educationGbnCode((String) applicationData.get("educationGbnCode"))
                .employmentCode((String) applicationData.get("employmentCode"))
                .workingArea((String) applicationData.get("workingArea"))
                .roleCode((String) applicationData.get("roleCode"))
                .content((String) applicationData.get("content"))
                .procedureCode((Integer) applicationData.get("procedureCode"))
                .deleteYn((String) applicationData.get("deleteYn"))
                .registDt((String) applicationData.get("registDt"))
                .modiDt((String) applicationData.get("modiDt"))
                .companyName((String) applicationData.get("name"))
                .daysLeft(DateUtil.calculateDaysLeft((String) applicationData.get("deadlineDate")))
                .build();
    }

    /**
     * 데이터를 리스트 형태로 매핑
     *
     * @param data   매핑할 데이터 (List<Map<String, Object>> 형태)
     */
    private <T, R> List<R> mapList(Object data, java.util.function.Function<Map<String, Object>, R> mapper) {
        return ((List<Map<String, Object>>) data).stream().map(mapper).toList();
    }
}
