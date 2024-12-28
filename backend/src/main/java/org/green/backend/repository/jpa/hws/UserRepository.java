package org.green.backend.repository.jpa.hws;

import org.green.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    Page<User> findByNameContaining(String name, Pageable pageable);

    Page<User> findAll(Pageable pageable);

}
