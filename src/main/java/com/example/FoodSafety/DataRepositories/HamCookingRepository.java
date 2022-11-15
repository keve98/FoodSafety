package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.HamCooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamCookingRepository extends JpaRepository<HamCooking, Long> {
}
