package com.studentapp.lessons;

import com.testbase.TestBaseStudentApp;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Lesson02PassingParams extends TestBaseStudentApp {

    @DisplayName("QueryParam Example - Get a single CS student from the list")
    @Test
    public void getSingleCSStudent(){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("programme", "Computer Science");
        params.put("limit", "1");

        Response response =
                rs.given()
                        //.queryParam("programme", "Computer Science")
                        //.queryParam("limit", "1")
                        //.queryParams("programme", "Computer Science", "limit", "1")
                        .queryParams(params)
                        .when()
                        .get("/list");
                        response.prettyPrint();

    }

    @DisplayName("PathParam Example - Get a single CS student from the list")
    @Test
    public void getSingleStudent(){

        Response response =
                rs.given()
                        .when()
                        .pathParam("id", 2)
                        .get("/{id}");
        response.prettyPrint();

    }
}
