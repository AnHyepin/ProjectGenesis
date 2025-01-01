package org.green.backend.repository.jpa.hws;


import org.green.backend.dto.hws.RatingApplicationDto;
import org.green.backend.entity.Rating;
import org.green.backend.entity.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {

    @Query("""
    SELECT new org.green.backend.dto.hws.RatingApplicationDto(
        c.username,
        c.name,       
        AVG(r.jrStar) 
    )
    FROM Rating r
    JOIN Company c ON r.id.companyName = c.username 
    WHERE r.jrStar IS NOT NULL
    GROUP BY c.username
    ORDER BY AVG(r.jrStar) DESC
    """)
    List<RatingApplicationDto> findTopRatedCompanies();
}
