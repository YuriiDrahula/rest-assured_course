package com.studentapp.downloadingfiles;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;

public class UploadFileExample {

    RestAssured rs = new RestAssured();
    //Upload a .gif file and convert it to .jpg format
    @Test
    public void uploadFileExample(){
        String apiKey = "e14442a71d9e31f3fa99ed14785378f454bc88d3";
        String endpoint = "https://sandbox.zamzar.com/v1/jobs";

        File inputFile = new File("src/test/java/com/studentapp/downloadingfiles/testgif.gif");
        System.out.println(inputFile.length());
        rs.given()
                .auth()
                .basic(apiKey, "")
                .multiPart("source_file", inputFile)
                .multiPart("target_format", "jpg")
                .when()
                .post(endpoint)
                .then()
                .log().all();
    }
}
