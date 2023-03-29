package ru.yandex.praktikum.sprint4.scooter;

import java.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.sprint4.scooter.page.HomePage;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.whitelistedIps", "");

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--headless",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "ignore-certificate-errors",
                "user-agent=\"User-Agent to bypass check in method ./containers/Order/OrderPage.finish\""
        );

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        // Нажимаем на кнопку принятия куки, чтобы скрыть панель согласия на использование файлов cookie
        // т.к. она мешает выполнять клики по аккордеону "Вопросы о важном"
        driver.get(HomePage.URL);
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    @AfterClass
    public static void tearDownAll() {
        driver.quit();
    }
}
