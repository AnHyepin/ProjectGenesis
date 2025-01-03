package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hyepin.EducationDto;
import org.green.backend.dto.hyepin.PortfolioDto;

import java.util.List;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서의 포트폴리오 테이블 dao입니다.
 */
@Mapper
public interface PortfolioDao {
    public int save(PortfolioDto portfolio);
    public int maxNumByResumeNo(@Param("resumeNo") int resumeNo);
    public List<PortfolioDto> getPortfolioListByResumeNo(@Param("resumeNo") int resumeNo);
}