import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
    WebDriver driver;
    @Before
    public void setup() {
        boolean chromeBrowser = false; // Указал браузер chrome. Если задать false - то будет тестировать в firefox
        if (chromeBrowser == true) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

