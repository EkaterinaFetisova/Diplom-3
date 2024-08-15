import data.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BeforeAfter {
    @Test
    @DisplayName("Проверка текста кнопки Войти в аккаунт неавторизованным пользователем")
    public void textOnButtonCreateOrderWithoutAuthTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Войти в аккаунт", buttonText);
    }

    @Test
    @DisplayName("Проверка текста кнопки Оформить заказ авторизованным пользователем")
    public void textOnButtonCreateOrderUserWithAuthTest() {
        UserMethods.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.buttonCreateOrderClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Проверка успешной авторизации пользователя через кнопку Войти в аккаунт")
    public void successLoginThroughButtonEnterAccountTest() {
        UserMethods.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.buttonCreateOrderClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Проверка успешной авторизации пользователя через кнопку Личный кабинет")
    public void successLoginThroughButtonProfileTest() {
        UserMethods.createUser(user);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.buttonProfileClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Проверка успешной авторизации пользователя через кнопку Войти в форме регистрации")
    public void successLoginThroughButtonEnterInPageRegistrationTest() {
        UserMethods.createUser(user);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Проверка успешной авторизации пользователя через кнопку в форме восстановления пароля")
    public void successLoginThroughPageButtonEnterInPageForgotPasswordTest() {
        UserMethods.createUser(user);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.openForgotPasswordPage().clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Текст на кнопке неверный", "Оформить заказ", buttonText);
    }
}
