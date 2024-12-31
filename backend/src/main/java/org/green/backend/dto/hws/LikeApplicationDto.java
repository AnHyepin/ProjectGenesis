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
public class LikeApplicationDto {
    private Long likeId;
    private String name;
    private String username;
    private Character likeCode;
    private Application application;
    private List<FileDto> file;

    public LikeApplicationDto(Long likeId, String username, Character likeCode, Application application,String name) {
        this.likeId = likeId;
        this.name = name;
        this.username = username;
        this.likeCode = likeCode;
        this.application = application;
    }
}