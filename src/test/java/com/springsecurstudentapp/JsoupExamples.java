package com.springsecurstudentapp;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import org.hamcrest.Matcher.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

public class JsoupExamples {

    public static SessionFilter filter;

    @BeforeAll
    public static void init(){
        filter = new SessionFilter();
        RestAssured.baseURI = "http://localhost:8086/";

        RestAssured.given().auth().form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
                .filter(filter)
                .get();
    }

    @Test
    public  void extractTitle() {
        String response = RestAssured.given().when().get("http://localhost:8086/").asString();

        Document document = Jsoup.parse(response);
        System.out.println("The title of the page is " + document.title());
    }

    @Test
    public  void extractElementByTagName() {
        String response = RestAssured.given().when().get("http://localhost:8086/").asString();

        Document document = Jsoup.parse(response);
        Elements elements = document.getElementsByTag("form");

        System.out.println("The number of form elements is " + elements.size());
        System.out.println(elements);
    }

    @Test
    public  void extractElementById() {
        String response = RestAssured.given().when().get("http://localhost:8086/").asString();

        Document document = Jsoup.parse(response);
        Element element = document.getElementById("command");
        System.out.println("The element contains are " + element);
        System.out.println(element);
    }

    @Test
    public  void extractLinks() {
        String response = RestAssured.given().when().get("http://localhost:8086/").asString();

        Document document = Jsoup.parse(response);
        Elements links = document.select("a[href]");
        System.out.println("The number of links on the page is " + links.size());
        for (Element link : links){
            System.out.println(link);
        }
    }

    @Test
    public  void extractEmailsFromTheTable() {
        String response = RestAssured.given()
                .sessionId(filter.getSessionId())
                .get("/student/list").asString();

        Document document = Jsoup.parse(response);
        Elements emails = document.select("td:nth-child(4)");
        System.out.println("There number of emails in the table is " + emails.size());

        ArrayList<String> actualValues = new ArrayList<String>();

        for (Element email : emails){
            //System.out.println(email.text());
            actualValues.add(email.text());
        }
    }

}
