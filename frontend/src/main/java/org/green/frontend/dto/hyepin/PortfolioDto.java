package org.green.frontend.dto.hyepin;

import lombok.Data;

import java.util.Date;

@Data
public class PortfolioDto {

    private int resumePortfolioNo;
    private int resumeNo;   //이력서 번호
    private Date resumePortfolioStartDate;  //시작일
    private Date resumePortfolioEndDate;    //종료일
    private String resumePortfolioUrl;  //url
    private int resumePortfolioCnt; //작업인원
    private String resumePortfolioContent;  //작업내용

}
