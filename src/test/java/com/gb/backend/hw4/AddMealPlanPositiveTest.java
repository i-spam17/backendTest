package com.gb.backend.hw4;

import com.gb.backend.dto.request.AddToMealPlan;
import com.gb.backend.dto.response.Add2MealPlan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
                .spec(getRequestSpec)
                .body(new File(path))
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(getResponseSpec)
                .body("status", is("success"));
    }

    @Test
    void checkAddToMealPlanFaker() {
        AddToMealPlan addToMealPlan = AddToMealPlan.builder().build();
        given()
                .spec(getRequestSpec)
                .body(addToMealPlan)
                .when()
                .post("/mealplanner/" + userName + "/items")
                .prettyPeek()
                .then()
                .spec(getResponseSpec)
                .body("status", is("success"));
    }

    //    @Test
//    void checkMealPlanTemplates() {
//        given()
//                .spec(getRequestSpec)
//                .when()
//                .get("/mealplanner/" + userName + "/templates")
//                .prettyPeek()
//                .then()
//                .spec(getResponseSpec);
//    }

//    @Test
//    void checkGetMealPlanWeek() throws JsonProcessingException {
//      String jsonAsString = given()
//                .spec(getRequestSpec)
//                .when()
//                .get("/mealplanner/" + userName + "/day/2022-03-01")
//                .prettyPeek()
//                .then()
//                .spec(getResponseSpec)
//                .extract().body().asPrettyString();
//
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        AddToMealPlan readValue = mapper.readValue(jsonAsString, AddToMealPlan.class);
//
//        assertThat(readValue.getDate(), equalTo(1646092800));
//    }

    @Test
    void checkGetMealPlanWeek2() {
        given()
                .spec(getRequestSpec)
                .when()
                .get("/mealplanner/" + userName + "/day/2022-03-01")
                .prettyPeek()
                .then()
                .spec(getResponseSpec)
                .extract().body().as(Add2MealPlan.class);
    }

//    @Test
//    void checkClearMealPlanDay() {
//        given()
//                .spec(getRequestSpec)
//                .when()
//                .delete("/mealplanner/" + userName + "/day/2022-03-01")
//                .prettyPeek()
//                .then()
//                .spec(getResponseSpec);
//    }

//    @AfterEach
//    void tearDown() {
//
//    }

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
