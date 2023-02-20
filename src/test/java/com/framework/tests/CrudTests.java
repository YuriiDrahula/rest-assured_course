package com.framework.tests;

import com.framework.TestBase;
import com.framework.requests.RequestFactory;
import com.framework.specs.SpecificationFactory;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Story("This is CRUD testing story")
public class CrudTests extends TestBase {

    RequestFactory request = new RequestFactory();


    @Story("This is CRUD testing story")
    @DisplayName("Test to get all students from the database")
    @Feature("Test to get all students from the database")
    @Test
    public void getAllStudents(){
        request.getAllStudents()
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Story("This is CRUD testing story")
    @DisplayName("Test to create and verify a new student")
    @Feature("Test to create and verify a new student")
    @Test
    public void createNewStudent(){

        Faker fake = new Faker();

        String firstname = fake.name().firstName();
        String lastName = fake.name().lastName();
        String email = fake.internet().emailAddress();
        String programme = "Computer Science";
        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");


        request.createNewStudent("", firstname, lastName, email, programme, courses)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(201);
    }


}
