package com.testbase;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseStudentApp {

    public static RestAssured rs = new RestAssured();

    @BeforeAll
    public static void init(){
        rs.baseURI = "http://localhost";
        rs.port = 8085;
        rs.basePath = "/student";
    }
}
