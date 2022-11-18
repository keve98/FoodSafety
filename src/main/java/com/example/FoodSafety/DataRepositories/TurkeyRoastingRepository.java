package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.TurkeyRoasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurkeyRoastingRepository extends JpaRepository<TurkeyRoasting, Long> {

    @Query(value = "select s from TurkeyRoasting s where s.FoodCategory like %:category%")
    List<TurkeyRoasting> searchTurkeyRoastingByFoodTypeAndFoodCategory(@Param("category") String category);

    @Query(value = "select s from TurkeyRoasting s where s.FoodCategory like %:inf% or s.RoastingInformation like %:inf% or s.TurkeySizeInformation like %:inf% or s.TurkeyUnstuffedInformation like %:inf% or s.TurkeyStuffedInformation like %:inf%")
    List<TurkeyRoasting> searchTurkeyRoastingByInformation(@Param("inf") String inf);
}
