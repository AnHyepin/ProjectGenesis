package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TopRatedCompanyDto {
    private String username;
    private String name;
    private ApplicationDto applicationData;
    private Double averageStar;
    private List<FileDto> files;
}