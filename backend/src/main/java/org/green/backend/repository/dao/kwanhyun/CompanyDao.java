package org.green.backend.repository.dao.kwanhyun;

import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.dto.kwanhyun.BookmarkCompanyDto;
import org.green.backend.dto.kwanhyun.CompanyScoreDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface CompanyDao {
    public CompanyDto findCompanyByUsername(String username);
    public void updateCompany(@Param("company") CompanyDto company);
    public List<CompanyScoreDto> myScoreList(String username);
    public List<BookmarkCompanyDto> bookmarkList(String username);
}
