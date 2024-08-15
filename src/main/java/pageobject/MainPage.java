package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.URL.HOME_PAGE;

public class MainPage {
    private static final By PROFILE_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By ORDER_BUTTON = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");
    private static final By MENU_BUN_BUTTON = By.xpath(".//span[text()='Булки']");
    private static final By MENU_FILLINGS_BUTTON = By.xpath(".//span[text()='Начинки']");
    private static final By MENU_SAUCE_BUTTON = By.xpath(".//span[text()='Соусы']");
    private static final By MENU_IN_FOCUS = By.cssSelector("div.tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу Главная")
    public void openMainPage() {
        driver.get(HOME_PAGE);
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(HOME_PAGE));
    }
    @Step("Получить  текст кнопки Оформить заказ")
    public String buttonCreateOrderGetText() {
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON));
        return driver.findElement(ORDER_BUTTON).getText();
    }
    @Step("Нажать кнопку Оформить заказ")
    public void buttonCreateOrderClick() {
        driver.findElement(ORDER_BUTTON).click();
    }
    @Step("Нажать кнопку Личный кабинет")
    public void buttonProfileClick() {
        driver.findElement(PROFILE_BUTTON).click();
    }
    @Step("Перейти на вкладку Булки")
    public void clickMenuBun() {
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(MENU_BUN_BUTTON));
        driver.findElement(MENU_BUN_BUTTON).click();
    }

    @Step("Перейти на закладку Соусы")
    public void clickMenuSauce() {
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(MENU_SAUCE_BUTTON));
        driver.findElement(MENU_SAUCE_BUTTON).click();
    }

    @Step("Перейти на вкладку Начинки")
    public void clickMenuFillings() {
        driver.findElement(MENU_FILLINGS_BUTTON).click();
    }

    @Step("Проверить текст меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(MENU_IN_FOCUS).getText();
    }
}
