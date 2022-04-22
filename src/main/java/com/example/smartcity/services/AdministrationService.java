package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Administartion;
import com.example.smartcity.repos.AdministrationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class AdministrationService {
    private final AdministrationRepo administrationRepo;

    public List<Administartion> getAllAdministartions(){
        return administrationRepo.findAll();
    }
    public Administartion getAdministration(Long id){
        return  administrationRepo.getAdministartionById(id).orElseThrow(()-> new NotFoundException("Administration avec l'id "+id+" n'existe pas"));
    }
}
