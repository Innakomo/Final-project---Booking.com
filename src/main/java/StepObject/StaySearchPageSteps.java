package StepObject;
import PageObject.StaySearchPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class StaySearchPageSteps extends StaySearchPage {

    @Step("ლოქეიშენის შევსება მნიშვნელობით:{location}")
    public StaySearchPageSteps insertLocation(String location){
        locationInputField.setValue(location);
        locationInputField.shouldNotBe(Condition.empty);
        return this;
    }
    @Step("კალენდრის გახსნა")
    public StaySearchPageSteps openCalendar(){
        dateInputField.click();
        return this;
    }
    @Step("თარიღის არჩევა კალენდარში")

    public StaySearchPageSteps selectFromDate(){
        calendarDate.click();
        return this;
    }
    @Step("სასტუმროში დარჩენის ხანგრძლივობის დღეების არჩევა")

    public StaySearchPageSteps selectDurationOption(){
        daysNumOption.click();
        dateInputField.shouldNotBe(Condition.empty);
        return this;
    }
    @Step("Search ღილაკზე დაჭერა")

    public StaySearchPageSteps searchForResult(){
        searchBtn.click();
        return this;
    }
    @Step("სორტირების ვარიანტების სიის გახსნა")
    public StaySearchPageSteps openSortingOptions(){
        sortByBtn.click();
        return this;
    }
    @Step("ფასის ზრდადობის მიხედვით სორტირება")
    public StaySearchPageSteps selectOpt_LowerPriceAsc(){
        sortOptLowestPrice.click();
        sortOptLowestPrice.should(Condition.visible, Duration.ofMillis(5000));
        return this;
    }
    @Step("ფასის ზრდადობის მიხედვით დალაგებული სიის გადამოწმება")
    public boolean orderCheck_Asc(){
        String[] firstPriceWithoutCur = firstPrice.getText().split(" ", 2);
        int firstItemPrice = Integer.valueOf(firstPriceWithoutCur[1]);
        for(int i = 0; i<25; i++){
            String[] secondPriceWithoutCur = secondPrice.getText().split(" ", 2);
            int secondItemPrice = Integer.valueOf(secondPriceWithoutCur[1]);
            if(secondItemPrice>=firstItemPrice){
                firstItemPrice=secondItemPrice;
            }
        }
        return true;
    }

    @Step("ფილტრი: 1 კმ რადიუსის მიხედვით")

    public StaySearchPageSteps selectFilterOpt_Distance_1km(){
        filterOpt_1km.click();
        filterOpt_1km.should(Condition.visible, Duration.ofMillis(3000));
        return this;
    }



}
