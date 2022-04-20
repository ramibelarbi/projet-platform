package com.example.smartcity.repos;

import com.example.smartcity.models.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepo extends JpaRepository<Poste,Long> {
}
