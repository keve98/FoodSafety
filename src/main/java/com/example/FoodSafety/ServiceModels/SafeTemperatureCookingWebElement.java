package com.example.FoodSafety.ServiceModels;

public class SafeTemperatureCookingWebElement extends FoodSafetyWebElement {
    private String FoodCategory;
    private String FoodType;
    private String InternalTemperatureInformation;

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

    public SafeTemperatureCookingWebElement(String foodCategory, String foodType, String internalTemperatureInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        InternalTemperatureInformation = internalTemperatureInformation;
        Type = FoodSafetyType.SafeTemperatureCooking;
    }
}
