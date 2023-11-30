package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StaySearchPage {
    public SelenideElement
            locationInputField = $(".eb46370fe1"),
            dateInputField = $(".f73e6603bf"),
            calendarDate = $(by("data-date", "2023-12-02")),
            daysNumOption = $(byText("1 day")),
            searchBtn = $(".d12ff5f5bf"),
            propertyAddress = $(byAttribute("data-testid", "address")),
            locationValidation = $(".feaba1002a"),
            sortByBtn = $(byAttribute("data-testid", "sorters-dropdown-trigger")),
            sortOptLowestPrice = $(byText("Price (lowest first)")),
            propAmountBeforeFilter =$(".d5f78961c3"),
            filterOpt_1km = $(byAttribute("data-filters-item", "distance:distance=1000")),
            propAmountAfterFilter = $(".d5f78961c3"),
            firstPrice = $(by("data-testid", "price-and-discounted-price"),0),
            secondPrice = $(by("data-testid", "price-and-discounted-price"));

}
