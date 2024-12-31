package org.green.backend.dto.hws;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainPageDataDto {
    private List<RatingApplicationDTO> topRatedCompanies;
    private List<PopularApplicationDto> popularApplications;
    private List<LikeApplicationDto> likeApplications;
    private List<BookmarkApplicationDto> bookmarkApplications;
    private List<Integer> scrappedApplicationIds;

    public MainPageDataDto(List<RatingApplicationDTO> topRatedCompanies, List<PopularApplicationDto> popularApplications) {
        this.topRatedCompanies = topRatedCompanies;
        this.popularApplications = popularApplications;
    }
}
