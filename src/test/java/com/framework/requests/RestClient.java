package com.framework.requests;

import com.framework.TestBase;
import com.framework.specs.SpecificationFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase {

    public Response doGetRequest(String request){
        return RestAssured.given().when().get(request);
    }

    public Response doPostRequest(String uri, Object body){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .spec(SpecificationFactory.logPayloadResponseInfo())
                .when()
                .body(body)
                .post(uri);
    }

    public Response doDeleteRequest(String resource){
        return RestAssured.given().when().delete(resource);
    }

    public Response doPatchRequest(String resource, Object body){
        return RestAssured.given()
                .when()
                .body(body)
                .patch(resource);
    }

    public Response doPutRequest(String resource, Object body){
        return RestAssured.given()
                .when()
                .body(body)
                .put(resource);
    }
}
