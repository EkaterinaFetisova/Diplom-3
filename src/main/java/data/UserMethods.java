package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static data.URL.*;
public class UserMethods {
    @Step("Авторизация пользователя")
    public static Response loginUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(LOGIN_PATH);
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        spec()
                .header("Authorization",accessToken)
                .when()
                .delete(USER_PATH);
    }
    @Step("Создание нового пользователя")
    public static Response createUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_REGISTER_PATH);
    }
}