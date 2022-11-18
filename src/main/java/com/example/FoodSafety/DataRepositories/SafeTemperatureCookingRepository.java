package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.SafeTemperatureCooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SafeTemperatureCookingRepository extends JpaRepository<SafeTemperatureCooking, Long> {

    @Query(value = "select s from SafeTemperatureCooking s where s.FoodCategory like %:category% and s.FoodType like %:type%")
    List<SafeTemperatureCooking> searchSafeTemperatureCookingByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);

    @Query(value = "select s from SafeTemperatureCooking s where s.FoodCategory like %:inf% or s.FoodType like %:inf% or s.InternalTemperatureInformation like %:inf%")
    List<SafeTemperatureCooking> searchSafeTemperatureCookingByInformation(@Param("inf") String inf);
}
