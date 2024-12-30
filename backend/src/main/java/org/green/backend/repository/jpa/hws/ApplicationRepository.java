package org.green.backend.repository.jpa.hws;

import org.apache.ibatis.annotations.Param;
import org.green.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = """
            SELECT * 
            FROM tbl_applications 
            WHERE username = :username AND delete_yn = 'N' 
            ORDER BY regist_dt DESC 
            LIMIT 1
            """, nativeQuery = true)
    Application findLatestApplicationByCompany(@Param("username") String username);

    @Query("""
                SELECT a
                FROM Application a
                WHERE a.username IN :companyUsernames
                ORDER BY a.registDt DESC
            """)
    List<Application> findBookmarkedApplications(@Param("companyUsernames") List<String> companyUsernames) ;
}
