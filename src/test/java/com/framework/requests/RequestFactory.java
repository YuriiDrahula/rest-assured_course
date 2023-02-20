package com.framework.requests;

import com.framework.StudentPojo;
import com.framework.TestBase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class RequestFactory extends TestBase {
    RestClient restClient = new RestClient();

    @Step("Getting all the student information from the list")
    public Response getAllStudents(){
        Response response = restClient.doGetRequest("/list");
        return response;
    }

    @Step("Creating a new student: {0}, {1}, {2}, {3}, {4}, {5}")
    public Response createNewStudent(String uri, String firstName, String lastName, String email, String programme, List<String> courses){

        StudentPojo body = new StudentPojo();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(email);
        body.setProgramme(programme);
        body.setCourses(courses);

        return restClient.doPostRequest(uri, body);
    }

    @Step("Updating student info with studentId: {0}, first name: {1}, last name: {2}, email: {3}, programme: {4}, courses: {5}")
    public Response updateStudentInfo(String studentId, String firstName, String lastName, String email, String programme, List<String> courses){
        StudentPojo body = new StudentPojo();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(email);
        body.setProgramme(programme);
        body.setCourses(courses);

        return restClient.doPutRequest("/" + studentId, body);
    }

    @Step("Deleting student from the list")
    public Response deleteStudent(String studentId){
        return restClient.doDeleteRequest("/" + studentId);
    }

    @Step("Get the student by id")
    public Response getStudentById(String studentId){
        return restClient.doGetRequest("/" + studentId);
    }
}
