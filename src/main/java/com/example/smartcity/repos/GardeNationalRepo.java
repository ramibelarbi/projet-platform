package com.example.smartcity.repos;

import com.example.smartcity.models.GardeNational;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GardeNationalRepo extends JpaRepository<GardeNational,Long> {
    Optional<GardeNational> findGardeNationalById(Long id);
    void deleteGardeNationalById(Long id);
}
