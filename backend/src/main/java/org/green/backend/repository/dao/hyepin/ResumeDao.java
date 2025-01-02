package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hyepin.ApplyApplycationDto;
import org.green.backend.dto.hyepin.EducationDto;
import org.green.backend.dto.hyepin.ResumeDto;

import java.util.List;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서테이블 dao입니다.
 */
@Mapper
public interface ResumeDao {
    public int getMaxNum(@Param("username") String username);
    public List<ResumeDto> getSavedraft(@Param("username") String username);
    public int savedraftDelete(@Param("username") String username);
    public int create(@Param("username") String username);
    public int save(ResumeDto resume);
    public List<ResumeDto> getResumeListByUsername(@Param("username") String username);
    public int getResumeCount(@Param("username") String username);
    public int updatePosition(@Param("resumeNo") int resumeNo);
    public List<ApplyApplycationDto> getApplyList(@Param("resumeNo") int resumeNo);

}
