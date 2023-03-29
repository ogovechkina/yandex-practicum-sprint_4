package ru.yandex.praktikum.sprint4.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru";

    private final By faqQuestions = By.xpath("//*[@class='Home_FAQ__3uVm4']//*[@class='accordion__item']//*[@class='accordion__heading']");
    private final By faqAnswers = By.xpath("//*[@class='Home_FAQ__3uVm4']//*[@class='accordion__item']//*[@class='accordion__panel']");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    private WebElement findElementContainsText(By by, String text) {
        return driver.findElement(by)
                .findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    public boolean isFaqAnswerHidden(String answer) {
        return !findElementContainsText(faqAnswers, answer).isDisplayed();
    }

    public boolean isFaqAnswerVisible(String answer) {
        var element = findElementContainsText(faqAnswers, answer);
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void clickFaqQuestion(String question) {
        findElementContainsText(faqQuestions, question).click();
    }
}
