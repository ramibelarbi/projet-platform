package com.example.smartcity.repos;

import com.example.smartcity.models.Municipalite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MunicipaliteRepo extends JpaRepository<Municipalite,Long> {
    Optional<Municipalite> getMunicipaliteById(Long id);
    void deleteMunicipaliteById(Long id);
}
