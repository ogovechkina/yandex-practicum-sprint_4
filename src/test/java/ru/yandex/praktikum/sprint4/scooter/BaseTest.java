package ru.yandex.praktikum.sprint4.scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
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
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
