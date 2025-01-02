package org.green.backend.repository.dao.kwanhyun;

import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.hws.CompanyDto;
import org.springframework.data.repository.query.Param;

@Mapper
public interface CompanyDao {
    public CompanyDto findCompanyByUsername(String username);
    public void updateCompany(@Param("company") CompanyDto company);
}
