package org.green.backend.repository.jpa.hws;

import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hws.UserWithFileDto;
import org.green.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    Page<User> findByNameContaining(String name, Pageable pageable);

    Page<User> findAll(Pageable pageable);

    @Query("SELECT new org.green.backend.dto.hws.UserWithFileDto(u, f) " +
            "FROM User u LEFT JOIN File f ON u.username = f.fileRefNo AND f.fileGubnCode = :gubnCode " +
            "WHERE u.username = :username")
    UserWithFileDto findUserWithFileByUsername(@Param("username") String username, @Param("gubnCode") String gubnCode);


}