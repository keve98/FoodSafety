package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.SafeTemperatureCooking;
import com.example.FoodSafety.DataRepositories.SafeTemperatureCookingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeTemperatureCookingService {

    private final SafeTemperatureCookingRepository safeTemperatureCookingRepository;

    @Autowired
    public SafeTemperatureCookingService(SafeTemperatureCookingRepository safeTemperatureCookingRepository) {
        this.safeTemperatureCookingRepository = safeTemperatureCookingRepository;
    }

    public List<SafeTemperatureCooking> getAllSafeTemperatureCooks(){
        return safeTemperatureCookingRepository.findAll();
    }

    public SafeTemperatureCooking findById(Long id){
        return safeTemperatureCookingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public SafeTemperatureCooking newSafeTemperatureCook(SafeTemperatureCooking HamCooking){
        SafeTemperatureCooking tmp = new SafeTemperatureCooking();
        tmp = HamCooking;
        tmp.setFoodCategory(tmp.getFoodCategory().toLowerCase());
        tmp.setFoodType(tmp.getFoodType().toLowerCase());
        tmp.setInternalTemperatureInformation(tmp.getInternalTemperatureInformation().toLowerCase());
        tmp.setId(null);
        return safeTemperatureCookingRepository.save(tmp);
    }

    public List<SafeTemperatureCooking> findByCategoryAndType(String type, String category){
        return safeTemperatureCookingRepository.searchSafeTemperatureCookingByFoodTypeAndFoodCategory(type, category);
    }

    public List<SafeTemperatureCooking> findByInformation(String inf) {
        return safeTemperatureCookingRepository.searchSafeTemperatureCookingByInformation(inf);
    }
}
