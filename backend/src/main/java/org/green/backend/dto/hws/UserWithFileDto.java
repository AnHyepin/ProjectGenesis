package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.entity.File;
import org.green.backend.entity.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithFileDto {
    private User user;
    private File file;
}