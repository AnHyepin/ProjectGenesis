package org.green.backend.repository.dao.hyepin;


import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.hyepin.ResumeDto;

import java.util.List;

/**
 * 01-05 (작성자: 안혜빈)
 * 이 클래스는 포지션 제안 테이블 dao입니다.
 */
@Mapper
public interface OfferDao {
    public int save(int resumeNo, int applicationNo, String username);
    public List<ResumeDto> getResumeMatchingList();
}
