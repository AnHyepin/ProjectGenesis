package org.green.backend.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class Auditable {

    @CreatedDate
    @Column(name = "regist_dt", nullable = false)
    private Instant registDt;

    @LastModifiedDate
    @Column(name = "modi_dt", nullable = false)
    private Instant modiDt;
}
