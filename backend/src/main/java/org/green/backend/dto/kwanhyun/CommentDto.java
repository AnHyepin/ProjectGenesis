package org.green.backend.dto.kwanhyun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private int commentNo;
    private int boardNo;
    private String commentContent;
    private char delYn;
    private String registId;
    private Date registDt;
    private Date modiDt;

}
