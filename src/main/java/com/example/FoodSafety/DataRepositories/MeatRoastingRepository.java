package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.MeatRoasting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRoastingRepository extends JpaRepository<MeatRoasting, Long> {
}
