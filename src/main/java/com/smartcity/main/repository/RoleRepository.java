package com.smartcity.main.repository;

import com.smartcity.main.model.ERole;
import com.smartcity.main.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
