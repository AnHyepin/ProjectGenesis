package org.green.frontend.dto.hws;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NonLoginMainDto {
    private List<TopRatedCompanyDto> topRatedCompanies;
    private List<PopularApplicationDto> popularApplications;
    private List<LikeApplicationDto> likeApplications;
    private List<BookmarkApplicationDto> bookmarkApplications;
}