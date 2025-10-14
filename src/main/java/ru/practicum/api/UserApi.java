package ru.practicum.api;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static ru.practicum.api.ApiConstants.*;


import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static ru.practicum.util.EnvConfig.BASE_URL;


public class UserApi {

    private User user;

    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + CREATE_USER_ENDPOINT)
                .then();


    }

    @Step("Авторизация пользователя")
    public ValidatableResponse loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + LOGIN_USER_ENDPOINT)
                .then();
    }

    @Step("Получения токена")
    public String getAccessToken(User user) {
        return loginUser(user)
                .extract()
                .path("accessToken");
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION, accessToken)
                .when()
                .delete(BASE_URL + DELETE_USER_ENDPOINT)
                .then();
    }


    @Step("Проверка авторизации пользователя")
    public void loginUserAndCheckStatus(User user) {
        loginUser(user)
                .statusCode(SC_OK)
                .body("success", equalTo(true));
    }


}