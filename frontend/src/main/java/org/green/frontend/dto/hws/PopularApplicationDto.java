package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PopularApplicationDto {
    private ApplicationDto applicationData;
    private String companyName;
    private List<FileDto> files;
}