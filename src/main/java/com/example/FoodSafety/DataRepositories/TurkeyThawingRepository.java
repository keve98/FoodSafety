package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.TurkeyRoasting;
import com.example.FoodSafety.DataModels.TurkeyThawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurkeyThawingRepository extends JpaRepository<TurkeyThawing, Long> {

    @Query(value = "select s from TurkeyThawing s where s.FoodCategory like %:category%")
    List<TurkeyThawing> searchTurkeyThawingByFoodTypeAndFoodCategory(@Param("category") String category);


}
