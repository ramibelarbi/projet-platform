package com.example.smartcity.repos;

import com.example.smartcity.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepo extends JpaRepository<Adresse,Long> {
    void deleteAdresseById(Long id);
}
