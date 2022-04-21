package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.AdresseRepo;
import com.example.smartcity.repos.PersonneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @AllArgsConstructor
public class PersonneService {

    private final PersonneRepo personneRepo;
    private final AdresseRepo adresseRepo;
    //@Autowired removed and constructor removed bring back if a problem happens

    public Personne addPersonne(Personne personne){
        adresseRepo.save(personne.getAdresse());
        return personneRepo.save(personne);
    }
    public List<Personne> getAllPersonnes(){
        return personneRepo.findAll();
    }
    public Personne getPersonneById(Long id){
        return personneRepo.findPersonneById(id).orElseThrow(()-> new NotFoundException("La Personne avec le Id: "+id +"n'a pas ete trouvee!"));
    }
    public Personne updatePersonne(Personne personne){
        adresseRepo.save(personne.getAdresse());
        return personneRepo.save(personne);
    }
    @Transactional
    public void deletePersonne(Long id){
        adresseRepo.delete(personneRepo.findPersonneById(id).get().getAdresse());
        personneRepo.deletePersonneById(id);
    }
}
