package org.green.backend.dto.kwanhyun;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ScrapResumeDto {

    private int resumeNo;
    private String username;
    private String gender;
    private Date birth;
    private String email;
    private String phone;
    private String address;
    private String resumeTitle;
    private String resumeMyTitle;
    private String resumeMyContent;
    private char resumePubilceYn;
    private char deleteYn;
    private LocalDateTime registDt;
    private LocalDateTime modiDt;
    private String salary;
    private String career;
    private boolean savedraft;
    private List<String> gubnCode;
    private int applyCount;
    private String likeCode;

    private String stackCodes;
    private List<String> stackList;
    private String educationName;
    private String fileUrl;
}
