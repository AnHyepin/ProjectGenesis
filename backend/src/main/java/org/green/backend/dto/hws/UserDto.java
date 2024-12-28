package org.green.backend.dto.hws;

import lombok.*;
import org.green.backend.entity.common.Address;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private Character gender;
    private LocalDate birth;
    private String phone;
    private Address address;
}