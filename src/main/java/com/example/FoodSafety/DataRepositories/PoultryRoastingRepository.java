package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.PoultryRoasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoultryRoastingRepository extends JpaRepository<PoultryRoasting, Long> {

    @Query(value = "select p from PoultryRoasting p where p.FoodCategory like %:category% and p.FoodType like %:type%")
    List<PoultryRoasting> searchPoultryRoastingByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);

    @Query(value = "select p from PoultryRoasting p where p.FoodCategory like %:inf% or p.FoodType like %:inf% or p.OvenTemperatureInFInformation like %:inf% or p.TimingInformation like %:inf%")
    List<PoultryRoasting> searchPoultryRoastingByInformation(@Param("inf") String inf);
}
