package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.ColdFoodStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColdFoodStorageRepository extends JpaRepository<ColdFoodStorage, Long> {
}
