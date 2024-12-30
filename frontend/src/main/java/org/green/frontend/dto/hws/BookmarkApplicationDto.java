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
public class BookmarkApplicationDto {
    private ApplicationDto applicationData;
    private List<FileDto> files;
}