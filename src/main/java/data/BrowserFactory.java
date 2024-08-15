package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;

public class BrowserFactory {
    public static WebDriver getDriver() {

        WebDriver driver;
        String browserName = System.getProperty("browser");
        if (browserName==null) { browserName = ""; };

        ChromeOptions options = new ChromeOptions();
        switch (browserName) {
            case "chrome":
            case "":
                options.addArguments("--remote-allow-origins=*", "--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver = new Augmenter().augment(driver);
                break;
            case "yandex":
                driver = new ChromeDriver(options);
                driver = new Augmenter().augment(driver);
                break;
            default:throw new RuntimeException("Некорректное имя браузера:"+browserName);
        }

        return driver;
    }
}