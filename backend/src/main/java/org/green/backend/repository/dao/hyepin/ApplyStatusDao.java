package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hyepin.ApplyApplycationDto;
import org.green.backend.dto.hyepin.ApplyStatusDto;

import java.util.List;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 지원현황을 관리하는 dao입니다.
 */
@Mapper
public interface ApplyStatusDao {

    public int insertApply(ApplyStatusDto applyStatusDto);
    public int updatePassCode(@Param("applicationNo") int applicationNo,
                              @Param("resumeNo") int resumeNo,
                              @Param("passCode") String passCode);

}
