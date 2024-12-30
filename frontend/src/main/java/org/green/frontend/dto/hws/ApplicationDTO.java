package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationDTO {
    private int applicationNo;
    private String username;
    private String applicationTitle;
    private String startDate;
    private String deadlineDate;
    private String applicationCode;
    private int salary;
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
    private String companyName;
    private String daysLeft;
}
