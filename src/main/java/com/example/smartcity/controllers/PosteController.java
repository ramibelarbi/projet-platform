package com.example.smartcity.controllers;

import com.example.smartcity.models.Poste;
import com.example.smartcity.services.PosteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/administration/poste")
@AllArgsConstructor
public class PosteController {
    PosteService posteService;

    @GetMapping("/all")
    ResponseEntity<List<Poste>> getAllPoste(){
        List<Poste> postes = posteService.getAllPostes();
        return new ResponseEntity<>(postes, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    ResponseEntity<Poste> getPoste(@PathVariable("id") Long id){
        Poste poste = posteService.getPoste(id);
        return new ResponseEntity<>(poste,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Poste> addPoste(@RequestBody Poste poste){
        Poste newPoste = posteService.addPoste(poste);
        return new ResponseEntity<>(poste,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Poste> updatePoste(@RequestBody Poste poste){
        Poste newPoste = posteService.updatePoste(poste);
        return new ResponseEntity<>(poste,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deletePoste(@PathVariable("id") Long id){
        posteService.deletePoste(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
