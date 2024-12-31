package org.green.backend.dto.kwanhyun;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private int commentNo;
    private int boardNo;
    private String commentContent;
    private char delYn;
    private String registId;
    private Date registDt;
    private Date modiDt;

}
