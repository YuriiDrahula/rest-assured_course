package com.studentapp.lessons;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import com.testbase.TestBaseStudentApp;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lesson04CreateStudentPojoPayload extends TestBaseStudentApp {

    @DisplayName("Create a new student by sending payload as an object")
    @Test
    public void createNewStudent(){

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
                .post()
                .then()
                .statusCode(201);
    }
}
