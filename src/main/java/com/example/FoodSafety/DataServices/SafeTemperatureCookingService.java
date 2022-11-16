package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.SafeTemperatureCooking;
import com.example.FoodSafety.DataRepositories.SafeTemperatireCookingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeTemperatureCookingService {

    private final SafeTemperatireCookingRepository safeTemperatireCookingRepository;

    @Autowired
    public SafeTemperatureCookingService(SafeTemperatireCookingRepository safeTemperatireCookingRepository) {
        this.safeTemperatireCookingRepository = safeTemperatireCookingRepository;
    }

    public List<SafeTemperatureCooking> getAllSafeTemperatureCooks(){
        return safeTemperatireCookingRepository.findAll();
    }

    public SafeTemperatureCooking findById(Long id){
        return safeTemperatireCookingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public SafeTemperatureCooking newSafeTemperatureCook(SafeTemperatureCooking HamCooking){
        SafeTemperatureCooking tmp = new SafeTemperatureCooking();
        tmp = HamCooking;
        tmp.setId(null);
        return safeTemperatireCookingRepository.save(tmp);
    }


}
