package com.example.FoodSafety;

import java.util.List;

import com.example.FoodSafety.DataModels.ColdFoodStorage;
import com.example.FoodSafety.DataServices.ColdFoodStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.FoodSafety.ServiceModels.ColdFoodStorageWebElement;
import com.example.FoodSafety.ServiceModels.FoodSafetyPowerOutageWebElement;
import com.example.FoodSafety.ServiceModels.FoodSafetyType;
import com.example.FoodSafety.ServiceModels.FoodSafetyWebElement;
import com.example.FoodSafety.ServiceModels.HamCookingWebElement;
import com.example.FoodSafety.ServiceModels.MeatRoastingWebElement;
import com.example.FoodSafety.ServiceModels.PoultryRoastingWebElement;
import com.example.FoodSafety.ServiceModels.SafeTemperatureCookingWebElement;
import com.example.FoodSafety.ServiceModels.TurkeyRoastingWebElement;
import com.example.FoodSafety.ServiceModels.TurkeyThawingWebElement;
import com.example.FoodSafety.Services.WebReaderService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoodSafetyApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FoodSafetyApplication.class, args);

		ColdFoodStorageService coldFoodStorageService = applicationContext.getBean(ColdFoodStorageService.class);

		WebReaderService wrs = new WebReaderService();
		List<FoodSafetyWebElement> parsedColdFoodStorage = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/cold-food-storage-charts"),
		FoodSafetyType.ColdFoodStorage),
		FoodSafetyType.ColdFoodStorage);

		List<FoodSafetyWebElement> parsedFoodSafetyPowerOutage = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/food-safety-during-power-outage"),
		FoodSafetyType.FoodSafetyPowerOutage),
		FoodSafetyType.FoodSafetyPowerOutage);

		List<FoodSafetyWebElement> parsedMeatRoasting = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/meat-poultry-charts"),
		FoodSafetyType.MeatRoasting),
		FoodSafetyType.MeatRoasting);

		List<FoodSafetyWebElement> parsedHamCooking = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/meat-poultry-charts"),
		FoodSafetyType.HamCooking),
		FoodSafetyType.HamCooking);

		List<FoodSafetyWebElement> parsedPoultryRoasting = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/meat-poultry-charts"),
		FoodSafetyType.PoultryRoasting),
		FoodSafetyType.PoultryRoasting);

		List<FoodSafetyWebElement> parsedSafeTemperatureCooking = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/safe-minimum-internal-temperatures"),
		FoodSafetyType.SafeTemperatureCooking),
		FoodSafetyType.SafeTemperatureCooking);

		List<FoodSafetyWebElement> parsedTurkeyRoasting = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/meat-poultry-charts"),
		FoodSafetyType.TurkeyRoasting),
		FoodSafetyType.TurkeyRoasting);

		List<FoodSafetyWebElement> parsedTurkeyThawing = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/meat-poultry-charts"),
		FoodSafetyType.TurkeyThawing),
		FoodSafetyType.TurkeyThawing);

		if (parsedColdFoodStorage != null) {
			for(FoodSafetyWebElement coldFoodWebElement : parsedColdFoodStorage) {
				if (coldFoodWebElement.getType() == FoodSafetyType.ColdFoodStorage) {
					coldFoodStorageService.newColdFoodStorage(new ColdFoodStorage(
						((ColdFoodStorageWebElement)coldFoodWebElement).getFoodCategoryName(),
						((ColdFoodStorageWebElement)coldFoodWebElement).getFoodTypes(),
						((ColdFoodStorageWebElement)coldFoodWebElement).getRefrigeratorInformation(),
						((ColdFoodStorageWebElement)coldFoodWebElement).getFreezerInformation())
						);
				}
			}
		}

		//TODO
	}
}
