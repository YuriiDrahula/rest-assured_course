package com.studentapp.downloadingfiles;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DownloadFileExamples {

    RestAssured rs = new RestAssured();

    //Download file and compare it with the expected file
    //Check the size of the file
    @Test
    public void verifyDownloadedFile(){
        //Read the input file
        File inputFile = new File("src/test/java/com/studentapp/downloadingfiles/geckodriver-v0.32.2-win32.zip");

        //Check the size of the file
        int expectedSize = (int)inputFile.length();
        System.out.println("The size of the file is " + expectedSize + " bytes");

        //Read the downloaded file
        byte[] actualSize = rs.given()
                                .when()
                                .get("https://github.com/mozilla/geckodriver/releases/download/v0.32.2/geckodriver-v0.32.2-win32.zip")
                                .then()
                                .extract().asByteArray();

        System.out.println("The size of the downloaded file is " + actualSize.length + " bytes");

        Assertions.assertEquals(expectedSize, actualSize.length, "The sizes are not equal!");
    }
}
