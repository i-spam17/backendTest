package com.gb.backend.hw4;

import com.gb.backend.dto.request.AddToMealPlanRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class AddMealPlanNegativeTest extends BaseTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {-1, 0, 1, 12345678901L, -12345678901L})
    void givenNullDateWhenPostRequestThenBadRequest(Object obj) {
        AddToMealPlanRequest addToMealPlanRequest = AddToMealPlanRequest.builder().build();
        addToMealPlanRequest.setDate(obj);
        given()
                .spec(requestSpec)
                .body(addToMealPlanRequest)
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

    @ParameterizedTest
    @ValueSource(chars = {'#', '/', '\\'})
    void givenChangeTypeDateWhenPostRequestThenBadRequest(Object obj) {
        AddToMealPlanRequest addToMealPlanRequest = AddToMealPlanRequest.builder().build();
        addToMealPlanRequest.setDate(obj);
        given()
                .spec(requestSpec)
                .body(addToMealPlanRequest)
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

}
