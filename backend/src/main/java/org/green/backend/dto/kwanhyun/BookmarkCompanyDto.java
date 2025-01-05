package org.green.backend.dto.kwanhyun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkCompanyDto {

    private String likeCode;
    private String likeId;
    private String name;
    private String address;
    private int count;

}
