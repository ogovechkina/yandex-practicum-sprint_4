package ru.yandex.praktikum.sprint4.scooter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.sprint4.scooter.model.Color;
import ru.yandex.praktikum.sprint4.scooter.model.Order;
import ru.yandex.praktikum.sprint4.scooter.model.RentalPeriod;
import ru.yandex.praktikum.sprint4.scooter.page.OrderPage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

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
    @Override
    public void setUp() {
        super.setUp();

        page = new OrderPage(driver);

        // Нажимаем на кнопку принятия куки, чтобы скрыть панель согласия на использование файлов cookie
        // т.к. она мешает выполнять клики по аккордеону "Вопросы о важном"
        page.clickAcceptCookieBtn();
    }

    @Test
    public void testOrder() {
        page.fillOrderForm(order);
        page.clickOrderConfirmBtn();

        page.clickOrderStatusBtn();

        assertTrue(driver.getCurrentUrl().startsWith(OrderPage.TRACK_URL));
    }
}
