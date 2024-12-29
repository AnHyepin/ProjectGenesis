package org.green.backend.repository.jpa.jeyeon;

import org.green.backend.entity.ApplicationStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 공고별 기술 스택 Repository입니다.
 */
public interface ApplicationStackRepository extends JpaRepository<ApplicationStack, Integer> {
}
