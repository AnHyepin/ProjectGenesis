package org.green.backend.dto.hyepin;

import lombok.Data;

import java.util.List;

@Data
public class OfferDto {

    private List<Integer> checkList;
    private List<Integer> applicationNo;
    private String uesrname;
}
