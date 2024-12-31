package org.green.backend.dto.kwanhyun;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDto {

    private int boardNo;
    private String title;
    private String content;
    private String boardGbnCode;
    private char boardAnswerYn;
    private char deleteYn;
    private String registId;
    private Date registDt;
    private String modiDt;

}
