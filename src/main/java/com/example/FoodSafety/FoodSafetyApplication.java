package com.example.FoodSafety;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.FoodSafety.ServiceModels.ColdFoodStorageWebElement;
import com.example.FoodSafety.Services.WebReaderService;

@SpringBootApplication
public class FoodSafetyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodSafetyApplication.class, args);

		WebReaderService wrs = new WebReaderService();
		List<ColdFoodStorageWebElement> parsed = wrs.CreateListFromTable(wrs.GetTableElementFromPageDocument(wrs.ReadFoodSafetyWebpage(null)));
		if (parsed != null) {
			//TODO
		}
	}
}
