package com.example.FoodSafety;

import java.util.List;

import com.example.FoodSafety.DataModels.*;
import com.example.FoodSafety.DataServices.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.FoodSafety.ServiceModels.*;
import com.example.FoodSafety.Services.WebReaderService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoodSafetyApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FoodSafetyApplication.class, args);

		ColdFoodStorageService coldFoodStorageService = applicationContext.getBean(ColdFoodStorageService.class);
		FoodSafetyPowerOutageService foodSafetyPowerOutageService = applicationContext.getBean(FoodSafetyPowerOutageService.class);
		MeatRoastingService meatRoastingService = applicationContext.getBean(MeatRoastingService.class);
		HamCookingService hamCookingService = applicationContext.getBean(HamCookingService.class);
		PoultryRoastingService poultryRoastingService = applicationContext.getBean(PoultryRoastingService.class);
		TurkeyRoastingService turkeyRoastingService = applicationContext.getBean(TurkeyRoastingService.class);
		TurkeyThawingService turkeyThawingService = applicationContext.getBean(TurkeyThawingService.class);
		SafeTemperatureCookingService safeTemperatureCookingService = applicationContext.getBean(SafeTemperatureCookingService.class);

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

		List<FoodSafetyWebElement> parsedSafeTemperatureCooking = wrs
		.CreateListFromTable(wrs
		.GetTableElementFromPageDocument(wrs
		.ReadFoodSafetyWebpage("https://www.foodsafety.gov/food-safety-charts/safe-minimum-internal-temperatures"),
		FoodSafetyType.SafeTemperatureCooking),
		FoodSafetyType.SafeTemperatureCooking);

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

		if (parsedFoodSafetyPowerOutage != null) {
			for(FoodSafetyWebElement foodSafetyPowerOutageWebElement : parsedFoodSafetyPowerOutage) {
				if (foodSafetyPowerOutageWebElement.getType() == FoodSafetyType.FoodSafetyPowerOutage) {
					foodSafetyPowerOutageService.newFoodSafetyPowerOutage(new FoodSafetyPowerOutage(
						((FoodSafetyPowerOutageWebElement)foodSafetyPowerOutageWebElement).getFoodCategory(),
						((FoodSafetyPowerOutageWebElement)foodSafetyPowerOutageWebElement).getFoodType(),
						((FoodSafetyPowerOutageWebElement)foodSafetyPowerOutageWebElement).getHeldAboveFourtyOverTwoHoursInformation())
						);
				}
			}
		}

		if (parsedMeatRoasting != null) {
			for(FoodSafetyWebElement meatRoastingWebElement : parsedMeatRoasting) {
				if (meatRoastingWebElement.getType() == FoodSafetyType.MeatRoasting) {
					meatRoastingService.newMeatRoasting(new MeatRoasting(
						((MeatRoastingWebElement)meatRoastingWebElement).getFoodCategory(),
						((MeatRoastingWebElement)meatRoastingWebElement).getFoodType(),
						((MeatRoastingWebElement)meatRoastingWebElement).getOvenTemperatureInFInformation(),
						((MeatRoastingWebElement)meatRoastingWebElement).getTimingInformation())
						);
				}
			}
		}

		if (parsedHamCooking != null) {
			for(FoodSafetyWebElement hamCookingWebElement : parsedHamCooking) {
				if (hamCookingWebElement.getType() == FoodSafetyType.HamCooking) {
					hamCookingService.newHamCooking(new HamCooking(
						((HamCookingWebElement)hamCookingWebElement).getFoodCategory(),
						((HamCookingWebElement)hamCookingWebElement).getFoodType(),
						((HamCookingWebElement)hamCookingWebElement).getCookingInformation(),
						((HamCookingWebElement)hamCookingWebElement).getWeightInformation(),
						((HamCookingWebElement)hamCookingWebElement).getTimingInformation())
						);
				}
			}
		}

		if (parsedPoultryRoasting != null) {
			for(FoodSafetyWebElement poultryRoastingWebElement : parsedPoultryRoasting) {
				if (poultryRoastingWebElement.getType() == FoodSafetyType.PoultryRoasting) {
					poultryRoastingService.newPoultryRoasting(new PoultryRoasting(
						((PoultryRoastingWebElement)poultryRoastingWebElement).getFoodCategory(),
						((PoultryRoastingWebElement)poultryRoastingWebElement).getFoodType(),
						((PoultryRoastingWebElement)poultryRoastingWebElement).getOvenTemperatureInFInformation(),
						((PoultryRoastingWebElement)poultryRoastingWebElement).getTimingInformation())
						);
				}
			}
		}

		if (parsedTurkeyRoasting != null) {
			for(FoodSafetyWebElement turkeyRoastingWebElement : parsedTurkeyRoasting) {
				if (turkeyRoastingWebElement.getType() == FoodSafetyType.TurkeyRoasting) {
					turkeyRoastingService.newTurkeyRoast(new TurkeyRoasting(
						((TurkeyRoastingWebElement)turkeyRoastingWebElement).getFoodCategory(),
						((TurkeyRoastingWebElement)turkeyRoastingWebElement).getRoastingInformation(),
						((TurkeyRoastingWebElement)turkeyRoastingWebElement).getTurkeySizeInformation(),
						((TurkeyRoastingWebElement)turkeyRoastingWebElement).getTurkeyUnstuffedInformation(),
						((TurkeyRoastingWebElement)turkeyRoastingWebElement).getTurkeyStuffedInformation())
						);
				}
			}
		}

		if (parsedTurkeyThawing != null) {
			for(FoodSafetyWebElement turkeyThawingWebElement : parsedTurkeyThawing) {
				if (turkeyThawingWebElement.getType() == FoodSafetyType.TurkeyThawing) {
					turkeyThawingService.newTurkeyThawe(new TurkeyThawing(
						((TurkeyThawingWebElement)turkeyThawingWebElement).getThawingInformation(),
						((TurkeyThawingWebElement)turkeyThawingWebElement).getTurkeySizeInformation(),
						((TurkeyThawingWebElement)turkeyThawingWebElement).getThawInRefrigeratorInformation(),
						((TurkeyThawingWebElement)turkeyThawingWebElement).getThawInColdWaterInformation())
						);
				}
			}
		}

		if (parsedSafeTemperatureCooking != null) {
			for(FoodSafetyWebElement safeTempWebElement : parsedSafeTemperatureCooking) {
				if (safeTempWebElement.getType() == FoodSafetyType.SafeTemperatureCooking) {
					safeTemperatureCookingService.newSafeTemperatureCook(new SafeTemperatureCooking(
						((SafeTemperatureCookingWebElement)safeTempWebElement).getFoodCategory(),
						((SafeTemperatureCookingWebElement)safeTempWebElement).getFoodType(),
						((SafeTemperatureCookingWebElement)safeTempWebElement).getInternalTemperatureInformation())
						);
				}
			}
		}
	}
}
