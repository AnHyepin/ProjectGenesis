package org.green.frontend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeApplicationDto {
    private Long likeId;
    private String username;
    private String likeCode;
    private ApplicationDto applicationData;
    private List<FileDto> files;
}