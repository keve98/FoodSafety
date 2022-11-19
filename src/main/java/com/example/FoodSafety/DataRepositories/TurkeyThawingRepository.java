package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.TurkeyThawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurkeyThawingRepository extends JpaRepository<TurkeyThawing, Long> {

    @Query(value = "select s from TurkeyThawing s where s.FoodCategory like %:category%")
    List<TurkeyThawing> searchTurkeyThawingByFoodCategory(@Param("category") String category);

    @Query(value = "select s from TurkeyThawing s where s.FoodCategory like %:inf% or s.ThawingInformation like %:inf% or s.TurkeySizeInformation like %:inf% or s.ThawInRefrigeratorInformation like %:inf% or s.ThawInColdWaterInformation like %:inf%")
    List<TurkeyThawing> searchTurkeyThawingByInformation(@Param("inf") String inf);
}
