package org.green.backend.repository.jpa.hws;

import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hws.LikeApplicationDto;
import org.green.backend.entity.Company;
import org.green.backend.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("""
                SELECT new org.green.backend.dto.hws.LikeApplicationDto(
                    l.id, l.username, l.likeCode, a
                )
                FROM Like l
                JOIN Application a ON CAST(l.likeId AS int) = a.applicationNo
                WHERE l.username = :username
                AND l.likeCode = 'S'
            """)
    List<LikeApplicationDto> findLikeApplications(@Param("username") String username);


    @Query("""
                SELECT c
                FROM Company c
                WHERE c.username IN (
                    SELECT l.likeId
                    FROM Like l
                    WHERE l.username = :currentUsername
                    AND l.likeCode = 'G'
                )
            """)
    List<Company> findSubscribedCompanies(@Param("currentUsername") String currentUsername);


}
