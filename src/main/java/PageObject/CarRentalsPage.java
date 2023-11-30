package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CarRentalsPage {
    public SelenideElement
            carRentalsLinkBtn = $("#cars"),
            driverAgeCheckbox = $("#drivers-age-checkbox"),
            searchBtn = $(".LPCM_92786005"),
            driversAgeInputField = $("#drivers-age-input-text"),
            currencySelectorBtn = $("#currency-selector-button"),
            currencyOptUSD = $(".bui-traveller-header__currency"),
            currencyOptEUR = $(".bui-traveller-header__currency",1),

            popularDestinations =$((".af8fbdf136"),2);


    public static SelenideElement
            driversAge = $(".searchbox-toolbox-drivers-age__input"),
            pickUpLocationValidation = $("#sbc-popover-error-msg-pick-up-validation-medium"),
            driversAgeValidation_empty = $("#sbc-popover-error-msg-drivers-age"),
            getDriversAgeValidation_invalid = $("#sbc-popover-error-msg-drivers-age"),
            pricePerDay = $(byXpath("//*[@id=\"b2runway_internal_actionPage\"]/div[3]/main/div[7]/div/div/div[2]/div/div[1]/a/div/div[2]/div[3]/span")),
            weekendOptionPrice = $(".bccf46a753").$(".af8fbdf136");


}
