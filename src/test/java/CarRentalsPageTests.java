import PageObject.CarRentalsPage;
import StepObject.CarRentalsPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CarRentalsPageTests extends ChromeRunner {
    CarRentalsPageSteps carRentalsPageSteps = new CarRentalsPageSteps();

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("ვალიდაციების მესიჯების გადამოწმება: ცარიელი Pickup locarion ველისთვის, ცარიელი Driver's age ველისთვის, ასევე Driver's age ველის 18-მდე, 18 და 18-ზე მეტი ასაკისთვის")
    public void validationMessagesAppearanceCheck(){
        carRentalsPageSteps
                .goToCarRentalsPage()
                .uncheckDriverAgeCheckBox();
        Assert.assertTrue(CarRentalsPage.driversAge.exists(), "Driver's age input appearance check");
        carRentalsPageSteps
                .clickSearchBtn();
        Assert.assertTrue(CarRentalsPage.pickUpLocationValidation.exists(), "Pick-up location empty field validation check");
        Assert.assertTrue(CarRentalsPage.driversAgeValidation_empty.exists(), "Driver's age empty field validation check");
        carRentalsPageSteps.enterDriversAge();
    }
    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("ვალუტის შეცვლისას გვერდზე არსებული ფასების ვალუტების ცვლილების გადამოწმება დოლარისთვის და ევროსთვის")
    public void priceCurrencyCheck(){
        carRentalsPageSteps
                .goToCarRentalsPage()
                .selectUSD()
                .scrollToPopularDestinations();
        Assert.assertTrue(CarRentalsPage.pricePerDay.getText().contains("$"), "Check if prices are in USD");
        carRentalsPageSteps
                .selectEUR()
                .scrollToPopularDestinations();
        Assert.assertTrue(CarRentalsPage.pricePerDay.getText().contains("€"), "Check if prices are in EUR");
        carRentalsPageSteps
                .scrollToPopularDestinations()
                .selectPopularDestination();
        Assert.assertTrue(CarRentalsPage.weekendOptionPrice.getText().contains("€"),"Check if prices are in EUR" );

            }
}
