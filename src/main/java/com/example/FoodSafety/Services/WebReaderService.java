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

@Service
public class WebReaderService {
    public String defaultUrl = "https://www.foodsafety.gov/food-safety-charts/cold-food-storage-charts";

    public Document ReadFoodSafetyWebpage(String pageUrl) {
        Document doc = null;
        try {
            if (pageUrl == null) {
                doc = Jsoup.connect(defaultUrl).get();
            }
            else {
                doc = Jsoup.connect(pageUrl).get();
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        return doc;
    }

    public Element GetTableElementFromPageDocument(Document doc) {
        Element table = null;

        if (doc != null) {
            Element outerElement = doc.getElementsByClass("responsive-table-scroll-wrapper").first();
            Element printable = outerElement.getElementsByClass("printable").first();
            table = printable.select("tbody").first();
        }

        return table;
    }

    public List<ColdFoodStorageWebElement> CreateListFromTable(Element table) {
        List<ColdFoodStorageWebElement> tableElements = new ArrayList<ColdFoodStorageWebElement>();

        if (table != null) {
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
        }

        return tableElements;
    }
}
