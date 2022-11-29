package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentFormPersonal {

    //*****Переменные*****
    private WebDriver driver;
    private BasePage basePage;

    //Имя
    private By firstName = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private By secondName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    private By divListHack = By.xpath(".//div[@class='select-search__select']");
    //Телефон
    private By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By continueButton = By.xpath(".//button[text()='Далее']");

    //*****Конструктор*****
    public RentFormPersonal (WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

     //*****Методы*****
     //Заполняем поле "Имя"
     public void inputFirstName(String userFirstName) {
        basePage.writeText(firstName, userFirstName);
     }

     //Заполняем поле "Фамилия"
     public void inputSecondName(String userSecondName) {
        basePage.writeText(secondName, userSecondName);
     }

     //Заполняем поле адреса
     public void inputAddress(String userAddress) {
        basePage.writeText(address, userAddress);
     }

     //Выбираем станцию метро
     public void inputMetro (String userMetro) {
        basePage.click(metro);
        basePage.writeText(metro, userMetro);
        basePage.click(divListHack);
     }

     //Указываем номер телефона
     public void inputTelephone(String userTelephone) {
        basePage.writeText(telephone, userTelephone);
     }

     //Нажимаем "Далее"
     public void clickContinue() {
        basePage.click(continueButton);
     }
}

