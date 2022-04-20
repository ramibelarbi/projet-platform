package com.example.smartcity.controllers;


import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.PersonneRepo;
import com.example.smartcity.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/personne")
public class PersonneController {
    @Autowired
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes(){
        List<Personne> personnes = personneService.findAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable("id") Long id){
        Personne personne = personneService.findPersonneById(id);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Personne> addPersonne(@RequestBody Personne personne){
        Personne newPersonne = personneService.ajouterPersonne(personne);
        return new ResponseEntity<>(newPersonne,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Personne> updatePersonne(@RequestBody Personne personne){
        Personne newPersonne = personneService.updatePersonne(personne);
        return new ResponseEntity<>(newPersonne,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonne(@PathVariable("id") Long id){
        personneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
