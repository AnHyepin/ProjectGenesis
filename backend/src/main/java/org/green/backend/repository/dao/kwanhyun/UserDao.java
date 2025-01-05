package org.green.backend.repository.dao.kwanhyun;

import org.apache.ibatis.annotations.Mapper;
import org.green.backend.dto.kwanhyun.BookmarkCompanyDto;
import org.green.backend.dto.kwanhyun.CompanyScoreDto;
import org.green.backend.dto.kwanhyun.ScrapApplicationDto;

import java.util.List;

@Mapper
public interface UserDao {

    public List<CompanyScoreDto> myScoreList(String username);
    public List<BookmarkCompanyDto> bookmarkList(String username);
    public List<ScrapApplicationDto> scrapList(String username);

}
