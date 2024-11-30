import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ui.PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class GetTextInsideAccordeonChrome {
    private final String accordeonId;
    private final String accordeonText;
    private final String expectedText;

    public GetTextInsideAccordeonChrome(String accordeonId, String accordeonText, String expectedText) {
        this.accordeonId = accordeonId;
        this.accordeonText = accordeonText;
        this.expectedText = expectedText;
    }
    WebDriver driver;
    @Parameterized.Parameters
    public static Object[][] getTextInAccordeon() {
        return new Object[][]{
            {"accordion__heading-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {"accordion__heading-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {"accordion__heading-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {"accordion__heading-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {"accordion__heading-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {"accordion__heading-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {"accordion__heading-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {"accordion__heading-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testTextInAccordeon() {
        String accordeonLocator = String.format(".//div[@id='%s']", this.accordeonId);
        String accordeonTextLocator = String.format(".//P[text()='%s']", this.accordeonText);

        MainPage objMainPage_ = new MainPage(driver);
        objMainPage_.mainPage_TestFindElements(accordeonLocator, accordeonLocator);
        objMainPage_.scrollToAccordeon0(accordeonLocator);
        objMainPage_.openAccordeon0();
        objMainPage_.compareAccordeon0Text(this.expectedText, accordeonTextLocator);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}