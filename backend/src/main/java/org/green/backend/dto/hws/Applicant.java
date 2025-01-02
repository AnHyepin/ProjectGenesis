package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    private int applyStatusNo;
    private int resumeNo;
    private int applicationNo;
    private String applyStatusGbnCode;
    private String username;
    private String name;
    private String gender;
    private int age;
    private String resumeTitle;
    private String resumeMyTitle;
    private LocalDate registDt;
    private String totalCareerDescription;
    private List<String> topSkills;

}