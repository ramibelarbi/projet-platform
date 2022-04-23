package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Hopital;
import com.example.smartcity.repos.HopitalRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service@AllArgsConstructor
public class HopitalService {
    private final HopitalRepo hopitalRepo;

    public Hopital addHopital(Hopital hopital){
        return hopitalRepo.save(hopital);
    }

    public Hopital getHopital(Long id){
        return hopitalRepo.findHopitalById(id).orElseThrow(()->new NotFoundException("Hopital avec id "+id+" non trouve!"));
    }

    public List<Hopital> getAllHopitals(){
        return hopitalRepo.findAll();
    }

    public Hopital updateHopital(Hopital hopital){
        return hopitalRepo.save(hopital);
    }
    @Transactional
    public void deleteHopital(Long id){
        hopitalRepo.deleteHopitalById(id);
    }
}
