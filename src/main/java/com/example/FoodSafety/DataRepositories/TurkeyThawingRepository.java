package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.TurkeyThawing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurkeyThawingRepository extends JpaRepository<TurkeyThawing, Long> {
}
