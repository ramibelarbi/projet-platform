package com.example.smartcity.repos;


import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Personne;
import com.example.smartcity.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReclamationRepo extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findByCitoyen(Personne citoyen);
    List<Reclamation> findByAdministartion(Administartion administartion);
    Optional<Reclamation> getReclamationById(Long id);
}
