package com.example.FoodSafety.DataServices;

import com.example.FoodSafety.DataModels.TurkeyRoasting;
import com.example.FoodSafety.DataRepositories.TurkeyRoastingRepository;
import com.example.FoodSafety.Exceptions.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurkeyRoastingService {

    private final TurkeyRoastingRepository turkeyRoastingRepository;

    @Autowired
    public TurkeyRoastingService(TurkeyRoastingRepository turkeyRoastingRepository) {
        this.turkeyRoastingRepository = turkeyRoastingRepository;
    }

    public List<TurkeyRoasting> getAllTurkeyRoasts(){
        return turkeyRoastingRepository.findAll();
    }

    public TurkeyRoasting findById(Long id){
        return turkeyRoastingRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public TurkeyRoasting newTurkeyRoast(TurkeyRoasting turkeyRoasting){
        TurkeyRoasting tmp = new TurkeyRoasting();
        tmp = turkeyRoasting;
        tmp.setId(null);
        return turkeyRoastingRepository.save(tmp);
    }


}
