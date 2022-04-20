package com.example.smartcity.repos;

import com.example.smartcity.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepo extends JpaRepository<Personne,Long> {
    Optional<Personne> findPersonneById(Long id);
    void deletePersonneById(Long id);
}
