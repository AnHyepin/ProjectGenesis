package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
@Builder
public class TopRatedCompanyDTO {
    private String username;
    private String name;
    private ApplicationDTO applicationData;
    private Double averageStar;
    private List<File> files;
}