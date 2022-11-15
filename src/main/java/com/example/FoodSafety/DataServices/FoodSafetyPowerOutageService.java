package com.example.FoodSafety.DataServices;


import com.example.FoodSafety.DataModels.FoodSafetyPowerOutage;
import com.example.FoodSafety.DataRepositories.FoodSafetyPowerOutageRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodSafetyPowerOutageService {

    private final FoodSafetyPowerOutageRepository foodSafetyPowerOutageRepository;

    @Autowired
    public FoodSafetyPowerOutageService(FoodSafetyPowerOutageRepository foodSafetyPowerOutageRepository) {
        this.foodSafetyPowerOutageRepository = foodSafetyPowerOutageRepository;
    }

    public List<FoodSafetyPowerOutage> getAllFoodSafetyPowerOutages(){
        return foodSafetyPowerOutageRepository.findAll();
    }

    public FoodSafetyPowerOutage findById(Long id){
        return foodSafetyPowerOutageRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public FoodSafetyPowerOutage newFoodSafetyPowerOutage(FoodSafetyPowerOutage FoodSafetyPowerOutage){
        FoodSafetyPowerOutage tmp = new FoodSafetyPowerOutage();
        tmp = FoodSafetyPowerOutage;
        tmp.setId(null);
        return foodSafetyPowerOutageRepository.save(tmp);
    }

}
