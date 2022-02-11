package com.gb.backend.hw4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public abstract class BaseTest {
    final static String VALUE_API_KEY = "1af43837fe624816b70292f78e556a0c";
    final static String KEY_API_KEY = "apiKey";
    final static String hash = "d0264aa93256d825bf3528b1ba88db4b392b8e39";
    final static String userName = "12301234";

    ResponseSpecification getResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();

    RequestSpecification getRequestSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .addQueryParam("hash", hash)
            .build();

//for UI
//    String spoonacularPassword = "cheesybroccolipotatoeson1pearnectar";


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
    }
}
