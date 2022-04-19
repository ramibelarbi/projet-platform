package com.example.smartcity.repos;

import com.example.smartcity.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <Employe,Long> {
    Employe findByNom(String nom);
    Iterable<Employe> findAllById(Long id);
}
