package com.example.FoodSafety.DataModels;


import javax.persistence.*;

@Entity
public class SafeTemperatureCooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory;

    private String FoodType;

    private String InternalTemperatureInformation;

    public SafeTemperatureCooking(String foodCategory, String foodType, String internalTemperatureInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        InternalTemperatureInformation = internalTemperatureInformation;
    }

    public SafeTemperatureCooking() {

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

    public String getInternalTemperatureInformation() {
        return InternalTemperatureInformation;
    }

    public void setInternalTemperatureInformation(String internalTemperatureInformation) {
        InternalTemperatureInformation = internalTemperatureInformation;
    }
}
