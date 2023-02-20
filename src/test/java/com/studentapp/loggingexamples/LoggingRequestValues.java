package com.studentapp.loggingexamples;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import com.testbase.TestBaseStudentApp;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LoggingRequestValues extends TestBaseStudentApp {

    //This test will print out all the Request Headers
    @Test
    public void printRequestHeaders(){
        rs.given()
                .log().headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    //This test will print out all the Request Parameters
    @Test
    public void printRequestParameters(){
        rs.given()
                .param("programme", "Computer Science")
                .log().parameters()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    //This test will print out all the Request Body
    @Test
    public void printRequestBody(){
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
                .log().body()
                .contentType(ContentType.JSON)
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

    //This test will print out all the Request Details
    @Test
    public void printRequestDetails(){
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
                .log().all()
                .contentType(ContentType.JSON)
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

    //This will print out all the Request Details when the test fails
    @Test
    public void printRequestDetailsFailure(){
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
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .body(student)
                .post()
                .then()
                .statusCode(203);
    }
}
