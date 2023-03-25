package ru.yandex.praktikum.sprint4.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.praktikum.sprint4.scooter.model.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage extends BasePage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/order";
    public static final String TRACK_URL = "https://qa-scooter.praktikum-services.ru/track";

    private final By orderFirstNameInput = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH > input[placeholder*='Имя']");
    private final By orderLastNameInput = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH > input[placeholder*='Фамилия']");
    private final By orderAddressInput = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH > input[placeholder*='Адрес']");
    private final By orderPhoneInput = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH > input[placeholder*='Телефон']");
    private final By metroStationInput = By.cssSelector(".Order_Form__17u6u .select-search input.select-search__input");
    private final By metroStationFirstSelectOption = By.cssSelector(".Order_Form__17u6u .select-search ul.select-search__options li.select-search__row:nth-child(1)");
    private final By orderNextBtn = By.cssSelector(".Order_Content__bmtHS > .Order_NextButton__1_rCA > button");
    private final By orderDeliveryDateInput = By.cssSelector(".Order_Form__17u6u > .Order_MixedDatePicker__3qiay input[placeholder*='Когда привезти самокат']");
    private final By orderRentalPeriodMenu = By.cssSelector(".Order_Form__17u6u > .Dropdown-root > .Dropdown-control");
    private final By orderRentalPeriodOption = By.cssSelector(".Order_Form__17u6u > .Dropdown-root > .Dropdown-menu > .Dropdown-option");
    private final By orderColorCheckbox = By.cssSelector(".Order_Form__17u6u > .Order_Checkboxes__3lWSI");
    private final By orderCommentInput = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH > input[placeholder*='Комментарий']");
    private final By orderOrderBtn = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text()='Заказать']");
    private final By orderConfirmBtn = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private final By orderStatusBtn = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    public void fillOrderForm(Order order) {
        driver.findElement(orderFirstNameInput).sendKeys(order.getFirstName());
        driver.findElement(orderLastNameInput).sendKeys(order.getLastName());
        driver.findElement(orderAddressInput).sendKeys(order.getAddress());
        driver.findElement(orderPhoneInput).sendKeys(order.getPhone());

        driver.findElement(metroStationInput).sendKeys(order.getStation());
        driver.findElement(metroStationFirstSelectOption).click();

        driver.findElement(orderNextBtn).click();

        inputOrderDeliveryDate(order.getDeliveryDate());

        driver.findElement(orderRentalPeriodMenu).click();
        driver.findElement(orderRentalPeriodOption)
                .findElement(By.xpath("//div[text()='" + order.getRentalPeriod().getValue() + "']")).click();
        driver.findElement(orderColorCheckbox)
                .findElement(By.xpath(".//label[text()='" + order.getColor().getValue() + "']")).click();
        driver.findElement(orderCommentInput).sendKeys(order.getComment());

        driver.findElement(orderOrderBtn).click();
    }

    public void inputOrderDeliveryDate(LocalDate date) {
        driver.findElement(orderDeliveryDateInput).sendKeys(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public void clickOrderConfirmBtn() {
        driver.findElement(orderConfirmBtn).click();
    }

    public void clickOrderStatusBtn() {
        driver.findElement(orderStatusBtn).click();
    }
}
