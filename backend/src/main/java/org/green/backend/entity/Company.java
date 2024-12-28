package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.green.backend.entity.common.Address;
import org.green.backend.entity.common.Auditable;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_companys")
public class Company extends Auditable {
    @Id
    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Embedded
    private Address address;

    @Column(name = "ceo_name", length = 50)
    private String ceoName;

    @ColumnDefault("0")
    @Column(name = "employees", nullable = false)
    private Integer employees = 0;

    @ColumnDefault("0")
    @Column(name = "sale", nullable = false)
    private Integer sale = 0;

    @ColumnDefault("''ROLE_COMPANY''")
    @Column(name = "role", nullable = false, length = 100)
    private String role = "ROLE_COMPANY";

    @ColumnDefault("'N'")
    @Column(name = "delete_yn", nullable = false)
    private Character deleteYn = 'N';

}