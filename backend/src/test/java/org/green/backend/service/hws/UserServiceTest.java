package org.green.backend.service.hws;

import org.green.backend.dto.hws.UserDto;
import org.green.backend.entity.User;
import org.green.backend.repository.jpa.hws.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenUserNameAndPagination_WhenFindByNameContaining_ThenReturnPagedUserDtos() {

        // Given
        String searchName = "John";
        Pageable pageable = PageRequest.of(0, 10);
        User user = new User("john123", "password", "John", "john@example.com", 'M', null, "1234567890", null, "ROLE_USER", 'N');
        UserDto userDto = new UserDto();
        userDto.setUsername("john123");
        userDto.setName("John");
        userDto.setEmail("john@example.com");
        userDto.setPhone("1234567890");

        Page<User> userPage = new PageImpl<>(List.of(user), pageable, 1);

        when(userRepository.findByNameContaining(searchName, pageable)).thenReturn(userPage);
        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);

        // When
        Page<UserDto> result = userService.getUsersByName(searchName, pageable);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(1);
        assertThat(result.getContent().get(0).getName()).isEqualTo("John");
    }

    @Test
    void givenPagination_WhenFindAllUsers_ThenReturnPagedUserDtos() {

        // Given
        Pageable pageable = PageRequest.of(0, 10);

        User user1 = new User("john123", "password", "John", "john@example.com", 'M', null, "1234567890", null, "ROLE_USER", 'N');
        User user2 = new User("jane123", "password", "Jane", "jane@example.com", 'F', null, "0987654321", null, "ROLE_USER", 'N');

        UserDto userDto1 = new UserDto();
        userDto1.setUsername("john123");
        userDto1.setName("John");
        userDto1.setEmail("john@example.com");
        userDto1.setPhone("1234567890");

        UserDto userDto2 = new UserDto();
        userDto2.setUsername("jane123");
        userDto2.setName("Jane");
        userDto2.setEmail("jane@example.com");
        userDto2.setPhone("0987654321");

        Page<User> userPage = new PageImpl<>(List.of(user1, user2), pageable, 2);

        when(userRepository.findAll(pageable)).thenReturn(userPage);
        when(modelMapper.map(user1, UserDto.class)).thenReturn(userDto1);
        when(modelMapper.map(user2, UserDto.class)).thenReturn(userDto2);

        // When
        Page<UserDto> result = userService.getAllUsers(pageable);


        // Then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).getName()).isEqualTo("John");
        assertThat(result.getContent().get(1).getName()).isEqualTo("Jane");
    }
}
