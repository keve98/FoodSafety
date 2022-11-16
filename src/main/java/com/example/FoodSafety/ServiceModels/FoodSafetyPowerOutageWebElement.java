package com.example.FoodSafety.ServiceModels;

public class FoodSafetyPowerOutageWebElement extends FoodSafetyWebElement {
    private String FoodCategory;
    private String FoodType;
    private String HeldAboveFourtyOverTwoHoursInformation;

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

    public FoodSafetyPowerOutageWebElement(String foodCategory, String foodType, String heldAboveFourtyOverTwoHoursInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        HeldAboveFourtyOverTwoHoursInformation = heldAboveFourtyOverTwoHoursInformation;
        Type = FoodSafetyType.FoodSafetyPowerOutage;
    }
}
