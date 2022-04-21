package com.example.smartcity.repos;

import com.example.smartcity.models.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PosteRepo extends JpaRepository<Poste,Long> {
    Optional<Poste> getPosteById(Long id);
    void deletePosteById(Long id);
}
