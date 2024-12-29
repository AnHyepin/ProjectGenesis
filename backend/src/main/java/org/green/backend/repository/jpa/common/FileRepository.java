package org.green.backend.repository.jpa.common;

import org.green.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    @Query("SELECT f FROM File f WHERE f.fileRefNo = :applicationNo AND f.fileGubnCode = 'application_no'")
    List<File> findFilesByApplicationNo(int applicationNo);
}