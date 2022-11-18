package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.HamCooking;
import com.example.FoodSafety.DataRepositories.HamCookingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HamCookingService {

    private final HamCookingRepository hamCookingRepository;

    @Autowired
    public HamCookingService(HamCookingRepository hamCookingRepository) {
        this.hamCookingRepository = hamCookingRepository;
    }

    public List<HamCooking> getAllHamCooks(){
        return hamCookingRepository.findAll();
    }

    public HamCooking findById(Long id){
        return hamCookingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public HamCooking newHamCooking(HamCooking HamCooking){
        HamCooking tmp = new HamCooking();
        tmp = HamCooking;
        tmp.setFoodCategory(tmp.getFoodCategory().toLowerCase());
        tmp.setFoodType(tmp.getFoodType().toLowerCase());
        tmp.setCookingInformation(tmp.getCookingInformation().toLowerCase());
        tmp.setTimingInformation(tmp.getTimingInformation().toLowerCase());
        tmp.setWeightInformation(tmp.getWeightInformation().toLowerCase());
        tmp.setId(null);
        return hamCookingRepository.save(tmp);
    }

    public List<HamCooking> findByCategoryAndType(String type, String category){
        return hamCookingRepository.searchHamCookingByFoodTypeAndFoodCategory(type, category);
    }

    public List<HamCooking> findByInformation(String inf) {
        return hamCookingRepository.searchHamCookingByInformation(inf);
    }
}
