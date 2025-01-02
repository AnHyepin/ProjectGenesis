package org.green.backend.dto.kwanhyun;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RatingDto {

    private String name;
    private String username;
    private float jrStar;
    private LocalDate registDate;

}