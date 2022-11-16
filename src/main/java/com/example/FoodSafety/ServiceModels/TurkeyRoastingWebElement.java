package com.example.FoodSafety.ServiceModels;

public class TurkeyRoastingWebElement extends FoodSafetyWebElement {
    private String FoodCategory;
    private String RoastingInformation;
    private String TurkeySizeInformation;
    private String TurkeyUnstuffedInformation;
    private String TurkeyStuffedInformation;

    public String getFoodCategory() {
        return FoodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        FoodCategory = foodCategory;
    }

    public String getTurkeySizeInformation() {
        return TurkeySizeInformation;
    }

    public void setTurkeySizeInformation(String turkeySizeInformation) {
        TurkeySizeInformation = turkeySizeInformation;
    }

    public String getTurkeyUnstuffedInformation() {
        return TurkeyUnstuffedInformation;
    }

    public void setTurkeyUnstuffedInformation(String turkeyUnstuffedInformation) {
        TurkeyUnstuffedInformation = turkeyUnstuffedInformation;
    }

    public String getTurkeyStuffedInformation() {
        return TurkeyStuffedInformation;
    }

    public void setTurkeyStuffedInformation(String turkeyStuffedInformation) {
        TurkeyStuffedInformation = turkeyStuffedInformation;
    }

    public String getRoastingInformation() {
        return RoastingInformation;
    }

    public void setRoastingInformation(String roastingInformation) {
        RoastingInformation = roastingInformation;
    }

    public TurkeyRoastingWebElement(String foodCategory, String roastingInformation, String turkeySizeInformation,
        String turkeyUnstuffedInformation, String turkeyStuffedInformation) {
        FoodCategory = foodCategory;
        RoastingInformation = roastingInformation;
        TurkeySizeInformation = turkeySizeInformation;
        TurkeyUnstuffedInformation = turkeyUnstuffedInformation;
        TurkeyStuffedInformation = turkeyStuffedInformation;
        Type = FoodSafetyType.TurkeyRoasting;
    }
}
