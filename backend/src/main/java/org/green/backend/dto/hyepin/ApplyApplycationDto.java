package org.green.backend.dto.hyepin;

import lombok.Data;

@Data
public class ApplyApplycationDto {

    private int resumeNo; //이력서 번호
    private String applicationNo; // 공고 번호
    private String applyStatusGbnCode; // 심사 현황 코드
    private String applicationTitle; // 공고 제목
    private String companyName; // 회사명
    private String username; //회사ID
}
