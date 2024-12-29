package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NonLoginMainDTO {
    private List<TopRatedCompanyDTO> topRatedCompanies;
    private List<PopularApplicationDTO> popularApplications;
}