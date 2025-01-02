package org.green.backend.repository.dao.hyepin;

import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.hyepin.CareerDto;

/**
 * 12-31 (작성자: 안혜빈)
 * 이 클래스는 이력서의 경력을 관리하는 dao입니다.
 */
@Mapper
public interface CareerDao {
    public int save(CareerDto career);
}
