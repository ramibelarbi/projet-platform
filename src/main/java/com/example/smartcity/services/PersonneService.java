package com.example.smartcity.services;

import com.example.smartcity.exceptions.PersonneNotFoundException;
import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.PersonneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepo personneRepo;

    @Autowired
    public PersonneService(PersonneRepo personneRepo) {
        this.personneRepo = personneRepo;
    }
    public Personne ajouterPersonne(Personne personne){
        return personneRepo.save(personne);
    }
    public List<Personne> findAllPersonnes(){
        return personneRepo.findAll();
    }
    public Personne findPersonneById(Long id){
        return personneRepo.findPersonneById(id).orElseThrow(()-> new PersonneNotFoundException("La Personne avec le Id: "+id +"n'a pas ete trouvee!"));
    }
    public Personne updatePersonne(Personne personne){
        return personneRepo.save(personne);
    }
    @Transactional
    public void deletePersonne(Long id){
        personneRepo.deletePersonneById(id);
    }
}
