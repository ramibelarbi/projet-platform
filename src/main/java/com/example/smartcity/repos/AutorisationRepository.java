package com.example.smartcity.repos;

import com.example.smartcity.models.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AutorisationRepository extends JpaRepository<Autorisation,Long> {
  Autorisation findByDateDemandeAcces(Date dateDemandeAcces);
}
