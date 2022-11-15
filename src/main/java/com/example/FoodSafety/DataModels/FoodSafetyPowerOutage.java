package com.example.FoodSafety.DataModels;

import javax.persistence.*;

@Entity
public class FoodSafetyPowerOutage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory;

    private String FoodType;

    private String HeldAboveFourtyOverTwoHoursInformation;

    public FoodSafetyPowerOutage(){}

    public FoodSafetyPowerOutage(String foodCategory, String foodType, String heldAboveFourtyOverTwoHoursInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        HeldAboveFourtyOverTwoHoursInformation = heldAboveFourtyOverTwoHoursInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodCategory() {
        return FoodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        FoodCategory = foodCategory;
    }

    public String getFoodType() {
        return FoodType;
    }

    public void setFoodType(String foodType) {
        FoodType = foodType;
    }

    public String getHeldAboveFourtyOverTwoHoursInformation() {
        return HeldAboveFourtyOverTwoHoursInformation;
    }

    public void setHeldAboveFourtyOverTwoHoursInformation(String heldAboveFourtyOverTwoHoursInformation) {
        HeldAboveFourtyOverTwoHoursInformation = heldAboveFourtyOverTwoHoursInformation;
    }
}
