package com.gb.backend.hw3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public abstract class BaseTest {
    final static String VALUE_API_KEY = "1af43837fe624816b70292f78e556a0c";
    final static String KEY_API_KEY = "apiKey";
    final static String POSITIVE_JSON = "src/test/resources/com/gb/backend/positiveSearchThreeResults.json";
    final static String NEGATIVE_JSON = "src/test/resources/com/gb/backend/negativeSearch.json";
    final static String PARAM_QUERY_KEY = "query";
    final static String PARAM_QUERY_VALUE = "burger";
    final static String PARAM_QUERY_NEGATIVE_VALUE = "aldsfkjhalsdkjfh alsdkfjhasldk";
    final static String PARAM_NUMBER_KEY = "number";
    final static int PARAM_NUMBER_VALUE = 3;
    final static String PARAM_NUMBER_NEGATIVE_VALUE = "negative data";
    static int recipeID;
    static String recipeTitle;
    static Response responseRecipeInfo;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";

        RestAssured.requestSpecification = given()
                .queryParam(KEY_API_KEY, VALUE_API_KEY)
                .log().params();

        RestAssured.responseSpecification = given()
                .expect()
                .time(lessThan(10L), TimeUnit.SECONDS)
                .log().body();

        responseRecipeInfo = given()
                .param(PARAM_QUERY_KEY, PARAM_QUERY_VALUE)
                .param(PARAM_NUMBER_KEY, PARAM_NUMBER_VALUE)
                .when()
                .get("/recipes/complexSearch")
                .prettyPeek()
                .then()
                .body(PARAM_NUMBER_KEY, is(PARAM_NUMBER_VALUE))
                .extract().response();

        recipeID = Integer.parseInt(responseRecipeInfo.jsonPath().getString("results[0].id"));
        recipeTitle = responseRecipeInfo.jsonPath().getString("results[0].title");
    }


}
