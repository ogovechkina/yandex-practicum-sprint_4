package ru.yandex.praktikum.sprint4.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru";

    private final By faqQuestion1 = By.id("accordion__heading-1");
    private final By faqAnswer1 = By.id("accordion__panel-1");
    private final By faqQuestion2 = By.id("accordion__heading-2");
    private final By faqAnswer2 = By.id("accordion__panel-2");
    private final By headerOrderBtn = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private final By roadmapFinishOrderBtn = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private final By orderForm = By.className("Order_Form__17u6u");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    public void clickFaqQuestion1() {
        driver.findElement(faqQuestion1).click();
    }

    public boolean isFaqAnswer1Visible() {
        return driver.findElement(faqAnswer1).isDisplayed();
    }

    public void waitFaqAnswer1Visible() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(driver.findElement(faqAnswer1)));
    }

    public void clickFaqQuestion2() {
        driver.findElement(faqQuestion2).click();
    }

    public boolean isFaqAnswer2Visible() {
        return driver.findElement(faqAnswer2).isDisplayed();
    }

    public void waitFaqAnswer2Visible() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(driver.findElement(faqAnswer2)));
    }

    public void clickHeaderOrderBtn() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(headerOrderBtn));
        driver.findElement(headerOrderBtn).click();
    }

    public void clickRoadmapFinishOrderBtn() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(roadmapFinishOrderBtn));
        driver.findElement(roadmapFinishOrderBtn).click();
    }

    public void waitOrderFormVisibility() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.and(
                ExpectedConditions.urlToBe(OrderPage.URL),
                ExpectedConditions.visibilityOf(driver.findElement(orderForm))
        ));
    }
}
