package com.example.smartcity.repos;

import com.example.smartcity.models.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HopitalRepo extends JpaRepository<Hopital,Long> {
    Optional<Hopital> findHopitalById(Long id);
    void deleteHopitalById(Long id);
}
