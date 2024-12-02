package ru.services.praktikum.qa.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstCreateOrderPage {
    //Локатор поля "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля "Фамилия"
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля "Станция метро"
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор для выпадающего списка поля "Станция метро"
    private By metroStationList = By.xpath(".//li[@class='select-search__row']");
    //Локатор поля "Телефон"
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "Далее"
    private By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public WebDriver driver;

    public FirstCreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getMetroStationElement(int index) {
        List<WebElement> metroStationList = driver.findElements(this.metroStationList);
        return metroStationList.get(index);
    }

    public void scrollToMetroStation(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

        public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void openMetroStationList() {
        driver.findElement(metroStationField).click();
    }

    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }

    public void waitUntilFirstCreateOrderPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));
    }

    public void goToSecondOrderPage(String name, String surname,String address, String phoneNumber, int metroStationIndex) {
        waitUntilFirstCreateOrderPageIsOpen();
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        openMetroStationList();
        WebElement metroStationElement = getMetroStationElement(metroStationIndex);
        scrollToMetroStation(metroStationElement);
        metroStationElement.click();
        setPhoneNumber(phoneNumber);
        clickFurtherButton();
    }
}

