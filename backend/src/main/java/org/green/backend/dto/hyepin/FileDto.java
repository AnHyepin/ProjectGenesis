package org.green.backend.dto.hyepin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

}