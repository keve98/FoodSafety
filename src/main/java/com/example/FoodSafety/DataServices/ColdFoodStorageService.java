package com.example.FoodSafety.DataServices;


import com.example.FoodSafety.DataModels.ColdFoodStorage;
import com.example.FoodSafety.DataRepositories.ColdFoodStorageRepository;
import com.example.FoodSafety.Eceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColdFoodStorageService {

    private final ColdFoodStorageRepository coldFoodStorageRepository;

    @Autowired
    public ColdFoodStorageService(ColdFoodStorageRepository coldFoodStorageRepository) {
        this.coldFoodStorageRepository = coldFoodStorageRepository;
    }

    public List<ColdFoodStorage> getAllColdFoods(){
        return coldFoodStorageRepository.findAll();
    }

    public ColdFoodStorage findById(Long id){
        return coldFoodStorageRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public ColdFoodStorage newColdFoodStorage(ColdFoodStorage coldFoodStorage){
        ColdFoodStorage tmp = new ColdFoodStorage();
        tmp = coldFoodStorage;
        tmp.setId(null);
        return coldFoodStorageRepository.save(tmp);
    }

}
