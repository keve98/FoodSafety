package com.example.FoodSafety.DataModels;

import javax.persistence.*;

@Entity
public class TurkeyRoasting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory;

    private String RoastingInformation;

    private String TurkeySizeInformation;

    private String TurkeyUnstuffedInformation;

    private String TurkeyStuffedInformation;

    public TurkeyRoasting(String foodCategory, String roastingInformation, String turkeySizeInformation, String turkeyUnstuffedInformation, String turkeyStuffedInformation) {
        FoodCategory = foodCategory;
        RoastingInformation = roastingInformation;
        TurkeySizeInformation = turkeySizeInformation;
        TurkeyUnstuffedInformation = turkeyUnstuffedInformation;
        TurkeyStuffedInformation = turkeyStuffedInformation;
    }

    public TurkeyRoasting() {}

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
}
