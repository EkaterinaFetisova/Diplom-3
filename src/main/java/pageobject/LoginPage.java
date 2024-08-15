package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.URL.LOGIN_PAGE;

public class LoginPage {
    private static final By LOGIN_ENTER_BUTTON = By.xpath(".//*[text()='Войти']");
    private static final By LOGIN_EMAIL = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By LOGIN_PASSWORD = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу авторизации")
    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE);
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        return this;
    }
    @Step("Заполнить поля e-mail и пароль на странице авторизации")
    public void authorization(String email, String password) {
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        driver.findElement(LOGIN_EMAIL).click();
        driver.findElement(LOGIN_EMAIL).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD).click();
        driver.findElement(LOGIN_PASSWORD).sendKeys(password);
    }
    @Step("Нажать кнопку Войти на странице авторизации")
    public void clickEnterButton() {
        driver.findElement(LOGIN_ENTER_BUTTON).click();
    }



}
