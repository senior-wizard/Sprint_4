package ru.services.praktikum.qa.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    public WebDriver driver;

    //Локатор для списка аккордеонов
    private By accordeonsList = By.className("accordion__item");
    //Локатор для аккордеона
    private By accordeonText = By.className("accordion__panel");
    //Локатор для кнопки "Заказать"
    private By openFirstCreateOrderPageButton = By.xpath(".//button[@class='Button_Button__ra12g']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAccordeonElement(int index) {
        List<WebElement> accordeonsList = driver.findElements(this.accordeonsList);
        return accordeonsList.get(index);
    }

    public void scrollToAccordeon(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getTextInAccordeon(WebElement element) {
        return element.findElement(accordeonText).getText();
    }

    public void openOrderPage () {
        driver.findElement(openFirstCreateOrderPageButton).click();
    }
}
