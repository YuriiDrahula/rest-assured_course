package com.framework;

import com.framework.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static PropertyReader prop;

    @BeforeAll
    public static void initUri(){
        prop = PropertyReader.getInstance();

        RestAssured.baseURI = prop.getProperty("baseURI");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));

    }
}
