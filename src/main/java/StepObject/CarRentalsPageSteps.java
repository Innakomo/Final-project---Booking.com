package StepObject;

import DataObject.CarRentalsPageData;
import PageObject.CarRentalsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;


public class CarRentalsPageSteps extends CarRentalsPage {


    @Step("Car Rentals გვერდზე გადასვლა")
    public CarRentalsPageSteps goToCarRentalsPage() {
        carRentalsLinkBtn.click();
        return this;
    }

    @Step("მძღოლის ასაკის ჩექბოქსის მონიშვნის წაშლა")
    public CarRentalsPageSteps uncheckDriverAgeCheckBox() {
        driverAgeCheckbox.click();
        driverAgeCheckbox.shouldNotBe(Condition.selected);
        return this;
    }

    @Step("Search ღილაკზე დაჭერა")
    public CarRentalsPageSteps clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    @Step("მძღოლის ასაკის შეყვანა")
    public CarRentalsPageSteps enterDriversAge() {
        for (int i = 0; i < CarRentalsPageData.driversAge.length; i++) {
            driversAgeInputField.setValue(String.valueOf(CarRentalsPageData.driversAge[i]));
            searchBtn.click();
            if (CarRentalsPageData.driversAge[i] < 18) {
                Assert.assertTrue(CarRentalsPage.getDriversAgeValidation_invalid.exists(), "Invalid driver's age input check");
            }
            driversAgeInputField.sendKeys(Keys.BACK_SPACE);
            driversAgeInputField.sendKeys(Keys.BACK_SPACE);
        }
        return this;
    }
    @Step("დოლარის ვალუტის არჩევა")
    public CarRentalsPageSteps selectUSD() {
        currencySelectorBtn.click();
        currencyOptUSD.click();
        return this;
    }

    @Step("პოპულარული მიმართულებების განყოფილებამდე ჩასქროლვა")
    public CarRentalsPageSteps scrollToPopularDestinations() {
        popularDestinations.scrollTo();
        return this;
    }

    @Step("ევროს ვალუტის არჩევა")
    public CarRentalsPageSteps selectEUR() {
        currencySelectorBtn.click();
        currencyOptEUR.click();
        return this;
    }
    @Step("პირველი პოპულარული მიმართულების გახსნა მასზე დაკლიკებით")
    public CarRentalsPageSteps selectPopularDestination() {
        pricePerDay.click();
        return this;
    }


}



