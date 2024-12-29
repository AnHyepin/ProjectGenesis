package org.green.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고 Entity입니다.
 */
@Entity
@Table(name = "tbl_applications")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_no")
    private int applicationNo;            // 채용공고 번호

    @Column(name="username",length = 15, nullable = false)
    private String username;               // 사용자 고유 ID

    @Column(name="application_title", length = 225, nullable = false)
    private String applicationTitle;       // 채용공고 제목

    @Column(name="start_date", nullable = false)
    private String startDate;               // 공고 시작

    @Column(name="deadline_date")
    private String deadlineDate;            // 공고 마감일

    @Column(name="application_code",length = 10, nullable = false, columnDefinition = "CHAR(1) DEFAULT 'O'")
    private String applicationCode = "O";        // 채용구분 (C: 마감, O: 모집중, S: 모집 일시중지)

    @Column(name="salary",nullable = false)
    private int salary = 0;                    // 연봉

    @Column(name="careerCode",nullable = false)
    private String career_code;             // 경력 (S:신입, G:경력, SG:신입/경력)

    @Column(name="position_code", length = 20)
    private String positionCode;           // 직책/직급코드

    @Column(name="education_gbn_code", length = 20, nullable = false)
    private String educationGbnCode;       // 학력 구분 코드

    @Column(name="employment_code", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'A'")
    private String employmentCode = "A";  // 근무형태 (C: 계약직, F: 정규직, A: 계약/정규직)

    @Column(name="working_area", length=255, nullable = false)
    private String workingArea;            // 근무지역

    @Column(name="role_code", length=20, nullable = false)
    private String roleCode;               // 개발직무

    @Column(name="content", columnDefinition="TEXT")
    private String content;                // 모집부문 및 상세내용

    @Column(name = "procedure_code")
    private Integer procedureCode;             // 1차(1), 2차(2), 3차(3)

    @Column(name="delete_yn", nullable = false, columnDefinition="CHAR(1) DEFAULT 'N'")
    private String deleteYn;               // 삭제여부 (N: 미삭제, Y: 삭제)

    @Column(name="regist_dt", nullable = false)
    private String registDt;                // 생성일

    @Column(name="modi_dt")
    private String modiDt;                  // 수정일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;

}
