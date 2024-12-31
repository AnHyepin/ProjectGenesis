package org.green.frontend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.frontend.dto.hws.*;
import org.green.frontend.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 메인 서비스
 * <p>
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
    public NonLoginMainDto nonLoginMain(String token) {
        Map<String, Object> mainData = (Map<String, Object>) apiRequestService.fetchDataToken("/api/main", token).getBody();

        List<Integer> scrappedApplicationIds = (List<Integer>) mainData.get("scrappedApplicationIds");

        return NonLoginMainDto.builder()
                .topRatedCompanies(mapList(mainData.get("topRatedCompanies"), company -> mapToTopRatedCompanyDTO(company, scrappedApplicationIds)))
                .popularApplications(mapList(mainData.get("popularApplications"), app -> mapToPopularApplicationDTO(app, scrappedApplicationIds)))
                .likeApplications(mapList(mainData.get("likeApplications"), app -> mapToLikeApplicationDTO(app, scrappedApplicationIds)))
                .bookmarkApplications(mapList(mainData.get("bookmarkApplications"), app -> mapToBookmarkApplicationDTO(app, scrappedApplicationIds)))
                .build();
    }


    /**
     * 북마크 데이터를 BookmarkApplicationDTO로 매핑
     */
    private BookmarkApplicationDto mapToBookmarkApplicationDTO(Map<String, Object> bookmarkApplication, List<Integer> scrappedApplicationIds) {
        List<FileDto> fileDtos = mapFiles(bookmarkApplication.get("files"));
        return BookmarkApplicationDto.builder()
                .applicationData(mapToApplicationDTO((Map<String, Object>) bookmarkApplication.get("application"), scrappedApplicationIds))
                .files(fileDtos)
                .companyName((String) bookmarkApplication.get("name"))
                .build();
    }

    /**
     * 좋아요 데이터를 LikeApplicationDTO로 매핑
     */
    private LikeApplicationDto mapToLikeApplicationDTO(Map<String, Object> likeData, List<Integer> scrappedApplicationIds) {
        List<FileDto> fileDtos = mapFiles(likeData.get("files"));
        return LikeApplicationDto.builder()
                .applicationData(mapToApplicationDTO((Map<String, Object>) likeData.get("application"), scrappedApplicationIds))
                .files(fileDtos)
                .likeId(((Number) likeData.get("likeId")).longValue())
                .likeCode((String) likeData.get("likeCode"))
                .companyName((String) likeData.get("name"))
                .build();
    }

    /**
     * 회사 데이터를 TopRatedCompanyDTO로 매핑
     */
    private TopRatedCompanyDto mapToTopRatedCompanyDTO(Map<String, Object> companyData, List<Integer> scrappedApplicationIds) {
        List<FileDto> fileDtos = mapFiles(companyData.get("files"));
        return TopRatedCompanyDto.builder()
                .username((String) companyData.get("username"))
                .name((String) companyData.get("name"))
                .applicationData(mapToApplicationDTO((Map<String, Object>) companyData.get("application"), scrappedApplicationIds))
                .averageStar((Double) companyData.get("averageStar"))
                .files(fileDtos)
                .build();
    }

    /**
     * 공고 데이터를 PopularApplicationDTO로 매핑
     */
    private PopularApplicationDto mapToPopularApplicationDTO(Map<String, Object> applicationData, List<Integer> scrappedApplicationIds) {
        List<FileDto> fileDtos = mapFiles(applicationData.get("files"));
        return PopularApplicationDto.builder()
                .applicationData(mapToApplicationDTO(applicationData, scrappedApplicationIds))
                .companyName((String) applicationData.get("name"))
                .files(fileDtos)
                .build();
    }


    /**
     * 공고 데이터를 ApplicationDTO로 매핑
     */
    private ApplicationDto mapToApplicationDTO(Map<String, Object> applicationData, List<Integer> scrappedApplicationIds) {
        if (applicationData == null) return null;

        Integer applicationNo = (Integer) applicationData.get("applicationNo");

        return ApplicationDto.builder()
                .applicationNo((Integer) applicationData.get("applicationNo"))
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
                .isScrap(scrappedApplicationIds != null && scrappedApplicationIds.contains(applicationNo))
                .build();
    }

    /**
     * 데이터를 리스트 형태로 매핑
     *
     * @param data 매핑할 데이터 (List<Map<String, Object>> 형태)
     */
    private <T, R> List<R> mapList(Object data, Function<Map<String, Object>, R> mapper) {
        if (data == null) {
            return List.of();
        }
        return ((List<Map<String, Object>>) data).stream().map(mapper).toList();
    }


    /**
     * 파일 데이터를 FileDto 리스트로 매핑
     */
    private List<FileDto> mapFiles(Object filesData) {
        if (filesData == null) return List.of();

        return ((List<Map<String, Object>>) filesData).stream()
                .map(fileData -> FileDto.builder()
                        .fileUrl((String) fileData.get("fileUrl"))
                        .build())
                .toList();
    }
}
