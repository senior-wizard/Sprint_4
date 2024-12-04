import ru.services.praktikum.qa.scooter.page.object.FirstCreateOrderPage;
import ru.services.praktikum.qa.scooter.page.object.MainPage;
import ru.services.praktikum.qa.scooter.page.object.SecondCreateOrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestCreateOrder extends BasePage {
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final int metroStationIndex;

    private final String date;
    private final int rentalPeriodIndex;

    public TestCreateOrder(String name, String surname, String address, String phoneNumber, int metroStationIndex, String date, int rentalPeriodIndex) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStationIndex = metroStationIndex;

        this.date = date;
        this.rentalPeriodIndex = rentalPeriodIndex;
    }

    @Parameterized.Parameters
    public static Object[][] createOrderData() {
        return new Object[][]{
                {"Жмых", "Петров", "Пушкина 7", "89539549555", 1, "12.12.2024", 1},
                {"Петр", "Жмыхов", "Жмыхово 13", "89131234567", 3, "10.12.2024", 3},
        };
    }



    @Test
    public void testCreateOrderWithFirstCreateOrderPageButtonUp() {
        MainPage objMainPage = new MainPage(driver);
        FirstCreateOrderPage objFirstCreateOrderPage = new FirstCreateOrderPage(driver);
        SecondCreateOrderPage objSecondCreateOrderPage = new SecondCreateOrderPage(driver);

        objMainPage.openOrderPageButtonUp();
        objFirstCreateOrderPage.goToSecondOrderPage(this.name, this.surname, this.address, this.phoneNumber, this.metroStationIndex);
        objSecondCreateOrderPage.createOrder(this.date, this.rentalPeriodIndex);
    }
    @Test
    public void testCreadeOrderWithFirstCreateOrderPageButtonDown() {
        MainPage objMainPage = new MainPage(driver);
        FirstCreateOrderPage objFirstCreateOrderPage = new FirstCreateOrderPage(driver);
        SecondCreateOrderPage objSecondCreateOrderPage = new SecondCreateOrderPage(driver);

        objMainPage.scrollOrderPageButtonDown();
        objMainPage.openOrderPageButtonDown();
        objFirstCreateOrderPage.goToSecondOrderPage(this.name, this.surname, this.address, this.phoneNumber, this.metroStationIndex);
        objSecondCreateOrderPage.createOrder(this.date, this.rentalPeriodIndex);
    }
}
