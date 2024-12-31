package org.green.backend.dto.hws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.green.backend.dto.common.FileDto;
import org.green.backend.entity.Application;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkApplicationDto {
    private String name;
    private Application application;
    private List<FileDto> files;
}