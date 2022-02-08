package com.gb.backend.hw4;

import com.gb.backend.UsersConnectData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public abstract class BaseTest {
    final static String VALUE_API_KEY = "1af43837fe624816b70292f78e556a0c";
    final static String KEY_API_KEY = "apiKey";
    static String hash;
    static String spoonacularPassword;
    static Response getUserData;
    static String userName;

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

        getUserData = given()
                .contentType(ContentType.JSON)
                .body(UsersConnectData
                        .builder()
                        .username("123")
                        .firstName("test_name2")
                        .lastName("test_name3")
                        .email("test@testMail.mail")
                        .build())
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().response();

        spoonacularPassword = getUserData.jsonPath().getString("spoonacularPassword");
        hash = getUserData.jsonPath().getString("hash");
        userName = getUserData.jsonPath().getString("username");
    }

}
