package com.example.FoodSafety.DataModels;



import javax.persistence.*;

@Entity
public class ColdFoodStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FoodCategory;

    private String FoodType;

    private String RefrigeratorInformation;

    private String FreezerInformation;

    public ColdFoodStorage(String foodCategory, String foodType, String refrigeratorInformation, String freezerInformation) {
        FoodCategory = foodCategory;
        FoodType = foodType;
        RefrigeratorInformation = refrigeratorInformation;
        FreezerInformation = freezerInformation;
    }

    public ColdFoodStorage() {

    }

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
}
