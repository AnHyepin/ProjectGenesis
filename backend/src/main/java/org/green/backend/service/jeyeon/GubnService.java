package org.green.backend.service.jeyeon;

import org.green.backend.dto.jeyeon.GubnDto;
import org.green.backend.repository.dao.jeyeon.GubnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
