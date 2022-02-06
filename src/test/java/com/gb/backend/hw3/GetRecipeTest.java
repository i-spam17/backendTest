package com.gb.backend.hw3;

import com.gb.backend.Helpers;
import io.restassured.http.ContentType;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class GetRecipeTest extends BaseTest {
    @Test
    void searchRecipesPositiveTest() throws IOException {
        responseRecipeInfo
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(PARAM_NUMBER_KEY, is(PARAM_NUMBER_VALUE));

        String actual = responseRecipeInfo.body().asPrettyString();
        String expected = Helpers.getResourceAsString(POSITIVE_JSON);
        JsonAssert.assertJsonEquals(actual, expected, JsonAssert.when(Option.IGNORING_ARRAY_ORDER));
    }

    @Test
    void checkRecipeInfo() {
        given()
                .param("id", recipeID)
                .when()
                .get("/recipes/" + recipeID + "/information")
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(recipeID))
                .extract()
                .body()
                .asPrettyString();
    }

    @Test
    void searchRecipeSubstitutionDataTypeTest() {
        given()
                .param(PARAM_QUERY_KEY, PARAM_QUERY_VALUE)
                .param(PARAM_NUMBER_KEY, PARAM_NUMBER_NEGATIVE_VALUE)
                .when()
                .get("/recipes/complexSearch")
                .prettyPeek()
                .then()
                .statusCode(404)
                .contentType(ContentType.HTML);
    }

    @Test
    void searchRecipeNegativeTest() throws IOException {
        String actual = given()
                .param(PARAM_QUERY_KEY, PARAM_QUERY_NEGATIVE_VALUE)
                .when()
                .get("/recipes/complexSearch")
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", is(0))
                .extract().response()
                .asPrettyString();

        String expected = Helpers.getResourceAsString(NEGATIVE_JSON);
        JsonAssert.assertJsonEquals(actual, expected, JsonAssert.when(Option.IGNORING_ARRAY_ORDER));
    }

}
