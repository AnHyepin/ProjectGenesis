package org.green.backend.dto.jeyeon;

import lombok.Data;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 파일 Dto입니다.
 */
@Data
public class FileDto {
    private int fileNo;            // 파일번호
    private String fileGubnCode;   // 파일구분
    private Integer fileRefNo;     // 파일 영향받는 아이디
    private String fileOldName;    // 파일 관리명
    private String fileNewName;    // 파일명
    private String fileExt;        // 파일 확장자
    private Integer fileSize;      // 파일 크기 (단위: MB)
    private String fileUrl;
}
