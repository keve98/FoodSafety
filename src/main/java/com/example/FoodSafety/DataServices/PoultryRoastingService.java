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
        tmp.setFoodCategory(tmp.getFoodCategory().toLowerCase());
        tmp.setFoodType(tmp.getFoodType().toLowerCase());
        tmp.setTimingInformation(tmp.getTimingInformation().toLowerCase());
        tmp.setOvenTemperatureInFInformation(tmp.getOvenTemperatureInFInformation().toLowerCase());
        tmp.setId(null);
        return poultryRoastingRepository.save(tmp);
    }

    public List<PoultryRoasting> findByCategoryAndType(String type, String category){
        return poultryRoastingRepository.searchPoultryRoastingByFoodTypeAndFoodCategory(type, category);
    }

    public List<PoultryRoasting> findByInformation(String inf) {
        return poultryRoastingRepository.searchPoultryRoastingByInformation(inf);
    }
}
