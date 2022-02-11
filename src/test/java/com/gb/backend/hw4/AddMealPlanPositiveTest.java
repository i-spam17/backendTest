package com.gb.backend.hw4;

import com.gb.backend.dto.request.AddToMealPlanRequest;
import com.gb.backend.dto.response.Add2MealPlanResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AddMealPlanPositiveTest extends BaseTest {
    public static Stream<Arguments> checkAddToMealPlanData() {
        return Stream.of(
                Arguments.of("src/test/resources/com/gb/backend/hw4/typeCustomFood.json"),
                Arguments.of("src/test/resources/com/gb/backend/hw4/typeIngredients.json"),
                Arguments.of("src/test/resources/com/gb/backend/hw4/typeMenuItem.json"),
                Arguments.of("src/test/resources/com/gb/backend/hw4/typeProduct.json"),
                Arguments.of("src/test/resources/com/gb/backend/hw4/typeRecipe.json"));
    }

    @ParameterizedTest
    @MethodSource("checkAddToMealPlanData")
    void checkAddToMealPlan(String path) {
        given()
                .spec(requestSpec)
                .body(new File(path))
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .body("status", is("success"));
    }

    //по сути дубляж предыдущего теста другим способом - учимся!)
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void checkAddToMealPlanFaker(Integer slot) {
        AddToMealPlanRequest addToMealPlanRequest = AddToMealPlanRequest.builder().build();
        addToMealPlanRequest.setSlot(slot);

        given()
                .spec(requestSpec)
                .body(addToMealPlanRequest)
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .body("status", is("success"));
    }

    @Test
    void checkGetMealPlanWeek2() {
        given()
                .spec(requestSpec)
                .when()
                .get("/mealplanner/" + userName + "/day/2022-03-01")
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .extract().body().as(Add2MealPlanResponse.class);
    }

    @AfterAll
    static void afterAll() {
        given()
                .queryParam("hash", hash)
                .when()
                .delete("/mealplanner/" + userName + "/day/2022-03-01")
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
