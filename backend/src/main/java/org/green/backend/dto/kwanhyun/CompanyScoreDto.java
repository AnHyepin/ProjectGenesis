package org.green.backend.dto.kwanhyun;

import lombok.Data;

@Data
public class CompanyScoreDto {

    private String username;
    private String name;
    private float jrStar;
    private String address;
    private int employees;
    private int sale;
    private char likeCode;
    private int count;

}