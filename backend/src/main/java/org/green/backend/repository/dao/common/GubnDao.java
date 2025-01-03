package org.green.backend.repository.dao.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.common.GubnDto;
import org.green.backend.entity.Gubn;

import java.util.List;

@Mapper
public interface GubnDao {
    public List<GubnDto> getGubnList(@Param("gubnCode") String gubnCode);
    public List<GubnDto> getSkillList();
    public List<GubnDto> getSkillName(@Param("stackCode") String stackCode);
}
