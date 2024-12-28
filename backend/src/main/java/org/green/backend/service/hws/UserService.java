package org.green.backend.service.hws;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.UserDto;
import org.green.backend.entity.User;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.repository.jpa.hws.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    public void saveUser(UserDto user) {

        log.info("save user {}", user);

        Boolean isExist = userRepository.existsByUsername(user.getUsername());

        if (isExist) {
            throw new UserAlreadyExistsException("해당 아이디 : '" + user.getUsername() + "' 중복된 아이디 입니다. ");
        }

        User userEntity = modelMapper.map(user, User.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setDeleteYn('N');
        userRepository.save(userEntity);
    }


    //TODO : 사용? 추후 삭제
    public Page<UserDto> getUsersByName(String name, Pageable pageable) {
        Page<User> userPage = userRepository.findByNameContaining(name, pageable);

        return userPage.map(user -> modelMapper.map(user, UserDto.class));
    }



    public Page<UserDto> getAllUsers(Pageable pageable) {

        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> modelMapper.map(user, UserDto.class));
    }

    public String userStatusChange(String username) {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            return "변경 실패";
        }

        log.info(userEntity.toString());

        userEntity.setDeleteYn(userEntity.getDeleteYn().equals('Y') ? 'N' : 'Y');

        userRepository.save(userEntity);
        return "변경 성공";
    }
}
