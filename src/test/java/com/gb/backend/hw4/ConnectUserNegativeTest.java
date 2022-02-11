package com.gb.backend.hw4;

import com.gb.backend.UsersConnectData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class ConnectUserNegativeTest extends BaseTest {



    @Test
    void checkSendEmptyField() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectData
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
                .statusCode(400)
                .contentType(ContentType.JSON);
    }

    @Test
    void checkDataTypeSubstitution() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectData
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
                .statusCode(400)
                .contentType(ContentType.JSON);
    }

    @Test
    void checkSendNoneFields() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersConnectData
                        .builder()
                        .build())
                .when()
                .post("/users/connect")
                .prettyPeek()
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON);
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
                .statusCode(400)
                .contentType(ContentType.JSON);
    }



//    @AfterAll
//    static void afterAll() {
//        given()
//                .contentType(ContentType.JSON)
//                .body("")
//                .when()
//                .delete("/mealplanner/" + userName + "/day/" + "" +":date ? hash = ")
//                .prettyPeek()
//                .then()
//                .statusCode(200);
//    }

}
