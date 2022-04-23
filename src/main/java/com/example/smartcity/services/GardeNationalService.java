package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.GardeNational;
import com.example.smartcity.repos.GardeNationalRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service@AllArgsConstructor
public class GardeNationalService {
    private final GardeNationalRepo gardeNationalRepo;

    public GardeNational addGardeNational(GardeNational gardeNational){
        return gardeNationalRepo.save(gardeNational);
    }

    public GardeNational getGardeNational(Long id){
        return gardeNationalRepo.findGardeNationalById(id).orElseThrow(()->new NotFoundException("Garde nationale avec id "+id+" non trouve!"));
    }

    public List<GardeNational> getAllGardeNationals(){
        return gardeNationalRepo.findAll();
    }

    public GardeNational updateGardeNational(GardeNational gardeNational){
        return gardeNationalRepo.save(gardeNational);
    }
    @Transactional
    public void deleteGardeNational(Long id){
        gardeNationalRepo.deleteGardeNationalById(id);
    }
}
