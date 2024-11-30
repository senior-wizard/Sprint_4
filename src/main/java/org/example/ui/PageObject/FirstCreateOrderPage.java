package org.example.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstCreateOrderPage {
    //Локатор поля "Имя"
    By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля "Фамилия"
    By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля "Адрес"
    By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля "Станция метро"
    By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор для выпадающего списка поля "Станция метро"
    By metroStationList = By.xpath(".//div[@class='select-search__value']");
    //Локатор для станции метро
    By metroStation;
    //Локатор поля "Телефон"
    By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "Далее"
    By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public WebDriver driver;

    public FirstCreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод, определяющий локатор для станции метро
    private By metroStationLocator (String metroStationLocator) {
        return metroStation = By.xpath(metroStationLocator);
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

    public void scrollToMetroStation(String metroStationLocator) {
        WebElement element = driver.findElement(By.xpath(metroStationLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void chooseMetroStation() {
        driver.findElement(metroStation).click();
    }

    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }

    public void goToSecondOrderPage(String name, String surname, String address, String phoneNumber, String metroStationLocator) {
        metroStationLocator(metroStationLocator);
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setPhoneNumber(phoneNumber);
        openMetroStationList();
        scrollToMetroStation(metroStationLocator);
        chooseMetroStation();
        clickFurtherButton();
    }
}
