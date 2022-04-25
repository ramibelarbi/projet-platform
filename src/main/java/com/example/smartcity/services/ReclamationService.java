package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Personne;
import com.example.smartcity.models.Reclamation;
import com.example.smartcity.repos.ReclamationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class ReclamationService {
    private final ReclamationRepo reclamationRepo;

    public Reclamation addReclamation(Reclamation reclamation){
        return reclamationRepo.save(reclamation);
    }

    public List<Reclamation> getReclamationsCitoyen(Personne citoyen){
        return reclamationRepo.findByCitoyen(citoyen);
    }

    public List<Reclamation> getReclamationsAdministration(Administartion administartion){
        return reclamationRepo.findByAdministartion(administartion);
    }

    public Reclamation getReclamation(Long id){
        return reclamationRepo.getReclamationById(id).orElseThrow(()->new NotFoundException("Reclamation avec l'id "+ id +" ne se trouve pas!"));
    }
}
