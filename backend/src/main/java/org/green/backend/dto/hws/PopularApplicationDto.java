package org.green.backend.dto.hws;


/**
 * 12-28 (작성자: 한우성)
 * 인기 채용공고 DTO
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.entity.File;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopularApplicationDto {
    private Long applicationNo;
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
    private String registDt;
    private String name;
    private List<File> files;
}
