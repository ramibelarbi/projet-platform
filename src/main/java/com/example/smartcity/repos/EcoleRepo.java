package com.example.smartcity.repos;

import com.example.smartcity.models.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EcoleRepo extends JpaRepository<Ecole,Long> {
    Optional<Ecole> findEcoleById(Long id);
    void deleteEcoleById(Long id);
}
