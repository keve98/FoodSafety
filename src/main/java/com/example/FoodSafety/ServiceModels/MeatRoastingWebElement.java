package com.example.FoodSafety.ServiceModels;

public class MeatRoastingWebElement extends FoodSafetyWebElement {
    private String FoodCategory;
    private String FoodType;
    private String OvenTemperatureInFInformation;
    private String TimingInformation;

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

    public MeatRoastingWebElement(String foodCategory, String foodType, String ovenTemperatureInFInformation, String timingInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        OvenTemperatureInFInformation = ovenTemperatureInFInformation;
        TimingInformation = timingInformation;
        Type = FoodSafetyType.MeatRoasting;
    }
}
