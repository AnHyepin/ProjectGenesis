package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 구분 Entity입니다.
 */
@Entity
@Table(name = "tbl_gubn")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gubn {
    
    @EmbeddedId
    private GubnCompositeKey id;    //복합키 객체

    @Column(name="gubn_name", length = 50, nullable = false)
    private String gubnName;
}
