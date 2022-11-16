package com.example.FoodSafety.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.FoodSafety.ServiceModels.ColdFoodStorageWebElement;
import com.example.FoodSafety.ServiceModels.FoodSafetyPowerOutageWebElement;
import com.example.FoodSafety.ServiceModels.FoodSafetyType;
import com.example.FoodSafety.ServiceModels.FoodSafetyWebElement;
import com.example.FoodSafety.ServiceModels.HamCookingWebElement;
import com.example.FoodSafety.ServiceModels.MeatRoastingWebElement;

@Service
public class WebReaderService {
    public Document ReadFoodSafetyWebpage(String pageUrl) {
        Document doc = null;
        try {
            doc = Jsoup.connect(pageUrl).get();
        } catch (IOException e) {
                e.printStackTrace();
        }
        return doc;
    }

    public Element GetTableElementFromPageDocument(Document doc, FoodSafetyType type) {
        Element table = null;

        if (doc != null) {
            switch (type) {
                case ColdFoodStorage:
                    Element outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").first();
                    Element printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case FoodSafetyPowerOutage:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").first();
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case HamCooking:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").get(1);
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case MeatRoasting:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").first();
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case PoultryRoasting:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").get(2);
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case SafeTemperatureCooking:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").first();
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case TurkeyRoasting:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").get(3);
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                case TurkeyThawing:
                    outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").get(4);
                    printable = outerElement.getElementsByClass("printable").first();
                    table = printable.select("tbody").first();
                    break;
                default:
                    break;
            }
        }

        return table;
    }

    public List<FoodSafetyWebElement> CreateListFromTable(Element table, FoodSafetyType type) {
        List<FoodSafetyWebElement> tableElements = new ArrayList<FoodSafetyWebElement>();

        try {
            if (table != null) {
                switch (type) {
                    case ColdFoodStorage:
                        for (Element e : table.children()) {
                            if (e.select("th").first() != null) {
                                String foodCategoryName = e.select("th").first().text();
                                Elements attributes = e.select("td");
                                Element[] attr = {};
                                String foodTypes = attributes.toArray(attr)[0].text();
                                String refrigeratorInformation = attributes.toArray(attr)[1].text();
                                String freezerInformation = attributes.toArray(attr)[2].text();
                                ColdFoodStorageWebElement toAdd = new ColdFoodStorageWebElement(
                                    foodCategoryName,
                                    foodTypes,
                                    refrigeratorInformation,
                                    freezerInformation);
                                tableElements.add(toAdd);
                            }
                        }
                        break;
                    case FoodSafetyPowerOutage:
                        String currentfoodCategory = "";
                        for (Element e : table.children()) {
                            if (e.select("th").first() != null) {
                                currentfoodCategory = e.select("th").first().text();
                            }
                            else {
                                Elements attributes = e.select("td");
                                Element[] attr = {};
                                String foodType = attributes.toArray(attr)[0].text();
                                String heldAboveFourtyOverTwoHoursInformation = attributes.toArray(attr)[1].text();
                                FoodSafetyPowerOutageWebElement toAdd = new FoodSafetyPowerOutageWebElement(
                                    currentfoodCategory,
                                    foodType,
                                    heldAboveFourtyOverTwoHoursInformation);
                                tableElements.add(toAdd);
                            }
                        }
                        break;
                    case HamCooking:
                        currentfoodCategory = "";
                        String currentCookingInformation = "";
                        for (Element e : table.children()) {
                            if (e.children().size() == 1 && e.select("th").size() == 1) {
                                Element labels = e.select("th").first();
                                currentfoodCategory = labels.select("strong").first().text();
                                currentCookingInformation = labels.text().replaceFirst(currentfoodCategory, "");
                            }
                            else {
                                Elements attributes = e.select("td");
                                Element[] attr = {};
                                String foodType;
                                String weightInformation;
                                String timingInformation;

                                if (attributes.first().select("ol").first() != null) {
                                    Element list = attributes.first().select("ol").first();

                                    foodType = e.select("th").first().text();
                                    weightInformation = "";
                                    timingInformation = list.text();
                                }
                                else {
                                    foodType = e.select("th").first().text();
                                    weightInformation = attributes.toArray(attr)[0].text();
                                    timingInformation = attributes.toArray(attr)[1].text();
                                }

                                HamCookingWebElement toAdd = new HamCookingWebElement(
                                        currentfoodCategory,
                                        foodType,
                                        currentCookingInformation,
                                        weightInformation,
                                        timingInformation);
                                tableElements.add(toAdd);
                            }
                        }
                        break;
                    case MeatRoasting:
                        currentfoodCategory = "";
                        for (Element e : table.children()) {
                            if (e.children().size() == 1 && e.select("th").size() == 1) {
                                currentfoodCategory = e.select("th").first().text();
                            }
                            else {
                                Elements attributes = e.select("td");
                                Element[] attr = {};
                                String foodType = e.select("th").first().text();
                                String ovenTemperatureInFInformation = attributes.toArray(attr)[0].text();
                                String timingInformation = attributes.toArray(attr)[1].text();
                                MeatRoastingWebElement toAdd = new MeatRoastingWebElement(
                                    currentfoodCategory,
                                    foodType,
                                    ovenTemperatureInFInformation,
                                    timingInformation);
                                tableElements.add(toAdd);
                            }
                        }
                        break;
                    case PoultryRoasting:
    
                        break;
                    case SafeTemperatureCooking:
    
                        break;
                    case TurkeyRoasting:
    
                        break;
                    case TurkeyThawing:
    
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            return tableElements;
        }

        return tableElements;
    }
}
