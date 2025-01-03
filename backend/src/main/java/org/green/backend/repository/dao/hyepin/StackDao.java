package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.common.GubnDto;
import org.green.backend.dto.hyepin.StackDto;

import java.util.List;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서의 기술스택 테이블 dao입니다.
 */
@Mapper
public interface StackDao {
    public int save(@Param("resumeNo") int resumeNo, @Param("stackCode") String stackCode);
    public List<String> getByResumeNo(@Param("resumeNo") int resumeNo);
    public void delete(@Param("resumeNo") int resumeNo);
    public List<GubnDto> getStackListByResumeNo(@Param("resumeNo") int resumeNo);
}