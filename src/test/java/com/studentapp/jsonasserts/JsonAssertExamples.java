package com.studentapp.jsonasserts;

import com.testbase.TestBaseStudentApp;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonAssertExamples extends TestBaseStudentApp {

    @Test
    @DisplayName("Get all students from the txt file")
    public void getAllStudents() throws IOException, JSONException {
        String expectedValue = new String(Files.readString(Paths.get("src/test/java/com/studentapp/jsonasserts/students.txt")));
        String actualValue = rs.given().when().get("/list").asString();

        JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
    }
}
