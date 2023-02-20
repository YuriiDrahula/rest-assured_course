package com.studentapp.lessons;

import com.testbase.TestBaseStudentApp;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

public class Lesson10CheckResponseTime extends TestBaseStudentApp {

    public static StringWriter requestWriter;
    public static PrintStream requestCapture;
    public static StringWriter responseWriter;
    public static PrintStream responseCapture;

    public static StringWriter errorWriter;
    public static PrintStream errorCapture;

    @Test
    @DisplayName("Display logs using filters")
    public void displayLogsUsingFilters() {

        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);

        responseWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);

        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);

        long responseTime = rs.given()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                .when()
                .get("/list")
                .timeIn(TimeUnit.SECONDS);

        System.out.println(responseTime);
    }
}