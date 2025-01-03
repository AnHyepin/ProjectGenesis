package org.green.frontend.dto.hyepin;

import lombok.Data;

@Data
public class ApplyStatusDto {

    private Long resumeNo;            // 이력서 번호
    private Long applicationNo;       // 공고 번호
    private String applyStatusGbnCode; // 지원 상태 코드
    private String applicationTitle;  // 공고 제목
    private String companyName;       // 회사명
    private String resumeTitle;       // 이력서 제목

}
