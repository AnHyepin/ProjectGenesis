package org.green.backend.dto.kwanhyun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

    private String name;
    private String username;
    private float jrStar;
    private LocalDate registDate;

}
