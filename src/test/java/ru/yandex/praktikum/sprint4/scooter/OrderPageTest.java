package ru.yandex.praktikum.sprint4.scooter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.sprint4.scooter.model.Color;
import ru.yandex.praktikum.sprint4.scooter.model.Order;
import ru.yandex.praktikum.sprint4.scooter.model.RentalPeriod;
import ru.yandex.praktikum.sprint4.scooter.page.HomePage;
import ru.yandex.praktikum.sprint4.scooter.page.OrderPage;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {
    private OrderPage page;
    private final Order order;

    public OrderPageTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Collection<Order> testOrderData() {
        return Arrays.asList(
                new Order("Фыва", "Олдж", "ул Уличная 15, кв 24",
                        "Охотный Ряд", "89001112233", LocalDate.now().plusDays(3),
                        RentalPeriod.TWO_DAYS, Color.BLACK, "домофона нет"),
                new Order("Иван", "Иванов", "ул Ералашная 9",
                        "Пятницкое шоссе", "89007777777", LocalDate.now().plusDays(5),
                        RentalPeriod.THREE_DAYS, Color.GREY, "без комментариев")
        );
    }

    @Before
    public void setUpEach() {
        page = new OrderPage(driver);
    }

    @Test
    public void testOrderByClickHeaderOrderButton() {
        driver.get(HomePage.URL);
        
        page.clickHeaderOrderBtn();
        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.ORDER_URL));
        
        page.fillOrderForm(order);
        page.clickOrderConfirmBtn();

        page.clickOrderStatusBtn();

        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.TRACK_URL));
    }
    
    @Test
    public void testOrderByClickRoadmapFinishOrderButton() {
        driver.get(HomePage.URL);
        
        page.clickRoadmapFinishOrderBtn();
        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.ORDER_URL));
        
        page.fillOrderForm(order);
        page.clickOrderConfirmBtn();

        page.clickOrderStatusBtn();

        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.TRACK_URL));
    }
}
