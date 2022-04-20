package com.smartcity.main.service;


import com.smartcity.main.model.Organisation;
import com.smartcity.main.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    public void AddOrganisation(String fullName) throws IOException {
        Organisation organisation=new Organisation(0L, fullName);
        organisationRepository.save(organisation);
        Files.createDirectory(Path.of("files/" + fullName));
    }

    public Organisation getOrganisation(Long id) {
        Optional<Organisation> organisation=organisationRepository.findById(id);
        if(organisation.isPresent()) {
            return organisation.get();
        }
        return null;
    }

    public void DeleteOrganisation(Long id) {
        organisationRepository.delete(organisationRepository.getById(id));
    }
}
