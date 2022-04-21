package com.example.smartcity.controllers;

import com.example.smartcity.models.Municipalite;
import com.example.smartcity.services.HopitalService;
import com.example.smartcity.services.MunicipaliteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/administration/municipalite")
@AllArgsConstructor
public class MunicipaliteController {
    MunicipaliteService municipaliteService;

    @GetMapping("/all")
    ResponseEntity<List<Municipalite>> getAllMunicipalite(){
        List<Municipalite> municipalites = municipaliteService.getAllMunicipalites();
        return new ResponseEntity<>(municipalites, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    ResponseEntity<Municipalite> getMunicipalite(@PathVariable("id") Long id){
        Municipalite municipalite = municipaliteService.getMunicipalite(id);
        return new ResponseEntity<>(municipalite,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Municipalite> addMunicipalite(@RequestBody Municipalite municipalite){
        Municipalite newMunicipalite = municipaliteService.addMunicipalite(municipalite);
        return new ResponseEntity<>(municipalite,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Municipalite> updateMunicipalite(@RequestBody Municipalite municipalite){
        Municipalite newMunicipalite = municipaliteService.updateMunicipalite(municipalite);
        return new ResponseEntity<>(municipalite,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteMunicipalite(@PathVariable("id") Long id){
        municipaliteService.deleteMunicipalite(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
