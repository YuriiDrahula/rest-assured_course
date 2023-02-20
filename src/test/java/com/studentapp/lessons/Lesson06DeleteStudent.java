package com.studentapp.lessons;

import com.testbase.TestBaseStudentApp;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lesson06DeleteStudent extends TestBaseStudentApp {

    @DisplayName("Delete student info by sending Delete request")
    @Test
    public void deleteStudent(){

        rs.given()
                .when()
                .contentType(ContentType.JSON)
                .delete("/106")
                .then()
                .statusCode(204);
    }
}
