package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.FoodSafetyPowerOutage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodSafetyPowerOutageRepository extends JpaRepository<FoodSafetyPowerOutage, Long> {
}
