package org.green.backend.dto.kwanhyun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScrapApplicationDto {

    private String name;
    private String title;
    private String workingArea;
    private String careerCode;
    private String likeCode;

}
