package org.green.backend.dto.jeyeon;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 채용공고 요청 Dto입니다.
 */
@Data
public class ApplicationRequestDto {
    private Long applicationNo;            // 채용공고 번호
    private String username;               // 사용자 고유 ID
    private String applicationTitle;       // 채용공고 제목
    private String startDate;              // 공고 시작
    private String deadlineDate;           // 공고 마감일
    private String applicationCode;        // 채용구분 (C: 마감, O: 모집중, S: 모집 일시중지)
    private int salary;                    // 연봉
    private String careerCode;             // 경력 (S:신입, G:경력, SG:신입/경력)
    private String positionCode;           // 직책/직급코드
    private String educationGbnCode;       // 학력 구분 코드
    private String employmentCode;         // 근무형태 (C: 계약직, F: 정규직, A: 계약/정규직)
    private String workingArea;            // 근무지역
    private String roleCode;               // 개발직무
    private String content;                // 모집부문 및 상세내용
    private Integer procedureCode;         // 1차(1), 2차(2), 3차(3)
    private String deleteYn;               // 삭제여부 (N: 미삭제, Y: 삭제)
    private String registDt;               // 생성일
    private String modiDt;                 // 수정일
    private List<String> skillList;        // 스킬리스트
}
