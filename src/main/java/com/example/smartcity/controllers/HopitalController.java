package com.example.smartcity.controllers;

import com.example.smartcity.models.Hopital;
import com.example.smartcity.services.HopitalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/administration/hopital")
@AllArgsConstructor
public class HopitalController {
    HopitalService hopitalService;

    @GetMapping("/all")
    ResponseEntity<List<Hopital>> getAllHopital(){
        List<Hopital> hopitals = hopitalService.getAllHopitals();
        return new ResponseEntity<>(hopitals, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    ResponseEntity<Hopital> getHopital(@PathVariable("id") Long id){
        Hopital hopital = hopitalService.getHopital(id);
        return new ResponseEntity<>(hopital,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Hopital> addHopital(@RequestBody Hopital hopital){
        Hopital newHopital = hopitalService.addHopital(hopital);
        return new ResponseEntity<>(hopital,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Hopital> updateHopital(@RequestBody Hopital hopital){
        Hopital newHopital = hopitalService.updateHopital(hopital);
        return new ResponseEntity<>(hopital,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteHopital(@PathVariable("id") Long id){
        hopitalService.deleteHopital(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
