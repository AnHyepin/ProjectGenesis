package org.green.backend.service.common;

import lombok.RequiredArgsConstructor;
import org.green.backend.repository.jpa.hws.CompanyRepository;
import org.green.backend.repository.jpa.hws.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            return new CustomUserDetails(userEntity);
        }

        Company companyEntity = companyRepository.findByUsername(username);
        if (companyEntity != null) {
            return new CustomUserDetails(companyEntity);
        }

        throw new UsernameNotFoundException("해당 아이디의 유저 또는 기업이 없습니다: " + username);
    }
}
