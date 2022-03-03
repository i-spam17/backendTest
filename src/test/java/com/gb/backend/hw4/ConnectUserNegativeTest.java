package com.gb.backend.hw4;

import com.gb.backend.dto.request.UsersConnectDataRequest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

//эти тесты делаю без параметризации
public class ConnectUserNegativeTest extends BaseTest {
    @Test
    void checkSendEmptyField() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectDataRequest
                        .builder()
                        .username("")
                        .firstName("test_name2")
                        .lastName("test_name3")
                        .email("test@testMail.mail")
                        .build())
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

    @Test
    void checkDataTypeSubstitution() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectDataRequest
                        .builder()
                        .username("test_name1")
                        .firstName("test_name2")
                        .lastName("test_name3")
                        .email(String.valueOf(123))
                        .build())
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

    @Test
    void checkSendNoneFields() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectDataRequest
                        .builder()
                        .build())
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

    @Test
    void checkSendEmptyBody() {
        given()
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .spec(negativeResponseSpec);
    }

}
