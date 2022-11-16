package com.example.FoodSafety.ServiceModels;

public class TurkeyThawingWebElement extends FoodSafetyWebElement {
    private String ThawingInformation;
    private String TurkeySizeInformation;
    private String ThawInRefrigeratorInformation;
    private String ThawInColdWaterInformation;

    public String getThawingInformation() {
        return ThawingInformation;
    }

    public void setThawingInformation(String thawingInformation) {
        ThawingInformation = thawingInformation;
    }

    public String getTurkeySizeInformation() {
        return TurkeySizeInformation;
    }

    public void setTurkeySizeInformation(String turkeySizeInformation) {
        TurkeySizeInformation = turkeySizeInformation;
    }

    public String getThawInRefrigeratorInformation() {
        return ThawInRefrigeratorInformation;
    }

    public void setThawInRefrigeratorInformation(String thawInRefrigeratorInformation) {
        ThawInRefrigeratorInformation = thawInRefrigeratorInformation;
    }

    public String getThawInColdWaterInformation() {
        return ThawInColdWaterInformation;
    }

    public void setThawInColdWaterInformation(String thawInColdWaterInformation) {
        ThawInColdWaterInformation = thawInColdWaterInformation;
    }

    public TurkeyThawingWebElement(String thawingInformation, String turkeySizeInformation,
        String thawInRefrigeratorInformation, String thawInColdWaterInformation) {
        ThawingInformation = thawingInformation;
        TurkeySizeInformation = turkeySizeInformation;
        ThawInRefrigeratorInformation = thawInRefrigeratorInformation;
        ThawInColdWaterInformation = thawInColdWaterInformation;
        Type = FoodSafetyType.TurkeyThawing;
    }
}
