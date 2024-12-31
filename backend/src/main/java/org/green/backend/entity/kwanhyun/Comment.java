package org.green.backend.entity.kwanhyun;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_comment")
@Data
public class Comment {

    @Id
    private int comment_no;

    private int board_no;
    private String comment_content;
    private char del_yn;
    private String regist_id;
    private Date regist_dt;
    private Date modi_dt;

}
