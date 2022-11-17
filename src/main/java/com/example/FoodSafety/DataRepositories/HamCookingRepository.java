package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.HamCooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HamCookingRepository extends JpaRepository<HamCooking, Long> {

    @Query(value = "select h from HamCooking h where h.FoodCategory like %:category% and h.FoodType like %:type%")
    List<HamCooking> searchHamCookingByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);

}
