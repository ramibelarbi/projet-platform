package com.example.smartcity.services;

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
}
