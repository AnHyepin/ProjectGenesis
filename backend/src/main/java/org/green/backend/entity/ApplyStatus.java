package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_apply_status")
public class ApplyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_status_no", nullable = false)
    private Long id;

    @Column(name = "resume_no", nullable = false)
    private Long resumeNo;

    @Column(name = "application_no", insertable = false, updatable = false)
    private Long applicationNo;

    @Column(name = "apply_status_gbn_code", nullable = false, length = 20)
    private String applyStatusGbnCode;

    @Column(name = "regist_id", length = 20)
    private String registId;

    @Column(name = "regist_dt")
    private Instant registDt;

    @Column(name = "modi_id", length = 20)
    private String modiId;

    @Column(name = "modi_dt")
    private Instant modiDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_no")
    private Application application;

}