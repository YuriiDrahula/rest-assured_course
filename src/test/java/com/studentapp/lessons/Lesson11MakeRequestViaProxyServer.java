package com.studentapp.lessons;

import io.restassured.specification.ProxySpecification;
import org.junit.jupiter.api.Test;
import com.testbase.TestBaseStudentApp;

public class Lesson11MakeRequestViaProxyServer extends TestBaseStudentApp {

    @Test
    public void proxyExample(){
        ProxySpecification proxySpec = new ProxySpecification("localhost", 5555, "http");

        rs.given()
                .proxy(proxySpec)
                .when()
                .get("/list")
                .then()
                .log().body();
    }
}
