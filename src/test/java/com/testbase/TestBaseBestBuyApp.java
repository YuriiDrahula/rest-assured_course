package com.testbase;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseBestBuyApp {

    public static RestAssured rs = new RestAssured();
    public String jsonResponse = rs.given().when().get("/products").asString();
    public static ValidatableResponse validatableResponse;

    @BeforeAll
    public static void initialize(){

        rs.baseURI = "http://localhost";
        rs.port = 3030;

        validatableResponse = rs.given().when().get("/stores").then();
    }

    @BeforeEach
    public void printToConsoleBefore(){
        System.out.println("   ");
        System.out.println("-----Starting the test method-----");
        System.out.println("   ");
    }

    @AfterEach
    public void printToConsoleAfter(){
        System.out.println("   ");
        System.out.println("-----Ending the test method-----");
        System.out.println("   ");
    }
}
