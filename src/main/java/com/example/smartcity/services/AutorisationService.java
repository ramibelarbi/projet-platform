package com.example.smartcity.services;

import com.example.smartcity.models.Autorisation;
import com.example.smartcity.repos.AdministrationRepo;
import com.example.smartcity.repos.AutorisationRepository;
import com.example.smartcity.repos.PersonneRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AutorisationService {

    @Autowired
    AutorisationRepository autorisationRepository;
    PersonneRepo personneRepo;
    AdministrationRepo administrationRepo;



    public Autorisation requestFile(Autorisation autorisation) {
        return autorisationRepository.save(autorisation);
    }


    public Autorisation giveAutorisation(Long id) {
        Autorisation autorisation= autorisationRepository.findById(id).get();
        autorisation.setAccepted(true);
        autorisation.setDateReponse(new Date());
        return autorisationRepository.save(autorisation);

    }
    public Long getIdWithDateDemandeAccess(Date date) {
        return autorisationRepository.findByDateDemandeAcces(date).getId();
    }



}
