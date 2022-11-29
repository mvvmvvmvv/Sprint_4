package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    //*****Переменные*****
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    //Кнопка заказа в хэдере
    private By orderButtonInHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Большая кнопка заказа посреди страницы
    private By orderButtonBig = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    //*****Конструктор*****
    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    //Нажимаем кнопку заказа в хэдере
    public void clickHeaderButton() {
        basePage.click(orderButtonInHeader);
    }

    //Нажимаем кнопку заказа в середине страницы
    public void clickBigButton() {
        basePage.click(orderButtonBig);
    }
}
