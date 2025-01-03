package org.green.backend.repository.jpa.common;

import org.green.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    @Query("SELECT f FROM File f WHERE f.fileRefNo = :applicationNo AND f.fileGubnCode = :applicationGubnCode ")
    List<File> findFilesByApplicationNo(int applicationNo,String applicationGubnCode);

    File findFileByFileRefNoAndFileGubnCode(String fileRefNo, String fileGubnCode);


}