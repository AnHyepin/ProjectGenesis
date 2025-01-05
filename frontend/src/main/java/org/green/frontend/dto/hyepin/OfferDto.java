package org.green.frontend.dto.hyepin;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
public class OfferDto {

    private List<Integer> checkList; //이력서 번호 리스트
    private List<Integer> applicationNo; //공고 번호
    private String uesrname; //회사ID
}
