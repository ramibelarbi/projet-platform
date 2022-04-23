package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Poste;
import com.example.smartcity.repos.PosteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @AllArgsConstructor
public class PosteService {
    private final PosteRepo posteRepo;

    public Poste addPoste(Poste poste){
        return posteRepo.save(poste);
    }

    public Poste getPoste(Long id){
        return posteRepo.getPosteById(id).orElseThrow(()->new NotFoundException("Poste avec id "+id+" non trouve!"));
    }

    public List<Poste> getAllPostes(){
        return posteRepo.findAll();
    }

    public Poste updatePoste(Poste poste){
        return posteRepo.save(poste);
    }
    @Transactional
    public void deletePoste(Long id){
        posteRepo.deletePosteById(id);
    }
}
