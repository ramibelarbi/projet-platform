package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Ecole;
import com.example.smartcity.repos.EcoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service@AllArgsConstructor
public class EcoleService {
    private final EcoleRepo ecoleRepo;

    public Ecole addEcole(Ecole ecole){
        return ecoleRepo.save(ecole);
    }
    public List<Ecole> getAllEcoles(){
        return ecoleRepo.findAll();
    }
    public Ecole getEcole(Long id){
        return ecoleRepo.findEcoleById(id).orElseThrow(()->new NotFoundException("Ecole avec id"+id+"non trouve!"));
    }
    public Ecole updateEcole(Ecole ecole){
        return ecoleRepo.save(ecole);
    }
    @Transactional
    public void deleteEcole(Long id){
        ecoleRepo.deleteEcoleById(id);
    }
}
