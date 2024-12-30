package org.green.backend.dto.hyepin;

import lombok.Data;

@Data
public class EducationDto {

    private int resumeEducationNo;
    private int resumeNo;
    private String resumeEducationGbnCode;
    private String resumeEducationName;
    private String resumeEducationMajor;
    private String resumeEducationScore;
    private String resumeEducationIndt;
    private String resumeEducationOutdt;
    private char resumeEducationTransferYn;

}
