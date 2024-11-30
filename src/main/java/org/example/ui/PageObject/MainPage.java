package org.example.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    //Локатор для аккордеона
    private By accordeon;
    //Метод, определяющий локатор для аккордеона
    private By accordeonLocator (String accordeonLocator) {
        return accordeon = By.xpath(accordeonLocator);
    }

    //Локатор для элемента с текстом у аккордеона
    private By accordeonText;
    //Метод, определяющий локатор для элемента с текстом у аккордеона
    private By accordeonTextLocator (String accordeonTextLocator) {
        return accordeonText = By.xpath(accordeonTextLocator);
    }

    //Локатор для кнопки "Заказать"
    private final By openFirstCreateOrderPageButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Метод для нахождения элементов аккордеона и текста внутри аккордеона
    public void mainPage_TestFindElements(String accordeonLocator, String accordeonTextLocator) {
        accordeonLocator(accordeonLocator);
        accordeonTextLocator(accordeonTextLocator);
    }

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToAccordeon0(String accordeonLocator) {
        WebElement element = driver.findElement(By.xpath(accordeonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void openAccordeon0() {
        driver.findElement(accordeon).click();
    }

    public void compareAccordeon0Text(String textInAccordeon, String accordeonTextLocator) {
        ExpectedConditions.textToBePresentInElementLocated(accordeonText, accordeonTextLocator);
    }

    public void openOrderPage () {
        driver.findElement(openFirstCreateOrderPageButton).click();
    }
}
