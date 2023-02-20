package com.studentapp.lessons;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Lesson07RequestSpecificationExample {

    static RequestSpecBuilder builder;
    static RequestSpecification requestSpec;
    RestAssured rs = new RestAssured();


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

        rs.given()
                .spec(requestSpec)
                .when()
                .get("/list")
                .then()
                .log().all();


    }
}
