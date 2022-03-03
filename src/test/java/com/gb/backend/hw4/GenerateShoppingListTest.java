package com.gb.backend.hw4;

import com.gb.backend.dto.request.ShoppingListRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GenerateShoppingListTest extends BaseTest {
    //время наше и сервиса - не совпадает, приходится хардкодить поверки....
    @ParameterizedTest
    @CsvSource({"2022-02-01,2022-03-02,1643673600,1646179200", "2022-03-04,2022-03-05,1646352000,1646438400"})
    void positiveGenerateShoppingList(String startDate, String endDate, Integer expectedStartDay, Integer expectedEndDay) {
        ShoppingListRequest shoppingListRequest = ShoppingListRequest.builder().build();
        shoppingListRequest.setStartDate(startDate);
        shoppingListRequest.setEndDate(endDate);
        shoppingListRequest.setUsername(userName);
        shoppingListRequest.setHashData(hash);

        given()
                .spec(requestSpec)
                .body(shoppingListRequest)
                .when()
                .post("/mealplanner/" + userName + "/shopping-list/" + startDate + "/" + endDate)
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .body("startDate", is(expectedStartDay))
                .body("endDate", is(expectedEndDay));
    }

    @ParameterizedTest
    @CsvSource({",", "0,0", "999-10-01,999-10-01", "9999-10-01,9999-10-01", "2022-03-02,2022-03-01"})
    void negativeGenerateShoppingList(String startDate, String endDate) {
        ShoppingListRequest shoppingListRequest = ShoppingListRequest.builder().build();
        shoppingListRequest.setUsername(userName);
        shoppingListRequest.setHashData(hash);
        shoppingListRequest.setStartDate(startDate);

        given()
                .spec(requestSpec)
                .body(shoppingListRequest)
                .when()
                .post("/mealplanner/" + userName + "/shopping-list/" + startDate + "/" + endDate)
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

}
