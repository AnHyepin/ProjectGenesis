package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.green.backend.entity.common.Address;
import org.green.backend.entity.common.Auditable;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends Auditable {

    @Id
    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private Character gender;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Embedded
    private Address address;

    @ColumnDefault("'ROLE_USER'")
    @Column(name = "role", nullable = false, length = 100)
    private String role = "ROLE_USER";

    //TODO: 해당 컬럼이 객체 에서 필요한 지 여부 추후 생각 해보기 일단은 고정 N값 으로 넣어둠. 1111
    @ColumnDefault("'N'")
    @Column(name = "delete_yn", nullable = false)
    private Character deleteYn = 'N';
}