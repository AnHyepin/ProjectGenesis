package org.green.frontend.dto.kwanhyun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.PhantomReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private String username;
    private String name;
    private String role;
}
