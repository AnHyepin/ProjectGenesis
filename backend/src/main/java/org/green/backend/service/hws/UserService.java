package org.green.backend.service.hws;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.green.backend.dto.hws.UserDto;
import org.green.backend.entity.User;
import org.green.backend.entity.common.Address;
import org.green.backend.exception.hws.UserAlreadyExistsException;
import org.green.backend.repository.jpa.hws.UserRepository;
import org.green.backend.service.common.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 12-27 (작성자: 한우성)
 * 구직자 정보를 관리하는 서비스
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final FileService fileService;

    /**
     * 사용자 정보를 저장하고 프로필 사진을 저장.
     */
    public void saveUser(UserDto user, MultipartFile profilePicture) throws IOException {
        log.info("Save user: {}", user);

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException("해당 아이디 : '" + user.getUsername() + "' 중복된 아이디 입니다.");
        }

        User userEntity = modelMapper.map(user, User.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setDeleteYn('N');
        Address address = user.toAddress();
        userEntity.setAddress(address);
        userRepository.save(userEntity);


        if (profilePicture != null && !profilePicture.isEmpty()) {
            fileService.saveFile(profilePicture, "profile_user", user.getUsername(), user.getUsername());
        }
    }


    /**
     * 이름으로 사용자 정보를 조회.
     * //TODO : 사용? 추후 삭제
     */
    public Page<UserDto> getUsersByName(String name, Pageable pageable) {
        Page<User> userPage = userRepository.findByNameContaining(name, pageable);

        return userPage.map(user -> modelMapper.map(user, UserDto.class));
    }

    /**
     * 모든 사용자 정보를 조회.
     */
    public Page<UserDto> getAllUsers(Pageable pageable) {

        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> modelMapper.map(user, UserDto.class));
    }

    /**
     * 사용자 상태를 변경.
     */
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

    /**
     * 사용자 아이디 중복 여부를 확인.
     */
    public String duplicateCheck(String username) {
        return userRepository.findByUsername(username) != null ? "중복됨" : "사용 가능";
    }

}
