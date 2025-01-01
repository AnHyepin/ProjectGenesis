package org.green.backend.dto.hyepin;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ResumeDto {

    private int resumeNo;   //이력서 번호
    private String username; //구직자 이름
    private String gender; // 성별
    private Date birth; //생일
    private String email; //이메일
    private String phone; //전화번호
    private String address; //주소
    private String resumeTitle; //이력서 제목
    private String resumeMyTitle;   //자소서제목
    private String resumeMyContent; //자소서 내용
    private char resumePubilceYn; //공개여부
    private char deleteYn; //삭제여부
    private LocalDateTime registDt;    //생성일
    private LocalDateTime modiDt;
    private String salary;  //요구연봉
    private String career;  //지원할 때 경력(신입/경력)
    private boolean savedraft; //임시저장 여부
    private List<String> gubnCode; //기술 스택 이름 리스트


}
