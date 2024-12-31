package org.green.backend.entity.kwanhyun;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_board")
@Data
public class Board {

    @Id
    private int board_no;

    private String title;
    private String content;
    private String board_gbn_code;
    private char board_answer_yn;
    private char delete_yn;
    private String regist_id;
    private Date regist_dt;
    private Date modi_dt;

}
