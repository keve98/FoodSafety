package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.TurkeyRoasting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurkeyRoastingRepository extends JpaRepository<TurkeyRoasting, Long> {
}
