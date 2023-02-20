package com.studentapp.lessons;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lesson01FirstRestAssuredTests {

    private void styles(){

        RestAssured.given()
                    .queryParam("", "")
                    .when()
                    .get()
                    .then();

        RestAssured.given()
                    .expect()
                    .when();
    }

    @DisplayName("Getting all the students from the database")
    @Test
    public void getAllStudents(){

        //Ways showing how to build Rest Assured lessons

        RequestSpecification requestScpec = RestAssured.given();

        Response response = requestScpec.get("http://localhost:8085/student/list");
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);


        RestAssured.given()
                    .when()
                    .get("http://localhost:8085/student/list")
                    .then()
                    .statusCode(200);

        RestAssured.given()
                    .expect()
                    .statusCode(200)
                    .when()
                    .get("http://localhost:8085/student/list");

    }

}
