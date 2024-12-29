package org.green.backend.repository.jpa.hws;

import org.green.backend.entity.Application;
import org.green.backend.entity.ApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyStatusRepository extends JpaRepository<ApplyStatus, Long> {
    @Query("""
            SELECT ap
            FROM ApplyStatus a
            JOIN a.application ap
            WHERE ap.deleteYn = 'N'
            AND ap.applicationCode != 'C'
            GROUP BY ap
            ORDER BY COUNT(a.id) DESC
            """)
    List<Application> findPopularApplications();


}
