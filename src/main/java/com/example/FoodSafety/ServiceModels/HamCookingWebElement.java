package com.example.FoodSafety.ServiceModels;

public class HamCookingWebElement extends FoodSafetyWebElement {
    private String FoodCategory;
    private String FoodType;
    private String CookingInformation;
    private String WeightInformation;
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

    public String getCookingInformation() {
        return CookingInformation;
    }

    public void setCookingInformation(String cookingInformation) {
        CookingInformation = cookingInformation;
    }

    public String getWeightInformation() {
        return WeightInformation;
    }

    public void setWeightInformation(String weightInformation) {
        WeightInformation = weightInformation;
    }

    public String getTimingInformation() {
        return TimingInformation;
    }

    public void setTimingInformation(String timingInformation) {
        TimingInformation = timingInformation;
    }

    public HamCookingWebElement(String foodCategory, String foodType, String cookingInformation, String weightInformation,
        String timingInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        CookingInformation = cookingInformation;
        WeightInformation = weightInformation;
        TimingInformation = timingInformation;
        Type = FoodSafetyType.HamCooking;
    }
}
