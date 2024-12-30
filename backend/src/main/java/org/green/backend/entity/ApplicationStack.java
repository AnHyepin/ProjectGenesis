package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 공고별 기술 스택 Entity입니다.
 */
@Entity
@Table(name = "tbl_application_stack")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_stack_no")
    private int applicationStackNo;

    @Column(name="application_no",nullable = false)
    private int applicationNo;

    @Column(name="stack_code", length = 20, nullable = false)
    private String stackCode;
}
