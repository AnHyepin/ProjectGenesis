package org.green.backend.repository.dao.jeyeon;

import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.jeyeon.GubnDto;

import java.util.List;

@Mapper
public interface GubnDao {
    public List<GubnDto> getCareerList();

    public List<GubnDto> getPostionList();

    public List<GubnDto> getEducationList();

    public List<GubnDto> getEmploymentList();

    public List<GubnDto> getStackList();

    public List<GubnDto> getStack1thList();

    public List<GubnDto> getApplicationList();

    public List<GubnDto> getProcedureList();
}
