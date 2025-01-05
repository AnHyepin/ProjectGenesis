package org.green.backend.dto.hyepin;

import lombok.Data;

import java.util.List;

@Data
public class OfferDto {

    private List<Integer> checkList;
    private int applicationNo;
    private String uesrname;
}
