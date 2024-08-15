import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.RegistrationPage;

import java.time.Duration;

import static data.URL.LOGIN_PAGE;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BeforeAfter {
    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void successRegistrationWithCorrectFieldsTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user)
                .clickRegistrationButton();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        assertEquals(LOGIN_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка ошибки регистрации при коротком пароле")
    public void failRegistrationWithShortPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        user.setPassword("12345");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user);

        String mistake = registrationPage.passwordMistakeGetText();

        assertEquals("Текст ошибки поля Пароль не соответствует требованиям", "Некорректный пароль", mistake);
    }
}