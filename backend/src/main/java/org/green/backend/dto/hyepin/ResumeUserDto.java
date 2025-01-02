package org.green.backend.dto.hyepin;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.entity.common.Address;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeUserDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private Character gender;
    private LocalDate birth;
    private String phone;
    private Address address;
    private Integer zipcode;
    private String roadAddress;
    private String detailAddress;
    private LocalDate registDt;
    private Character deleteYn;

    private String fileUrl;

    public Address toAddress() {
        return new Address(roadAddress, detailAddress, zipcode);
    }

}
