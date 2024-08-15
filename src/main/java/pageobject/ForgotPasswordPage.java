package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.URL.FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final By LOGIN_ENTER_BUTTON = By.xpath(".//*[text()='Войти']");
    @Step("Открыть страницу Восстановление пароля")
    public ForgotPasswordPage openForgotPasswordPage() {
        driver.get(FORGOT_PASSWORD_PAGE);
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(FORGOT_PASSWORD_PAGE));
        return this;
    }
    @Step("Нажать кнопку Войти на странице Восстановления пароля")
    public void clickEnterButton() {
        driver.findElement(LOGIN_ENTER_BUTTON).click();
    }
}
