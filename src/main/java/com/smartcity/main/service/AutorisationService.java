package com.smartcity.main.service;

import com.smartcity.main.model.Autorisation;
import com.smartcity.main.model.Document;
import com.smartcity.main.model.Organisation;
import com.smartcity.main.model.User;
import com.smartcity.main.repository.AutorisationRepository;
import com.smartcity.main.repository.OrganisationRepository;
import com.smartcity.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class AutorisationService {

    @Autowired
    AutorisationRepository autorisationrepository;
    UserRepository userRepository;
    OrganisationRepository organisationRepository;



    public void requestFile(Autorisation au) {
        autorisationrepository.save(au);
    }


    public void GetAutorisation(Long id) {
        Autorisation au= autorisationrepository.findById(id).get();
        au.setAccepted(true);
        autorisationrepository.save(au);

    }
    public Long getIdWithDateDemandeAccess(Date date) {
        return autorisationrepository.findByDateDemandeAcces(date).getId();
    }



}
