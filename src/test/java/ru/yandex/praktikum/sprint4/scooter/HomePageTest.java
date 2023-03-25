package ru.yandex.praktikum.sprint4.scooter;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.sprint4.scooter.page.HomePage;
import ru.yandex.praktikum.sprint4.scooter.page.OrderPage;

import static org.junit.Assert.*;

public class HomePageTest extends BaseTest {

    private HomePage page;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        page = new HomePage(driver);

        // Нажимаем на кнопку принятия куки, чтобы скрыть панель согласия на использование файлов cookie
        // т.к. она мешает выполнять клики по аккордеону "Вопросы о важном"
        page.clickAcceptCookieBtn();
    }

    @Test
    public void testFaqAccordion() {
        // оба ответа скрыты
        assertFalse(page.isFaqAnswer1Visible());
        assertFalse(page.isFaqAnswer2Visible());

        // кликнув на 1й вопрос должен отобразиться 1й ответ
        page.clickFaqQuestion1();
        page.waitFaqAnswer1Visible();
        assertTrue(page.isFaqAnswer1Visible());
        assertFalse(page.isFaqAnswer2Visible());

        // кликнув на 2й вопрос должен отобразиться 2й ответ, а 1й ответ скрыться
        page.clickFaqQuestion2();
        page.waitFaqAnswer2Visible();
        assertFalse(page.isFaqAnswer1Visible());
        assertTrue(page.isFaqAnswer2Visible());
    }

    @Test
    public void testOrderByClickHeaderOrderButton() {
        page.clickHeaderOrderBtn();
        page.waitOrderFormVisibility();
        assertEquals(driver.getCurrentUrl(), OrderPage.URL);
    }

    @Test
    public void testOrderByClickRoadmapFinishOrderButton() {
        page.clickRoadmapFinishOrderBtn();
        page.waitOrderFormVisibility();
        assertEquals(driver.getCurrentUrl(), OrderPage.URL);
    }
}
