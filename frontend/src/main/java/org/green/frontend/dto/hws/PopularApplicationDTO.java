package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
@Builder
public class PopularApplicationDTO {
    private ApplicationDTO applicationData;
    private String companyName;
    private List<File> files;
}