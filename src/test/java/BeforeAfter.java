import data.BrowserFactory;
import data.User;
import data.UserMethods;
import data.UserRandomizer;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BeforeAfter {
    User user;
    String accessToken;

    WebDriver driver;
    @Before
    @Step("Запустить браузер и подготовить данные для регистрации")
    public void setUp() {
        driver = BrowserFactory.getDriver();
        user = UserRandomizer.getNewRandomUser();
    }
    @After
    @Step("Удалить данные и закрыть браузер")
    public void tearDown() {
        Response responseLoginUser = UserMethods.loginUser(user);
        try {
            accessToken = responseLoginUser.then().log().all().extract().path("accessToken").toString();
        }
        catch (Exception e) {
            accessToken = null;
        }
        if (accessToken != null) {
            UserMethods.deleteUser(accessToken);
        }
        driver.quit();
    }
}
