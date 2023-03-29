package ru.yandex.praktikum.sprint4.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {
    protected static final Duration WAIT_TIMEOUT = Duration.ofSeconds(30);

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
