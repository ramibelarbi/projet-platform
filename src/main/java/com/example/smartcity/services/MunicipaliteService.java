package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Hopital;
import com.example.smartcity.models.Municipalite;
import com.example.smartcity.repos.MunicipaliteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @AllArgsConstructor
public class MunicipaliteService {
    private final MunicipaliteRepo municipaliteRepo;

    public Municipalite addMunicipalite(Municipalite municipalite){
        return municipaliteRepo.save(municipalite);
    }

    public Municipalite getMunicipalite(Long id){
        return municipaliteRepo.getMunicipaliteById(id).orElseThrow(()->new NotFoundException("Municipalite avec id "+id+" non trouve!"));
    }

    public List<Municipalite> getAllMunicipalites(){
        return municipaliteRepo.findAll();
    }

    public Municipalite updateMunicipalite(Municipalite municipalite){
        return municipaliteRepo.save(municipalite);
    }
    @Transactional
    public void deleteMunicipalite(Long id){
        municipaliteRepo.deleteMunicipaliteById(id);
    }
}
