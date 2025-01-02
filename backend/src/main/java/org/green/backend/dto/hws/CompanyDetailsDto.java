package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDetailsDto {

    private InnerCompany company;
    private List<InnerApplication> applications;
    private Double avgRating;
    private Integer totalBookMark;
    private Integer isBookMark;
    private String profileUrl;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InnerCompany {
        private String username;
        private String password;
        private String name;
        private String email;
        private String phone;
        private String content;
        private LocalDate birth;
        private String address;
        private String addressDetail;
        private Integer zipCode;
        private String ceoName;
        private String homepage;
        private Integer employees;
        private Integer sale;
        private String role;
        private String deleteYn;
        private LocalDate registDt;
        private LocalDate modiDt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InnerApplication {
        private Long applicationNo;
        private String username;
        private String applicationTitle;
        private String startDate;
        private String deadlineDate;
        private String applicationCode;
        private Long  salary;
        private String careerCode;
        private String positionCode;
        private String educationGbnCode;
        private String employmentCode;
        private String workingArea;
        private String roleCode;
        private String content;
        private Integer procedureCode;
        private String deleteYn;
        private String registDt;
        private String modiDt;
        private String daysLeft;
        private Integer isScrap;
        private List<InnerFile> files;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InnerFile {
        private Integer fileNo;
        private String fileGubnCode;
        private String fileRefNo;
        private String fileOldName;
        private String fileNewName;
        private String fileExt;
        private Long fileSize;
        private String fileUrl;
    }
}
