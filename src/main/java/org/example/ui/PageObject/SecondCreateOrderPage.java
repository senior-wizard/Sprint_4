package org.example.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondCreateOrderPage {
    //Локатор для поля "Когда привезти самокат"
    By dateToDeliverScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор для выпадающего списка "Срок аренды"
    By rentalPeriodList = By.xpath(".//span[@class='Dropdown-arrow']");

    //Локатор для значения выпадающего списка "Срок аренды"
    By rentalPeriod;
    //Метод, определяющий локатор для значения выпадающего списка "Срок аренды"
    private By rentalPeriodLocator (String rentalPeriodLocator) {
        return rentalPeriod = By.xpath(rentalPeriodLocator);
    }

    //Локатор для кнопки "Заказать", находящейся под полями ввода
    By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для кнопки "Да" внутри окна подтверждения заказа
    By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public WebDriver driver;

    public SecondCreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateToDeliverScooter(String date) {
        driver.findElement(dateToDeliverScooter).sendKeys(date);
    }

    public void openRentalPeriodList() {
        driver.findElement(rentalPeriodList).click();
    }

    public void scrollToRentalPeriod(String rentalPeriodLocator) {
        WebElement element = driver.findElement(By.xpath(rentalPeriodLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    public void openOrderConfirmationWindow() {
        driver.findElement(orderButton).click();
    }

    public void clickOnYesButtonAndCreateOrder() {
        driver.findElement(yesButton).click();
    }

    public void createOrder(String date,String rentalPeriodLocator) {
        rentalPeriodLocator (rentalPeriodLocator);
        setDateToDeliverScooter(date);
        openRentalPeriodList();
        scrollToRentalPeriod(rentalPeriodLocator);
        chooseRentalPeriod();
        openOrderConfirmationWindow();
        clickOnYesButtonAndCreateOrder();
    }
}
