package com.example.FoodSafety.DataRepositories;

import com.example.FoodSafety.DataModels.MeatRoasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeatRoastingRepository extends JpaRepository<MeatRoasting, Long> {

    @Query(value = "select m from MeatRoasting m where m.FoodCategory like %:category% and m.FoodType like %:type%")
    List<MeatRoasting> searchMeatRoastingByFoodTypeAndFoodCategory(@Param("type") String type, @Param("category") String category);


}
