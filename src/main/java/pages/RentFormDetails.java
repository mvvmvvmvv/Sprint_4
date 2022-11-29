package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentFormDetails {

    //*****Переменные*****
    private WebDriver driver;
    private BasePage basePage;

    //Поле даты
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By enabledDatepicker = By.xpath(".//div[@tabindex='0']");

    //Поле выбора срока аренды
    private By howLong = By.xpath(".//div[@class='Dropdown-control']");
    private String dropdownOptionsLocator = ".//div[text()='%s']";
    private String[] howLongOptionsArray = {"сутки", "двое суток", "трое суток", "четверо суток", "пятеро суток",
            "шестеро суток", "семеро суток"};

    //Поля выбора цвета
    private By checkboxBlack = By.id("black");
    private By checkboxGrey = By.id("grey");

    //Поле комментария
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопки "Заказать" и "Назад"
    private By submitOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");

    //*****Конструктор*****
    public RentFormDetails (WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    //*****Методы*****
    //Заполняем поле даты
     public void inputDate(String deliveryDate) {
        basePage.writeText(date, deliveryDate);
     }

     //Выбираем срок аренды
     public void selectLength(int n) {
        basePage.click(howLong);
        String howLongOption = String.format(dropdownOptionsLocator, howLongOptionsArray[n]);
        driver.findElement(By.xpath(howLongOption)).click();
     }

     //Выбираем чёрный или серый самокат
     public void selectColor(String color) {
        if (color == "Black") {
            basePage.click(checkboxBlack);
        }
        basePage.click(checkboxGrey);
     }

     //Заполняем поле комментария
     public void writeComment(String userComment) {
        basePage.writeText(comment, userComment);
     }

     //Подтверждаем заказ
     public void submitOrder() {
        basePage.click(submitOrderButton);
     }

    //Возвращаемся на предыдущий шаг
    public void goBack() {
        basePage.click(backButton);
    }
}
