package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hyepin.EducationDto;
import org.green.backend.dto.hyepin.ResumeDto;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서테이블 dao입니다.
 */
@Mapper
public interface ResumeDao {
    public int getMaxNum(@Param("username") String username);
    public ResumeDto getSavedraft(@Param("username") String username);
    public int savedraftDelete(@Param("username") String username);
    public int create(@Param("username") String username);
    public int save(ResumeDto resume);
}
