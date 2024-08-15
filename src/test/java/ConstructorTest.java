import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BeforeAfter {

    @Test
    @DisplayName("Проверка отображения вкладки Булки")
    public void openBunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuSauce();
        mainPage.clickMenuBun();
        assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка отображения вкладки Соусы")
    public void openSauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuSauce();
        assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка отображения вкладки Начинки")
    public void openFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuFillings();
        assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }
}
