package org.green.frontend.dto.hyepin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDtoHyepin {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String content;
    private LocalDate birth;
    private Integer zipcode;
    private String roadAddress;
    private String detailAddress;
    private String ceoName;
    private Integer employees;
    private Integer sale;
    private String homepage;
    private Character deleteYn;

}