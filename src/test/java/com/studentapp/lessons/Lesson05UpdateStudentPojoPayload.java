package com.studentapp.lessons;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import com.testbase.TestBaseStudentApp;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lesson05UpdateStudentPojoPayload extends TestBaseStudentApp {

    @DisplayName("Update students info by sending payload as an object with Put request")
    @Test
    public void updateStudentInfoPut(){

        Faker fake = new Faker();
        StudentPojo student = new StudentPojo();
        List<String> courses = new ArrayList<String>();
        courses.add("JavaScript");
        courses.add("TypeScript");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        rs.given()
                .when()
                .contentType(ContentType.JSON)
                .body(student)
                .put("/106")
                .then()
                .statusCode(200);
    }


    @DisplayName("Update students email by sending payload as an object with Patch request")
    @Test
    public void updateStudentInfoPatch(){

        Faker fake = new Faker();
        StudentPojo student = new StudentPojo();
        student.setEmail(fake.internet().emailAddress());

        rs.given()
                .when()
                .contentType(ContentType.JSON)
                .body(student)
                .patch("/106")
                .then()
                .statusCode(200);
    }
}
