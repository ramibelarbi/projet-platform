package com.example.smartcity.repos;

import com.example.smartcity.models.Gouvernerat;
import com.example.smartcity.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonneRepo extends JpaRepository<Personne,Long> {
    Optional<Personne> findPersonneById(Long id);
    void deletePersonneById(Long id);
    List<Personne> findPersonnesByAdresse_Gouvernerat(Gouvernerat gouvernerat);
    List<Personne> findPersonneByAdresse_Ville(String ville);
    Personne findPersonneByCin(String cin);
}
