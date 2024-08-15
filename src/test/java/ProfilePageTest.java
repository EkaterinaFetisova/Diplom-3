import data.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import java.time.Duration;

import static data.URL.HOME_PAGE;
import static data.URL.LOGIN_PAGE;
import static org.junit.Assert.assertEquals;

public class ProfilePageTest extends BeforeAfter {

    @Test
    @DisplayName("Проверка отображения главной страницы при нажатии на логотип")
    public void clickLogoTest() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogo();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(HOME_PAGE));
        assertEquals(HOME_PAGE,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка отображения главной страницы при нажатии на Конструктор")
    public void clickConstructorButtonTest() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(HOME_PAGE));
        assertEquals(HOME_PAGE,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void clickExitButtonTest() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExitButton();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        assertEquals(LOGIN_PAGE,driver.getCurrentUrl());

    }
}
