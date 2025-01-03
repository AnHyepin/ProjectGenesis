package org.green.frontend.dto.jeyeon;


import lombok.Data;

import java.time.LocalDate;

/**
 * 12-31 (작성자: 안제연)
 * 이 클래스는 ApplicationResponseDto를 위해 만들어진 클래스입니다.
 */
@Data
public class FileDto {

    // 파일번호
    private Integer fileNo;
    // 파일구분(EX) question_no)
    private String fileGubnCode;
    // 파일 영향받는 아이디(EX) 1)
    private String fileRefNo;
    // 파일 관리명(저장하는 파일명 시간으로 들어감 밀리세컨드까지)
    private String fileNewName;
    // 파일명(불러올 파일명)
    private String fileOldName;
    // 파일 확장자
    private String fileExt;
    // 크기 MB
    private Long fileSize;
    // 파일 위치
    private String fileUrl;
    // 작성자 ID
    private String instId;
    // 작성일시
    private LocalDate instDt;

}