package org.green.backend.dto.hyepin;

import lombok.Data;

import java.util.List;

@Data
public class StackDto {

    private List<String> stackCode;
    private int resumeNo;
    private String username;
}
