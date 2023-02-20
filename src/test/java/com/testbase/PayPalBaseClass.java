package com.testbase;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class PayPalBaseClass {

    public static RestAssured rs = new RestAssured();
    private static final String userName = "AWz1ZrqKoiduvZfCJE3VEIgLQvTIoUx_a7wlt9wit8FIpkUA0WIhDlYdQfYhuGXZTz7Q8zos56kcLDDT";
    private static final String password = "EE3u_YlE9_8QZmX7FPEcIzv7PpJoAaRPjNC_f4gnrWo79bE5aqavApMKf6hfJOPAGIbi_jUFeIINE5fo";
    private static final String getTokenPath = "/oauth2/token";
    public static String accessToken;

    @BeforeAll
    public static void getToken(){

        rs.baseURI = "https://api-m.sandbox.paypal.com";
        rs.basePath = "/v1";

         accessToken = rs.given()
                .param("grant_type", "client_credentials")
                .auth().preemptive().basic(userName, password)
                .when()
                .post(getTokenPath)
                .then()
                .extract().path("access_token");

        System.out.println(accessToken);
    }
}
