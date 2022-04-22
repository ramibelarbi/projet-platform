package com.example.smartcity.repos;

import com.example.smartcity.models.Administartion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrationRepo extends JpaRepository<Administartion,Long> {
    Optional<Administartion> getAdministartionById(Long id);
}
