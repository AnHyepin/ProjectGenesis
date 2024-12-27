package org.green.backend.repository.jpa.hws;


import org.green.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Boolean existsByUsername(String username);

    Company findByUsername(String username);
}