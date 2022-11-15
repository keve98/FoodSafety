package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.ColdFoodStorage;
import com.example.FoodSafety.DataModels.TurkeyThawing;
import com.example.FoodSafety.DataRepositories.ColdFoodStorageRepository;
import com.example.FoodSafety.DataRepositories.TurkeyRoastingRepository;
import com.example.FoodSafety.DataRepositories.TurkeyThawingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurkeyThawingService {

    private final TurkeyThawingRepository turkeyThawingRepository;

    @Autowired
    public TurkeyThawingService(TurkeyThawingRepository turkeyThawingRepository) {
        this.turkeyThawingRepository = turkeyThawingRepository;
    }

    public List<TurkeyThawing> getAllTurkeyThawes(){
        return turkeyThawingRepository.findAll();
    }

    public TurkeyThawing findById(Long id){
        return turkeyThawingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public TurkeyThawing newTurkeyThawe(TurkeyThawing turkeyThawing){
        TurkeyThawing tmp = new TurkeyThawing();
        tmp = turkeyThawing;
        tmp.setId(null);
        return turkeyThawingRepository.save(tmp);
    }
}
