package ru.practicum.pages.api;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserApi {

    private User user;


    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String CREATE_USER_ENDPOINT = "/api/auth/register";
    public static final String LOGIN_USER_ENDPOINT = "/api/auth/login";
    public static final String DELETE_USER_ENDPOINT = "/api/auth/user";
    public static final String AUTHORIZATION = "Authorization";





    public ValidatableResponse createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + CREATE_USER_ENDPOINT)
                .then();


    }

    public  ValidatableResponse loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + LOGIN_USER_ENDPOINT)
                .then();
    }


    public  String getAccessToken(User user) {
        return loginUser(user)
                .extract()
                .path("accessToken");
    }


    public  ValidatableResponse deleteUser(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION, accessToken)
                .when()
                .delete(BASE_URL + DELETE_USER_ENDPOINT)
                .then();
    }


}