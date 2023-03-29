package ru.yandex.praktikum.sprint4.scooter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.sprint4.scooter.model.Color;
import ru.yandex.praktikum.sprint4.scooter.model.Order;
import ru.yandex.praktikum.sprint4.scooter.model.RentalPeriod;
import ru.yandex.praktikum.sprint4.scooter.page.HomePage;
import ru.yandex.praktikum.sprint4.scooter.page.OrderPage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {
    private OrderPage page;
    private final Order order;
    private final By button;

    public OrderPageTest(Order order, By button) {
        this.order = order;
        this.button = button;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testOrderData() {
        return Arrays.asList(new Object[][]{
                {
                        new Order("Фыва", "Олдж", "ул Уличная 15, кв 24",
                                "Охотный Ряд", "89001112233", LocalDate.now().plusDays(3),
                                RentalPeriod.TWO_DAYS, Color.BLACK, "домофона нет"),
                        By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']")
                },
                {
                        new Order("Иван", "Иванов", "ул Ералашная 9",
                                "Пятницкое шоссе", "89007777777", LocalDate.now().plusDays(5),
                                RentalPeriod.THREE_DAYS, Color.GREY, "без комментариев"),
                        By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']")
                }
        });
    }

    @Before
    public void setUpEach() {
        page = new OrderPage(driver);
    }

    @Test
    public void testOrder() {
        driver.get(HomePage.URL);

        driver.findElement(button).click();
        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.ORDER_URL));

        page.fillOrderForm(order);
        page.clickOrderConfirmBtn();

        page.clickOrderStatusBtn();

        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.TRACK_URL));
    }
}
