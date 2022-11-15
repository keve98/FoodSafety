package com.example.FoodSafety.DataModels;

import javax.persistence.*;

@Entity
public class MeatRoasting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory;

    private String FoodType;

    private String OvenTemperatureInFInformation;

    private String TimingInformation;

    public MeatRoasting(String foodCategory, String foodType, String ovenTemperatureInFInformation, String timingInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        OvenTemperatureInFInformation = ovenTemperatureInFInformation;
        TimingInformation = timingInformation;
    }

    public MeatRoasting() {}

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

    public String getOvenTemperatureInFInformation() {
        return OvenTemperatureInFInformation;
    }

    public void setOvenTemperatureInFInformation(String ovenTemperatureInFInformation) {
        OvenTemperatureInFInformation = ovenTemperatureInFInformation;
    }

    public String getTimingInformation() {
        return TimingInformation;
    }

    public void setTimingInformation(String timingInformation) {
        TimingInformation = timingInformation;
    }
}
