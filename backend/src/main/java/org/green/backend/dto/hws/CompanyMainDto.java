package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMainDto {
    private List<Applicant> applicants;
    private List<CApplicationDto> applicationList;
}
