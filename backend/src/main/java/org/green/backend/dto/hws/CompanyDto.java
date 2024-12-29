package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.entity.common.Address;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String content;
    private LocalDate birth;
    private Address address;
    private Integer zipcode;
    private String roadAddress;
    private String detailAddress;
    private String ceoName;
    private Integer employees;
    private Integer sale;
    private String homepage;
    private Character deleteYn;
    public Address toAddress() {
        return new Address(roadAddress, detailAddress, zipcode);
    }

}