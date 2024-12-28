package org.green.backend.repository.dao.jeyeon;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.jeyeon.ApplicationRequestDto;


/**
 * 12-27 (작성자: 안제연)
 * 이 클래스는 채용공고에서 사용되는 구분입니다.
 */
@Mapper
public interface ApplicationDao {
    public void insertApplication(@Param("applicationRequestDto") ApplicationRequestDto applicationRequestDto);
    public int selectLastApplicationNo();
}
