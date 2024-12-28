package org.green.backend.service.jeyeon;

import org.green.backend.dto.jeyeon.GubnDto;
import org.green.backend.repository.dao.jeyeon.GubnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 12-28 (작성자: 안제연)
 * 이 클래스는 채용공고의 셀렉트박스에 값을 넣는데 사용되는 구분 Service입니다.
 */
@Service
public class GubnService {

    @Autowired
    private GubnDao gubnDao;

    public List<GubnDto> getCareerList(){
        return gubnDao.getCareerList();
    };

    public List<GubnDto> getPostionList(){
        return gubnDao.getPostionList();
    };

    public List<GubnDto> getEducationList(){
        return gubnDao.getEducationList();
    };

    public List<GubnDto> getEmploymentList(){
        return gubnDao.getEmploymentList();
    };

    public List<GubnDto> getStackList(){
        return gubnDao.getStackList();
    };

    public List<GubnDto> getStack1thList(){
        return gubnDao.getStack1thList();
    };

    public List<GubnDto> getApplicationList(){
        return gubnDao.getApplicationList();
    };

    public List<GubnDto> getProcedureList(){
        return gubnDao.getProcedureList();
    };
}
