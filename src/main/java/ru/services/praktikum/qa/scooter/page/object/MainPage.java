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
    //Локатор для кнопки "Заказать" в шапке страницы
    private By openFirstCreateOrderPageButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Локатор для кнопки "Заказать" внизу страницы
    private By openFirstCreateOrderPageButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");



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

    public void openOrderPageButtonUp() {
        driver.findElement(openFirstCreateOrderPageButtonUp).click();
    }

    public void scrollOrderPageButtonDown () {
        WebElement element = driver.findElement(openFirstCreateOrderPageButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void openOrderPageButtonDown() {
        driver.findElement(openFirstCreateOrderPageButtonDown).click();

    }
}
