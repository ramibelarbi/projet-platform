package com.example.smartcity.controllers;


import com.example.smartcity.models.Personne;
import com.example.smartcity.services.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/personne") @AllArgsConstructor
public class PersonneController {
    //@Autowired removed bring back if any problem occurs
    private final PersonneService personneService;

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes(){
        List<Personne> personnes = personneService.getAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable("id") Long id){
        Personne personne = personneService.getPersonneById(id);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity<Personne> getPersonneByCin(@PathVariable("cin") String cin){
        Personne personne = personneService.getPersonneByCin(cin);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Personne> addPersonne(@RequestBody Personne personne){
        Personne newPersonne = personneService.addPersonne(personne);
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
