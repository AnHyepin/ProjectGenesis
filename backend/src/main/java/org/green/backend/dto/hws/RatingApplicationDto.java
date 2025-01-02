package org.green.backend.dto.hws;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.entity.Application;
import org.green.backend.entity.File;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingApplicationDto {
    private String username;
    private String name;
    private Application application;
    private Double averageStar;
    private List<File> files;

    public RatingApplicationDto(String username, String companyName, Double averageStar) {
        this.username = username;
        this.name = companyName;
        this.averageStar = averageStar;
        this.application = null;
    }
}