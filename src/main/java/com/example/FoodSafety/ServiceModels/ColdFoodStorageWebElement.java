package com.example.FoodSafety.ServiceModels;

public class ColdFoodStorageWebElement extends FoodSafetyWebElement {
    private String FoodCategoryName;
    private String FoodTypes;
    private String RefrigeratorInformation;
    private String FreezerInformation;

    public String getFoodCategoryName() {
        return FoodCategoryName;
    }
    public void setFoodCategoryName(String foodCategoryName) {
        FoodCategoryName = foodCategoryName;
    }
    public String getFoodTypes() {
        return FoodTypes;
    }
    public void setFoodTypes(String foodTypes) {
        FoodTypes = foodTypes;
    }
    public String getRefrigeratorInformation() {
        return RefrigeratorInformation;
    }
    public void setRefrigeratorInformation(String refrigeratorInformation) {
        RefrigeratorInformation = refrigeratorInformation;
    }
    public String getFreezerInformation() {
        return FreezerInformation;
    }
    public void setFreezerInformation(String freezerInformation) {
        FreezerInformation = freezerInformation;
    }

    public ColdFoodStorageWebElement(String foodCategoryName, String foodTypes, String refrigeratorInformation,
            String freezerInformation) {
        FoodCategoryName = foodCategoryName;
        FoodTypes = foodTypes;
        RefrigeratorInformation = refrigeratorInformation;
        FreezerInformation = freezerInformation;
        Type = FoodSafetyType.ColdFoodStorage;
    }
}