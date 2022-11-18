package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.FoodSafetyPowerOutage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodSafetyPowerOutageRepository extends JpaRepository<FoodSafetyPowerOutage, Long> {

    @Query(value = "select f from FoodSafetyPowerOutage f where f.FoodCategory like %:category% and f.FoodType like %:type%")
    List<FoodSafetyPowerOutage> searchFoodSafetyPowerOutageByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);

    @Query(value = "select f from FoodSafetyPowerOutage f where f.FoodCategory like %:inf% or f.FoodType like %:inf% or f.HeldAboveFourtyOverTwoHoursInformation like %:inf%")
    List<FoodSafetyPowerOutage> searchFoodSafetyPowerOutageByInformation(@Param("inf") String inf);
}
