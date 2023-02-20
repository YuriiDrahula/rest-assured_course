package com.bestbuyapp.tests;

import com.jayway.jsonpath.JsonPath;
import com.testbase.TestBaseBestBuyApp;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPathJaywayExamples extends TestBaseBestBuyApp {

    @DisplayName("Get the root element")
    @Test
    public void getRoot(){
        Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");
        System.out.println(rootElement.toString());
    }

    @DisplayName("Get the total value from the response")
    @Test
    public void getTotalValue(){
        int totalValue = JsonPath.read(jsonResponse, "$.total");
        System.out.println(totalValue);
    }

    @DisplayName("Get all the data elements")
    @Test
    public void getAllDataElements(){
        List<HashMap<String, Object>> dataElements = JsonPath.read(jsonResponse, "$.data");
        dataElements.stream().forEach(System.out::println);
    }

    @DisplayName("Get the first data element")
    @Test
    public void getFirstDataElement(){
        Map<String, ?> firstDataElement  = JsonPath.read(jsonResponse, "$.data[0]");
        System.out.println(firstDataElement);
    }

    @DisplayName("Get the last data element")
    @Test
    public void getLastDataElement(){
        Map<String, ?> lastDataElement = JsonPath.read(jsonResponse, "$.data[-1]");
        System.out.println(lastDataElement);
    }

    @DisplayName("Get all the ids in data")
    @Test
    public void getAllIdsInData(){
        List<Integer> idsFromData = JsonPath.read(jsonResponse, "$.data[*].id");
        System.out.println(idsFromData); //Prints ids in one list
        idsFromData.stream().forEach(System.out::println); //Prints each id on different line
    }

    @DisplayName("Get all the ids from Json")
    @Test
    public void getAllIdsJson(){
        List<?> idFromJson = JsonPath.read(jsonResponse, "$..id");
        System.out.println(idFromJson);
        idFromJson.stream().forEach(System.out::println);
    }

    @DisplayName("Get the names of the products which price is less than 5$")
    @Test
    public void getProducts(){
        List<String> nameOfProduct = JsonPath.read(jsonResponse, "$.data[?(@.price<5)].name");
        System.out.println(nameOfProduct);

    }
}
