import org.openqa.selenium.WebElement;
import ru.services.praktikum.qa.scooter.page.object.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetTextInsideAccordeon extends BasePage {
    private final int accordeonIndex;
    private final String expectedText;

    public GetTextInsideAccordeon(int accordeonIndex, String expectedText) {
        this.accordeonIndex = accordeonIndex;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getTextInAccordeon() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void testTextInAccordeon() {

        MainPage objMainPage = new MainPage(driver);
        WebElement accordeonElement = objMainPage.getAccordeonElement(this.accordeonIndex);
        objMainPage.scrollToAccordeon(accordeonElement);
        accordeonElement.click();
        String actualText = objMainPage.getTextInAccordeon(accordeonElement);
        assertEquals(this.expectedText, actualText);
    }
}

