package tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FaqAccordionValues;
import pages.HomePage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFaq {

    private WebDriver driver;
    private final int index;
    private final String expectedText;

    public TestFaq(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] compareTextData() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkAllFaqItems() {
        driver = new ChromeDriver();
        FaqAccordionValues objFaqAccordion = new FaqAccordionValues(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        //new WebDriverWait(driver, Duration.ofSeconds(20));

        objFaqAccordion.clickAccordionItem(index);
        String actualText = objFaqAccordion.getAccordionText(index);

        assertEquals("Ответ не совпадает", expectedText, actualText);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
