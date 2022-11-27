package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmation {

    //*****Переменные*****
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private By confirmButton = By.xpath(".//button[text()='Да']");
    private By declineButton = By.xpath(".//button[text()='Нет']");
    private By confirmationMessage = By.xpath(".//button[text()='Посмотреть статус']");

    //*****Конструктор*****
    public OrderConfirmation (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    //*****Методы*****

    //Нажать "Да"
    public void clickYes() {
        basePage.click(confirmButton);
    }

    //Нажать "Нет"
    public void clickNo() {
        basePage.click(declineButton);
    }

    //Проверяем что появилась кнопка просмотра подтверждённого заказа
    public void validateOrderConfirmation() {
        String expectedButtonName = "Посмотреть статус";
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(confirmationMessage, expectedButtonName));
    }

}
