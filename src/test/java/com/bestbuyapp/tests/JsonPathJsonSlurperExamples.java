package com.bestbuyapp.tests;

import com.testbase.TestBaseBestBuyApp;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

public class JsonPathJsonSlurperExamples extends TestBaseBestBuyApp {

    @DisplayName("Print the 'total' value from the response")
    @Test
    public void printTotalValue(){
        int totalValue = validatableResponse.extract().path("total");
        System.out.println(totalValue);
    }

    @DisplayName("Print the 'name' from the first data element")
    @Test
    public void getFirstStoreName(){
        String storeName = validatableResponse.extract().path("data[0].name");
        System.out.println(storeName);
    }

    @DisplayName("Print the first 'service name' from the first data element")
    @Test
    public void getFirstServiceNameFromFirstDataElement(){
        String serviceName = validatableResponse.extract().path("data[0].services[0].name");
        System.out.println(serviceName);
    }

    @DisplayName("Get all the info of the store with zip 55901")
    @Test
    public void findStoreWithZip(){
        Map<String, ?> storeInfo = validatableResponse.extract().path("data.find{it.zip=='55901'}");
        System.out.println(storeInfo.toString());
    }

    @DisplayName("Get the 'address' of the store with zip 55901")
    @Test
    public void getStoreAddress(){
        String storeAddress = validatableResponse.extract().path("data.find{it.zip=='55901'}.address");
        System.out.println(storeAddress);
    }

    @DisplayName("Get all information of store with min & max id")
    @Test
    public void getInfoWithMinId(){
        Map<String, ?> storeWithMinId = validatableResponse.extract().path("data.min{it.id}");
        System.out.println(storeWithMinId);

        Map<String, ?> storeWithMaxId = validatableResponse.extract().path("data.max{it.id}");
        System.out.println(storeWithMaxId);
    }

    @DisplayName("Get all the stores info with id less than 10")
    @Test
    public void getStoreInfoWithIdLessThan10(){
        List<Map<String, ?>> storeInfo = validatableResponse.extract().path("data.findAll{it.id<10}");
        storeInfo.stream().forEach(System.out::println);
    }

    @DisplayName("Get all the service names for all stores")
    @Test
    public void getAllServiceNames(){
        List<List<String>> serviceNames = validatableResponse.extract().path("data.services.findAll{it.name}.name");
        serviceNames.stream().forEach(System.out::println);
    }
}
