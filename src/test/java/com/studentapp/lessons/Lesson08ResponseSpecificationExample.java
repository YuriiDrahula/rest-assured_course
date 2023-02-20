package com.studentapp.lessons;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class Lesson08ResponseSpecificationExample {
    static RequestSpecBuilder builder;
    static RequestSpecification requestSpec;
    RestAssured rs = new RestAssured();
    static ResponseSpecBuilder responseBuilder;
    static ResponseSpecification responseSpec;



    @DisplayName("Build the test using Request Specification")
    @Test
    public void testExample(){

        builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost");
        builder.setPort(8085);
        builder.setBasePath("/student");
        builder.addQueryParam("programme", "Computer Science");
        builder.addQueryParam("limit", "1");

        requestSpec = builder.build();

        responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
        responseBuilder.expectStatusCode(200);
        responseBuilder.expectBody("id", equalTo("3"));
        responseSpec = responseBuilder.build();

        rs.given()
                .spec(requestSpec)
                .when()
                .get("/list")
                .then()
                .spec(responseSpec)
                .log().all();


    }
}
