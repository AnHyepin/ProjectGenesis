package org.green.backend.service.hyepin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.entity.User;
import org.green.backend.repository.dao.hyepin.ResumeDao;
import org.green.backend.repository.jpa.hws.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceAhp {

    private final UserRepository userRepository;
    private final ResumeDao resumeDao;

    public User getUser(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    public int getResumeMaxNumByUsername(String username){
        int maxNum = resumeDao.getMaxNum(username);
        return maxNum;
    }

}