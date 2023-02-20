package com.studentapp.loggingexamples;

import com.testbase.TestBaseStudentApp;
import org.junit.jupiter.api.Test;

public class LoggingResponseValues extends TestBaseStudentApp {

    //This test will print out all the Response Headers
    @Test
    public void printResponseHeaders(){
        rs.given()
                .param("programme", "Computer Science")
                .when()
                .get("/1")
                .then()
                .log().headers()
                .statusCode(200);
    }

    //This test will print out the Response Status Line
    @Test
    public void printResponseStatusLine(){
        rs.given()
                .param("programme", "Computer Science")
                .when()
                .get("/1")
                .then()
                .log().status()
                .statusCode(200);
    }

    //This test will print out the Response Body
    @Test
    public void printResponseBody(){
        rs.given()
                .param("programme", "Computer Science")
                .when()
                .get("/1")
                .then()
                .log().body()
                .statusCode(200);
    }

    //This test will print out the Response info in case of an error
    @Test
    public void printResponseWhenFailure(){
        rs.given()
                .param("programme", "Computer Science")
                .when()
                .get("/1")
                .then()
                .log().ifValidationFails()
                .statusCode(201);
    }

}
