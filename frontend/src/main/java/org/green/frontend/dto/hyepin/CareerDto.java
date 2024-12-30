package org.green.frontend.dto.hyepin;

import lombok.Data;

@Data
public class CareerDto {

    private String resumeCareerNo;
    private String resumeNo;
    private String resumeCareerCompanyName;
    private String resumeCareerJoinDt; //입사일
    private String resumeCareerOutDt; //퇴사일
    private String resumeCareerDepartmentName; //부서명
    private String resumeCareerPosition; //직책
    private String resumeCareerDuties; //담당업무
    private String resumeCareerJob; //직무코드
}
