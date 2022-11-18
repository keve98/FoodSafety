package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.MeatRoasting;
import com.example.FoodSafety.DataRepositories.MeatRoastingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatRoastingService {

    private final MeatRoastingRepository meatRoastingRepository;

    @Autowired
    public MeatRoastingService(MeatRoastingRepository meatRoastingRepository) {
        this.meatRoastingRepository = meatRoastingRepository;
    }

    public List<MeatRoasting> getAllMeatRoasts(){
        return meatRoastingRepository.findAll();
    }

    public MeatRoasting findById(Long id){
        return meatRoastingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public MeatRoasting newMeatRoasting(MeatRoasting meatRoasting){
        MeatRoasting tmp = new MeatRoasting();
        tmp = meatRoasting;
        tmp.setFoodCategory(tmp.getFoodCategory().toLowerCase());
        tmp.setFoodType(tmp.getFoodType().toLowerCase());
        tmp.setTimingInformation(tmp.getTimingInformation().toLowerCase());
        tmp.setOvenTemperatureInFInformation(tmp.getOvenTemperatureInFInformation().toLowerCase());
        tmp.setId(null);
        return meatRoastingRepository.save(tmp);
    }

    public List<MeatRoasting> findByCategoryAndType(String type, String category){
        return meatRoastingRepository.searchMeatRoastingByFoodTypeAndFoodCategory(type, category);
    }

    public List<MeatRoasting> findByInformation(String inf) {
        return meatRoastingRepository.searchMeatRoastingByInformation(inf);
    }
}
