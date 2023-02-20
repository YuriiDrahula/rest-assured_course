package com.framework.specs;

import com.framework.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecificationFactory extends TestBase {

    public static synchronized ResponseSpecification getGenericResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder;
        ResponseSpecification responseSpecification;


        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-type", "application/json;charset=UTF-8");
        responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");

        responseSpecification = responseSpecBuilder.build();
        return responseSpecification;
    }

    public static synchronized RequestSpecification logPayloadResponseInfo(){
        RequestSpecBuilder requestSpecBuilder;
        RequestSpecification requestSpecification;
        requestSpecBuilder = new RequestSpecBuilder();

        if (prop.getProperty("log").equals("ENABLE")){
            requestSpecBuilder.addFilter(new AllureRestAssured());
        }
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }
}
