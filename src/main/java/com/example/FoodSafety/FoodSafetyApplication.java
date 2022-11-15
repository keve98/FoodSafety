package com.example.FoodSafety;

import java.util.List;

import com.example.FoodSafety.DataModels.ColdFoodStorage;
import com.example.FoodSafety.DataServices.ColdFoodStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.FoodSafety.ServiceModels.ColdFoodStorageWebElement;
import com.example.FoodSafety.Services.WebReaderService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoodSafetyApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FoodSafetyApplication.class, args);

		ColdFoodStorageService coldFoodStorageService = applicationContext.getBean(ColdFoodStorageService.class);

		WebReaderService wrs = new WebReaderService();
		List<ColdFoodStorageWebElement> parsed = wrs.CreateListFromTable(wrs.GetTableElementFromPageDocument(wrs.ReadFoodSafetyWebpage(null)));
		if (parsed != null) {
			for(ColdFoodStorageWebElement coldFoodWebElement : parsed){
				coldFoodStorageService.newColdFoodStorage(new ColdFoodStorage(coldFoodWebElement.getFoodCategoryName(), coldFoodWebElement.getFoodTypes(), coldFoodWebElement.getRefrigeratorInformation(), coldFoodWebElement.getFreezerInformation()));
			}
		}
	}
}
