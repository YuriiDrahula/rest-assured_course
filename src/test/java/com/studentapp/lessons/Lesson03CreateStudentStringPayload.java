package com.studentapp.lessons;

import com.testbase.TestBaseStudentApp;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lesson03CreateStudentStringPayload extends TestBaseStudentApp {

    @DisplayName("Create a new student by sending payload as a String")
    @Test
    public void createNewStudent(){

        String payload = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"johndoe1@mail.com\",\"programme\":\"Computer Science\",\"courses\":[\"C++\",\"Java\"]}";

        rs.given()
                .when()
                .contentType(ContentType.JSON)
                .body(payload)
                .post()
                .then()
                .statusCode(201);
    }
}
