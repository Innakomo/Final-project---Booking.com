package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TaxiPage {
    public SelenideElement
            taxiPageLink = $("#airport_taxis"),
            returnOption = $(byTagAndText("span", "Return")),
            returnRadio = $("#returnJourneyAffirmative"),
            dropOffLocationField = $("#dropoffLocation"),
            pickUpLocationField = $("#pickupLocation"),
            returnDropOffLocation = $("#returnDropoffLocation"),
            returnPickupLocation = $("#returnPickupLocation"),
            pickUpLocationAutocomplete_1 = $(".rw-autocomplete__item-text",0),
            dropOffLocationAutocomplete_1 = $(".rw-autocomplete__item-text",0),
            searchBtn = $(".gb-o-btn__content"),
            showMoreBtn = $(".SRM_b7bff305"),
            showLessBtn = $(".SRM_b7bff305");
    public ElementsCollection
            taxiOption = $$(".SRM_527ba3f0");




}
