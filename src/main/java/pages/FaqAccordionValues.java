package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class FaqAccordionValues {

    //*****Переменные*****
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    //*****Элементы-переменные "гармошки" с FAQ*****
    private String accordionButtonLocator = ".//div[@id='accordion__heading-%s']";

    private String accordionPanelLocator = ".//div[@id='accordion__panel-%s']/p";

    public String[] accordionIndexArray = {"0", "1", "2", "3", "4", "5", "6", "7"};
;
    //*****Конструктор*****
    public FaqAccordionValues (WebDriver driver) {
        this.driver = driver;
    }


    //Открываем элемент "гармошки"
    public void clickAccordionItem(int n) {
        String accordionHeadingLocator = String.format(accordionButtonLocator, accordionIndexArray[n]);

        WebElement importantQuestions = driver.findElement(By.xpath(".//div[text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", importantQuestions);

        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(accordionHeadingLocator)));
        driver.findElement(By.xpath(accordionHeadingLocator)).click();
    }

    //Читаем текст ответа
    public String getAccordionText(int n) {
        String accordionAnswerLocator = String.format(accordionPanelLocator, accordionIndexArray[n]);
        return driver.findElement(By.xpath(accordionAnswerLocator)).getAttribute("innerHTML");
    }
}
