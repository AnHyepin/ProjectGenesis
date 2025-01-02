package org.green.backend.repository.dao.hws;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hws.Applicant;
import org.green.backend.dto.hws.CApplicationDto;

import java.util.List;

@Mapper
public interface MainDao {
    Integer getTotalCareerByResumeNo(@Param("resumeNo") int resumeNo);
    List<String> getTopSkillsByResumeNo(@Param("resumeNo") int resumeNo);
    List<Applicant> getApplicantsForCompany(@Param("companyUsername") String companyUsername);

    List<CApplicationDto> getApplications(@Param("companyUsername") String companyUsername);
}
