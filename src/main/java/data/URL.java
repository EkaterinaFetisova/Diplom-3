package data;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class URL {
        public static final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
        public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
        public static final String HOME_PAGE = "https://stellarburgers.nomoreparties.site/";
        public static final String FORGOT_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
        public static final String USER_REGISTER_PATH = "api/auth/register";
        public static final String USER_PATH = "api/auth/user";
        public static final String LOGIN_PATH = "/api/auth/login";

        public static RequestSpecification spec() {
                return given()
                        .contentType(ContentType.JSON)
                        .baseUri(HOME_PAGE)
                        .log()
                        .all();

        }
    }
