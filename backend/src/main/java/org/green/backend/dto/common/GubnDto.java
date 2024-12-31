package org.green.backend.dto.common;

import lombok.Data;

/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 구분 Dto입니다.
 */
@Data
public class GubnDto {
    private String groupCode;  // GROUP_CODE (예: user_role, question, graduate)
    private String gubnCode;   // 구분 코드
    private String gubnName;   // 구분명
}
