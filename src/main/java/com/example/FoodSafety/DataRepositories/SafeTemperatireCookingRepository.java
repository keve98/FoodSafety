package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.SafeTemperatureCooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafeTemperatireCookingRepository extends JpaRepository<SafeTemperatureCooking, Long> {
}
