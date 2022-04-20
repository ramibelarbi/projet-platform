package com.smartcity.main.repository;

import com.smartcity.main.model.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AutorisationRepository extends JpaRepository<Autorisation,Long> {
  public Autorisation findByDateDemandeAcces(Date dateDemandeAcces);
}
