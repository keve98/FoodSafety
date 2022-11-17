package com.example.FoodSafety.DataModels;

import javax.persistence.*;

@Entity
public class TurkeyThawing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory = "Turkey";

    private String ThawingInformation;

    private String TurkeySizeInformation;

    private String ThawInRefrigeratorInformation;

    private String ThawInColdWaterInformation;

    public TurkeyThawing(String thawingInformation, String turkeySizeInformation, String thawInRefrigeratorInformation, String thawInColdWaterInformation) {
        ThawingInformation = thawingInformation;
        TurkeySizeInformation = turkeySizeInformation;
        ThawInRefrigeratorInformation = thawInRefrigeratorInformation;
        ThawInColdWaterInformation = thawInColdWaterInformation;
    }

    public TurkeyThawing() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setFoodCategory(String foodCategory) {
        FoodCategory = foodCategory;
    }

    public String getFoodCategory() {
        return FoodCategory;
    }
}
