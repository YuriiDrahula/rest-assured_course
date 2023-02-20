package com.springsecurstudentapp;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormAuthWithCsrfToken {
    public static SessionFilter filter;

    @BeforeAll
    public static void init(){
        filter = new SessionFilter();
        RestAssured.baseURI = "http://localhost:8087/";

        RestAssured.given().auth().form("user", "user", new FormAuthConfig("/login", "uname", "pwd")
                        .withAutoDetectionOfCsrf())
                .filter(filter)
                .get();
    }

    @Test
    public void getAllStudents(){
        RestAssured.given()
                .sessionId(filter.getSessionId())
                .get("/student/list")
                .then().log().all();
    }
}
