package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.dto.common.FileDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CApplicationDto {
    private int applicationNo;
    private String username;
    private String applicationTitle;
    private String workingArea;
    private String careerCode;
    private LocalDate startDate;
    private String deadlineDate;
    private String daysLeft;
    private String fileUrl;
}
