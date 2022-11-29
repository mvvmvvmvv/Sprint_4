package tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.OrderConfirmation;
import pages.RentFormDetails;
import pages.RentFormPersonal;

import java.time.Duration;

@RunWith(Parameterized.class)
public class TestHappyPath {

    private WebDriver driver;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String userMetro;
    private final String mobile;
    private final int durationOption;
    private final String colorSelect;
    private final String userComment;
    private final String deliveryDate;

    public TestHappyPath(String firstName, String secondName, String address, String userMetro, String mobile,
                         int durationOption, String colorSelect, String userComment, String deliveryDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.userMetro = userMetro;
        this.mobile = mobile;
        this.durationOption = durationOption;
        this.colorSelect = colorSelect;
        this.userComment = userComment;
        this.deliveryDate = deliveryDate;
    }

    @Parameterized.Parameters(name = "Test data: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}")
    public static Object[][] inputData() {
        return new Object[][] {
                {"Николай", "Расторгуев", "Петровка, 38", "Таганская", "89112128506", 3, "Black", "Атас!", "31.12.2022"},
                {"Перегрин", "Тук", "Туда и обратно", "Лубянка", "89119117766", 2, "Grey", "Абырвалг!", "10.12.2022"},
        };
    }

    @Test
    public void happyPathTest() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage.clickHeaderButton();

        RentFormPersonal objPersonalInfo = new RentFormPersonal(driver);
        objPersonalInfo.inputFirstName(firstName);
        objPersonalInfo.inputSecondName(secondName);
        objPersonalInfo.inputAddress(address);
        objPersonalInfo.inputMetro(userMetro);
        objPersonalInfo.inputTelephone(mobile);
        objPersonalInfo.clickContinue();

        new WebDriverWait(driver, Duration.ofSeconds(3));

        RentFormDetails objOrderDetails = new RentFormDetails(driver);
        objOrderDetails.selectLength(durationOption);
        objOrderDetails.selectColor(colorSelect);
        objOrderDetails.writeComment(userComment);
        objOrderDetails.inputDate(deliveryDate);
        objOrderDetails.submitOrder();

        new WebDriverWait(driver, Duration.ofSeconds(3));

        OrderConfirmation objConfirmOrder = new OrderConfirmation(driver);
        objConfirmOrder.clickYes();
        objConfirmOrder.validateOrderConfirmation();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
