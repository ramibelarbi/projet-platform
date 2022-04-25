package com.example.smartcity.controllers;


import com.example.smartcity.models.Gouvernerat;
import com.example.smartcity.models.Personne;
import com.example.smartcity.models.Role;
import com.example.smartcity.services.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/personne") @AllArgsConstructor @CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class PersonneController {
    //@Autowired removed bring back if any problem occurs
    private final PersonneService personneService;

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes(){
        List<Personne> personnes = personneService.getAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }
    @GetMapping("/administratuers/all")
    public ResponseEntity<List<Personne>> getAllAdministrateurs(){
        List<Personne> administrateurs = personneService.getPersonnesByRole(Role.Administrateur);
        return new ResponseEntity<>(administrateurs, HttpStatus.OK);
    }
    @GetMapping("/employes/all")
    public ResponseEntity<List<Personne>> getAllEmployes(){
        List<Personne> employes = personneService.getPersonnesByRole(Role.Employe);
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @GetMapping("/citoyens/all")
    public ResponseEntity<List<Personne>> getAllCitoyens(){
        List<Personne> citoyens = personneService.getPersonnesByRole(Role.Citoyen);
        return new ResponseEntity<>(citoyens, HttpStatus.OK);
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
    @GetMapping("/gouvernerat/{gouvernerat}")
    public ResponseEntity<List<Personne>> getPersonneByGouvernerat(@PathVariable Gouvernerat gouvernerat){
        List<Personne> personnes = personneService.getPersonnesByGouvernerat(gouvernerat);
        return new ResponseEntity<>(personnes, HttpStatus.OK);
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
