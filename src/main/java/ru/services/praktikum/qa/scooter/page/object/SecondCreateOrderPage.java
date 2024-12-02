package ru.services.praktikum.qa.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SecondCreateOrderPage {
    //Локатор для поля "Когда привезти самокат"
    private By dateToDeliverScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор для "Срок аренды"
    private By rentalPeriodField = By.xpath(".//span[@class='Dropdown-arrow']");
    //Локатор для выпадающего списка "Срок аренды"
    private By rentalPeriodList = By.xpath(".//div[@class='Dropdown-option']");
    //Локатор для кнопки "Заказать", находящейся под полями ввода
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для кнопки "Да" внутри окна подтверждения заказа
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public WebDriver driver;

    public SecondCreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRentalPeriodElement(int index) {
        List<WebElement> rentalPeriodList = driver.findElements(this.rentalPeriodList);
        return rentalPeriodList.get(index);
    }

    public void setDateToDeliverScooter(String date) {
        driver.findElement(dateToDeliverScooter).sendKeys(date);
    }

    public void openRentalPeriodList() {
        driver.findElement(rentalPeriodField).click();
    }

    public void scrollToRentalPeriod(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void openOrderConfirmationWindow() {
        driver.findElement(orderButton).click();
    }

    public void clickOnYesButtonAndCreateOrder() {
        driver.findElement(yesButton).click();
    }

    public void waitUntilSecondCreateOrderPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));
    }

    public void waitUntilCreateOrderWindowIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Заказ оформлен']")));
    }

    public void createOrder(String date, int rentalPeriodIndex) {
        waitUntilSecondCreateOrderPageIsOpen();
        setDateToDeliverScooter(date);
        openRentalPeriodList();
        WebElement rentalPeriodElement = getRentalPeriodElement(rentalPeriodIndex);
        scrollToRentalPeriod(rentalPeriodElement);
        rentalPeriodElement.click();
        openOrderConfirmationWindow();
        clickOnYesButtonAndCreateOrder();
        waitUntilCreateOrderWindowIsOpen();
    }
}