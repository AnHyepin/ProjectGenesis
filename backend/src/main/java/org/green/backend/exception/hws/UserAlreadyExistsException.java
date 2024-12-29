package org.green.backend.exception.hws;

/**
 * 12-27 (작성자: 한우성)
 * 이 클래스는 중복 체크 입셉션 입니다.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}