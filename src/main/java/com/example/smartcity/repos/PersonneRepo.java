package com.example.smartcity.repos;

import com.example.smartcity.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PersonneRepo extends JpaRepository<Personne,Long> {
    Personne findById(Id id);
}
