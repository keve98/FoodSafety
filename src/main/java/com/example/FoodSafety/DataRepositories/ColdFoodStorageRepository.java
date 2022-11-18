package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.ColdFoodStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColdFoodStorageRepository extends JpaRepository<ColdFoodStorage, Long> {

    @Query(value = "select c from ColdFoodStorage c where c.FoodCategory like %:category% and c.FoodType like %:type%")
    List<ColdFoodStorage> searchColdFoodStorageByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);

    @Query(value = "select c from ColdFoodStorage c where c.FoodCategory like %:inf% or c.FoodType like %:inf% or c.RefrigeratorInformation like %:inf% or c.FreezerInformation like %:inf%")
    List<ColdFoodStorage> searchColdFoodStorageByInformation(@Param("inf") String inf);
}
