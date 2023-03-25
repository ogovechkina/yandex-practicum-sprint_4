package ru.yandex.praktikum.sprint4.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {
    protected static final Duration WAIT_TIMEOUT = Duration.ofSeconds(30);

    protected final WebDriver driver;

    private final By acceptCookieBtn = By.id("rcc-confirm-button");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieBtn() {
        try {
            driver.findElement(acceptCookieBtn).click();
        } catch (Exception e) {
            // skip
        }
    }
}
