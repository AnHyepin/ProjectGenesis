package org.green.backend.dto.hyepin;

import lombok.Data;

@Data
public class PortfolioDto {

    private int resumePortfolioNo;
    private int resumeNo;   //이력서 번호
    private String username;
    private String resumePortfolioStartDate;  //시작일
    private String resumePortfolioEndDate;    //종료일
    private String resumePortfolioUrl;  //url
    private int resumePortfolioCnt; //작업인원
    private String resumePortfolioContent;  //작업내용
}
