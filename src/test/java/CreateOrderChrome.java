import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ui.PageObject.FirstCreateOrderPage;
import org.example.ui.PageObject.MainPage;
import org.example.ui.PageObject.SecondCreateOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class CreateOrderChrome {
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String metroStationValue;

    private final String date;
    private final String rentalPeriodText;

    public CreateOrderChrome(String name, String surname, String address, String phoneNumber, String metroStationLocator, String date, String rentalPeriodLocator) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStationValue = metroStationLocator;

        this.date = date;
        this.rentalPeriodText = rentalPeriodLocator;
    }

    WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] createOrderData() {
        return new Object[][]{
                {"Жмых", "Петров", "Пушкина 7", "89539549555", "1", "12.12.2024", "трое суток"},
                {"Петр", "Жмыхов", "Жмыхово 13", "89131234567", "2", "10.12.2024", "сутки"},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void createOrder() {
        String metroStationLocator = String.format(".//button[@value='%s']", metroStationValue);
        String rentalPeriodLocator = String.format(".//div[text()='%s']", rentalPeriodText);
        MainPage objMainPage_ = new MainPage(driver);
        FirstCreateOrderPage objFirstCreateOrderPage = new FirstCreateOrderPage(driver);
        SecondCreateOrderPage objSecondCreateOrderPage = new SecondCreateOrderPage(driver);

        objMainPage_.openOrderPage();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));

        objFirstCreateOrderPage.goToSecondOrderPage(this.name, this.surname, this.address,this.phoneNumber, metroStationLocator);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));

        objSecondCreateOrderPage.createOrder(this.date, rentalPeriodLocator);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Заказ оформлен']")));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
