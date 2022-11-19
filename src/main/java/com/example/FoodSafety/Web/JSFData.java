package com.example.FoodSafety.Web;

import com.example.FoodSafety.DataModels.*;
import com.example.FoodSafety.DataRepositories.*;
import com.example.FoodSafety.DataServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean(name = "com.example.FoodSafety.Web.JSFData", eager = true)
@ViewScoped
public class JSFData implements Serializable {

    private final ColdFoodStorageRepository coldFoodStorageRepository;
    private final FoodSafetyPowerOutageRepository foodSafetyPowerOutageRepository;
    private final HamCookingRepository hamCookingRepository;
    private final MeatRoastingRepository meatRoastingRepository;
    private final PoultryRoastingRepository poultryRoastingRepository;
    private final SafeTemperatureCookingRepository safeTemperatureCookingRepository;
    private final TurkeyRoastingRepository turkeyRoastingRepository;
    private final TurkeyThawingRepository turkeyThawingRepository;
    public ColdFoodStorageService coldFoodStorageService;
    public FoodSafetyPowerOutageService foodSafetyPowerOutageService;
    public HamCookingService hamCookingService;
    public MeatRoastingService meatRoastingService;
    public PoultryRoastingService poultryRoastingService;
    public SafeTemperatureCookingService safeTemperatureCookingService;
    public TurkeyRoastingService turkeyRoastingService;
    public TurkeyThawingService turkeyThawingService;

    public List<ColdFoodStorage> coldFoodStorages = new ArrayList<ColdFoodStorage>();
    public List<FoodSafetyPowerOutage> foodSafetyPowerOutages = new ArrayList<FoodSafetyPowerOutage>();
    public List<HamCooking> hamCookings = new ArrayList<HamCooking>();
    public List<MeatRoasting> meatRoastings = new ArrayList<MeatRoasting>();
    public List<PoultryRoasting> poultryRoastings = new ArrayList<PoultryRoasting>();
    public List<SafeTemperatureCooking> safeTemperatureCookings = new ArrayList<SafeTemperatureCooking>();
    public List<TurkeyRoasting> turkeyRoastings = new ArrayList<TurkeyRoasting>();
    public List<TurkeyThawing> turkeyThawings = new ArrayList<TurkeyThawing>();

    public String foodCategory = "";
    public String foodType = "";
    public String information = "";

    public String coldFoodStorageVisibility = "hidden";
    public String foodSafetyPowerOutageVisibility = "hidden";
    public String hamCookingVisibility = "hidden";
    public String meatRoastingVisibility = "hidden";
    public String poultryRoastingVisibility = "hidden";
    public String safeTemperatureCookingVisibility = "hidden";
    public String turkeyRoastingVisibility = "hidden";
    public String turkeyThawingVisibility = "hidden";

    @Autowired
    public JSFData(ColdFoodStorageRepository coldFoodStorageRepository, FoodSafetyPowerOutageRepository foodSafetyPowerOutageRepository, HamCookingRepository hamCookingRepository, MeatRoastingRepository meatRoastingRepository, PoultryRoastingRepository poultryRoastingRepository, SafeTemperatureCookingRepository safeTemperatureCookingRepository, TurkeyRoastingRepository turkeyRoastingRepository, TurkeyThawingRepository turkeyThawingRepository) {
        this.coldFoodStorageRepository = coldFoodStorageRepository;
        this.foodSafetyPowerOutageRepository = foodSafetyPowerOutageRepository;
        this.hamCookingRepository = hamCookingRepository;
        this.meatRoastingRepository = meatRoastingRepository;
        this.poultryRoastingRepository = poultryRoastingRepository;
        this.safeTemperatureCookingRepository = safeTemperatureCookingRepository;
        this.turkeyRoastingRepository = turkeyRoastingRepository;
        this.turkeyThawingRepository = turkeyThawingRepository;

        this.coldFoodStorageService = new ColdFoodStorageService(this.coldFoodStorageRepository);
        this.foodSafetyPowerOutageService = new FoodSafetyPowerOutageService(this.foodSafetyPowerOutageRepository);
        this.hamCookingService = new HamCookingService(this.hamCookingRepository);
        this.meatRoastingService = new MeatRoastingService(this.meatRoastingRepository);
        this.poultryRoastingService = new PoultryRoastingService(this.poultryRoastingRepository);
        this.safeTemperatureCookingService = new SafeTemperatureCookingService(this.safeTemperatureCookingRepository);
        this.turkeyRoastingService = new TurkeyRoastingService(this.turkeyRoastingRepository);
        this.turkeyThawingService = new TurkeyThawingService(this.turkeyThawingRepository);
    }

    public void getDataByFoodAndCategory(){
        coldFoodStorages.clear();
        foodSafetyPowerOutages.clear();
        hamCookings.clear();
        meatRoastings.clear();
        poultryRoastings.clear();
        safeTemperatureCookings.clear();
        turkeyRoastings.clear();
        turkeyThawings.clear();
        coldFoodStorages = coldFoodStorageService.findByCategoryAndType(this.foodType, this.foodCategory);
        foodSafetyPowerOutages = foodSafetyPowerOutageService.findByCategoryAndType(this.foodType, this.foodCategory);
        hamCookings = hamCookingService.findByCategoryAndType(this.foodType, this.foodCategory);
        meatRoastings = meatRoastingService.findByCategoryAndType(this.foodType, this.foodCategory);
        poultryRoastings = poultryRoastingService.findByCategoryAndType(this.foodType, this.foodCategory);
        safeTemperatureCookings = safeTemperatureCookingService.findByCategoryAndType(this.foodType, this.foodCategory);
        turkeyRoastings = turkeyRoastingService.findByCategoryAndType(this.foodCategory);
        turkeyThawings = turkeyThawingService.findByCategoryAndType(this.foodCategory);
        coldFoodStorageVisibility = coldFoodStorages != null && coldFoodStorages.size() > 0 ? "visisble" : "hidden";
        foodSafetyPowerOutageVisibility = foodSafetyPowerOutages != null && foodSafetyPowerOutages.size() > 0 ? "visisble" : "hidden";
        hamCookingVisibility = hamCookings != null && hamCookings.size() > 0 ? "visisble" : "hidden";
        meatRoastingVisibility = meatRoastings != null && meatRoastings.size() > 0 ? "visisble" : "hidden";
        poultryRoastingVisibility = poultryRoastings != null && poultryRoastings.size() > 0 ? "visisble" : "hidden";
        safeTemperatureCookingVisibility = safeTemperatureCookings != null && safeTemperatureCookings.size() > 0 ? "visisble" : "hidden";
        turkeyRoastingVisibility = turkeyRoastings != null && turkeyRoastings.size() > 0 ? "visisble" : "hidden";
        turkeyThawingVisibility = turkeyThawings != null && turkeyThawings.size() > 0 ? "visisble" : "hidden";
    }

    public void getDataByInformation() {
        coldFoodStorages.clear();
        foodSafetyPowerOutages.clear();
        hamCookings.clear();
        meatRoastings.clear();
        poultryRoastings.clear();
        safeTemperatureCookings.clear();
        turkeyRoastings.clear();
        turkeyThawings.clear();
        coldFoodStorages = coldFoodStorageService.findByInformation(this.information);
        foodSafetyPowerOutages = foodSafetyPowerOutageService.findByInformation(this.information);
        hamCookings = hamCookingService.findByInformation(this.information);
        meatRoastings = meatRoastingService.findByInformation(this.information);
        poultryRoastings = poultryRoastingService.findByInformation(this.information);
        safeTemperatureCookings = safeTemperatureCookingService.findByInformation(this.information);
        turkeyRoastings = turkeyRoastingService.findByInformation(this.information);
        turkeyThawings = turkeyThawingService.findByInformation(this.information);
        coldFoodStorageVisibility = coldFoodStorages != null && coldFoodStorages.size() > 0 ? "visisble" : "hidden";
        foodSafetyPowerOutageVisibility = foodSafetyPowerOutages != null && foodSafetyPowerOutages.size() > 0 ? "visisble" : "hidden";
        hamCookingVisibility = hamCookings != null && hamCookings.size() > 0 ? "visisble" : "hidden";
        meatRoastingVisibility = meatRoastings != null && meatRoastings.size() > 0 ? "visisble" : "hidden";
        poultryRoastingVisibility = poultryRoastings != null && poultryRoastings.size() > 0 ? "visisble" : "hidden";
        safeTemperatureCookingVisibility = safeTemperatureCookings != null && safeTemperatureCookings.size() > 0 ? "visisble" : "hidden";
        turkeyRoastingVisibility = turkeyRoastings != null && turkeyRoastings.size() > 0 ? "visisble" : "hidden";
        turkeyThawingVisibility = turkeyThawings != null && turkeyThawings.size() > 0 ? "visisble" : "hidden";
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodName) {
        this.foodType = foodName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<ColdFoodStorage> getColdFoodStorages() {
        return coldFoodStorages;
    }

    public void setColdFoodStorages(List<ColdFoodStorage> coldFoodStorages) {
        this.coldFoodStorages = coldFoodStorages;
    }

    public List<FoodSafetyPowerOutage> getFoodSafetyPowerOutages() {
        return foodSafetyPowerOutages;
    }

    public void setFoodSafetyPowerOutages(List<FoodSafetyPowerOutage> foodSafetyPowerOutages) {
        this.foodSafetyPowerOutages = foodSafetyPowerOutages;
    }

    public List<HamCooking> getHamCookings() {
        return hamCookings;
    }

    public void setHamCookings(List<HamCooking> hamCookings) {
        this.hamCookings = hamCookings;
    }

    public List<MeatRoasting> getMeatRoastings() {
        return meatRoastings;
    }
    
    public void setMeatRoastings(List<MeatRoasting> meatRoastings) {
        this.meatRoastings = meatRoastings;
    }

    public List<PoultryRoasting> getPoultryRoastings() {
        return poultryRoastings;
    }

    public void setPoultryRoastings(List<PoultryRoasting> poultryRoastings) {
        this.poultryRoastings = poultryRoastings;
    }

    public List<SafeTemperatureCooking> getSafeTemperatureCookings() {
        return safeTemperatureCookings;
    }

    public void setSafeTemperatureCookings(List<SafeTemperatureCooking> safeTemperatureCookings) {
        this.safeTemperatureCookings = safeTemperatureCookings;
    }

    public List<TurkeyRoasting> getTurkeyRoastings() {
        return turkeyRoastings;
    }

    public void setTurkeyRoastings(List<TurkeyRoasting> turkeyRoastings) {
        this.turkeyRoastings = turkeyRoastings;
    }
    
    public List<TurkeyThawing> getTurkeyThawings() {
        return turkeyThawings;
    }

    public void setTurkeyThawings(List<TurkeyThawing> turkeyThawings) {
        this.turkeyThawings = turkeyThawings;
    }

    public String getColdFoodStorageVisibility() {
        return coldFoodStorageVisibility;
    }

    public void setColdFoodStorageVisibility(String coldFoodStorageVisibility) {
        this.coldFoodStorageVisibility = coldFoodStorageVisibility;
    }

    public String getFoodSafetyPowerOutageVisibility() {
        return foodSafetyPowerOutageVisibility;
    }

    public void setFoodSafetyPowerOutageVisibility(String foodSafetyPowerOutageVisibility) {
        this.foodSafetyPowerOutageVisibility = foodSafetyPowerOutageVisibility;
    }

    public String getHamCookingVisibility() {
        return hamCookingVisibility;
    }

    public void setHamCookingVisibility(String hamCookingVisibility) {
        this.hamCookingVisibility = hamCookingVisibility;
    }

    public String getMeatRoastingVisibility() {
        return meatRoastingVisibility;
    }

    public void setMeatRoastingVisibility(String meatRoastingVisibility) {
        this.meatRoastingVisibility = meatRoastingVisibility;
    }

    public String getPoultryRoastingVisibility() {
        return poultryRoastingVisibility;
    }

    public void setPoultryRoastingVisibility(String poultryRoastingVisibility) {
        this.poultryRoastingVisibility = poultryRoastingVisibility;
    }

    public String getSafeTemperatureCookingVisibility() {
        return safeTemperatureCookingVisibility;
    }

    public void setSafeTemperatureCookingVisibility(String safeTemperatureCookingVisibility) {
        this.safeTemperatureCookingVisibility = safeTemperatureCookingVisibility;
    }

    public String getTurkeyRoastingVisibility() {
        return turkeyRoastingVisibility;
    }

    public void setTurkeyRoastingVisibility(String turkeyRoastingVisibility) {
        this.turkeyRoastingVisibility = turkeyRoastingVisibility;
    }

    public String getTurkeyThawingVisibility() {
        return turkeyThawingVisibility;
    }

    public void setTurkeyThawingVisibility(String turkeyThawingVisibility) {
        this.turkeyThawingVisibility = turkeyThawingVisibility;
    }
}
