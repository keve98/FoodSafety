package com.example.FoodSafety.DataServices;


import com.example.FoodSafety.DataModels.PoultryRoasting;
import com.example.FoodSafety.DataRepositories.PoultryRoastingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoultryRoastingService {

    private final PoultryRoastingRepository poultryRoastingRepository;

    @Autowired
    public PoultryRoastingService(PoultryRoastingRepository poultryRoastingRepository) {
        this.poultryRoastingRepository = poultryRoastingRepository;
    }

    public List<PoultryRoasting> getAllPoultryRoasts(){
        return poultryRoastingRepository.findAll();
    }

    public PoultryRoasting findById(Long id){
        return poultryRoastingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public PoultryRoasting newPoultryRoasting(PoultryRoasting poultryRoasting){
        PoultryRoasting tmp = new PoultryRoasting();
        tmp = poultryRoasting;
        tmp.setId(null);
        return poultryRoastingRepository.save(tmp);
    }


}
