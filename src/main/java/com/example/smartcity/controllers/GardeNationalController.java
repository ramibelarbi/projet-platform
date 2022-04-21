package com.example.smartcity.controllers;

import com.example.smartcity.models.GardeNational;
import com.example.smartcity.services.GardeNationalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/administration/gardenational")
@AllArgsConstructor
public class GardeNationalController {
    GardeNationalService gardeNationalService;

    @GetMapping("/all")
    ResponseEntity<List<GardeNational>> getAllGardeNational(){
        List<GardeNational> gardeNationals = gardeNationalService.getAllGardeNationals();
        return new ResponseEntity<>(gardeNationals, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    ResponseEntity<GardeNational> getGardeNational(@PathVariable("id") Long id){
        GardeNational gardeNational = gardeNationalService.getGardeNational(id);
        return new ResponseEntity<>(gardeNational,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<GardeNational> addGardeNational(@RequestBody GardeNational gardeNational){
        GardeNational newGardeNational = gardeNationalService.addGardeNational(gardeNational);
        return new ResponseEntity<>(gardeNational,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<GardeNational> updateGardeNational(@RequestBody GardeNational gardeNational){
        GardeNational newGardeNational = gardeNationalService.updateGardeNational(gardeNational);
        return new ResponseEntity<>(gardeNational,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteGardeNational(@PathVariable("id") Long id){
        gardeNationalService.deleteGardeNational(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
