package org.green.backend.repository.jpa.jeyeon;

import org.green.backend.entity.ApplicationStack;
import org.green.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 파일 Repository입니다.
 */
public interface FileRepository extends JpaRepository<File, Integer> {

}
