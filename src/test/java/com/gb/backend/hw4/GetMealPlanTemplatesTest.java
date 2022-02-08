package com.gb.backend.hw4;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class GetMealPlanTemplatesTest extends BaseTest {
    @Test
    void checkMealPlanTemplates() {
        given()
                .header("Content-Type", ContentType.JSON)
                .contentType(ContentType.JSON)
                .param("hash", hash)
                .when()
                .get("/mealplanner/" + userName + "/templates")
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void checkAddToMealPlan() {
        given()
//                .header("Content-Type", ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("hash", hash)
                .body( new File("src/main/java/com/gb/backend/AddToMealPlanRequestBody.json"))
                .when()
                .post("/mealplanner/" + userName + "/items" )
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

}
