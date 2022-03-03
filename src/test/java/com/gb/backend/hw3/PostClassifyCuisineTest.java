package com.gb.backend.hw3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
//todo где правильней разместить константы типа API_KEY ???
import static com.gb.backend.hw3.BaseTest.KEY_API_KEY;
import static com.gb.backend.hw3.BaseTest.VALUE_API_KEY;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public class PostClassifyCuisineTest {
    static final String CUISINE_KEY = "cuisine";
    static final String CUISINE_VALUE = "American";
    static String cuisineTitle;
    static Response getCuisineInfoResponse;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";

        RestAssured.requestSpecification = given()
                .queryParam(KEY_API_KEY, VALUE_API_KEY)
                .log().all();

        RestAssured.responseSpecification = given()
                .expect()
                .time(lessThan(10L), TimeUnit.SECONDS)
                .log().body();

        getCuisineInfoResponse = given()
                .param(CUISINE_KEY, CUISINE_VALUE)
                .when()
                .get("/recipes/complexSearch")
                .prettyPeek()
                .then()
                .extract().response();

        cuisineTitle = getCuisineInfoResponse.jsonPath().getString("results[0].title");
    }

    @Test
    void checkCuisineTitle() {
        getCuisineInfoResponse
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].title", is("Homemade Garlic and Basil French Fries"));
    }

    @Test
    void checkClassifyCuisine() {
        given()
                .header("Content-Type","application/x-www-form-urlencoded")
                .param("title", cuisineTitle)
                .when()
                .post("/recipes/cuisine")
                .prettyPeek()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("cuisine", is(CUISINE_VALUE));
    }
}
