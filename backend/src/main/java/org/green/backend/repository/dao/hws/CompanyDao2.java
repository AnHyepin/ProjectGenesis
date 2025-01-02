package org.green.backend.repository.dao.hws;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hws.CompanyDetailsDto;

import java.util.List;

@Mapper
public interface CompanyDao2 {
    List<CompanyDetailsDto> companyDetails(@Param("companyName") String companyName, @Param("username") String username);
}
