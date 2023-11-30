package StepObject;
import PageObject.TaxiPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;
import static DataObject.TaxiPageData.*;

public class TaxiPageSteps extends TaxiPage {

    @Step("აეროპორტის ტაქსის გვერდზე გადასვლა")
    public TaxiPageSteps goToTaxiPage (){
        taxiPageLink.click();
        return this;
    }
    @Step("დაბრუნების ოფციის არჩევა")
    public TaxiPageSteps selectReturnOption (){
        returnOption.click();
        return this;
    }

    @Step("ჩასხდომის ადგილის შეყვანა")
    public TaxiPageSteps enterPickUpLocation(){
        pickUpLocationField.setValue(location1).should(Condition.visible, Duration.ofMillis(5000));
        pickUpLocationAutocomplete_1.click();
        return this;
    }

    @Step("საბოლოო დანიშნულების ადგილის შეყვანა")
    public TaxiPageSteps enterDropOffLocation(){
        dropOffLocationField.setValue(location2).should(Condition.visible, Duration.ofMillis(5000));
        dropOffLocationAutocomplete_1.click();
        return this;
    }

    @Step("ძებნის ღილაკზე დაჭერა")
    public TaxiPageSteps clickSearch(){
        searchBtn.click();
        //searchBtn.should(Condition.enabled, Duration.ofMillis(10000));
        return this;
    }
    @Step("Show more ღილაკამდე სქროლი")
    public TaxiPageSteps scrollToShowMore() {
        showMoreBtn.scrollTo();
        return this;
    }
    @Step("Show more ღილაკზე დაჭერა")
    public TaxiPageSteps clickShowMore(){
        showMoreBtn.click();
        return this;
    }
    @Step("Show less ღილაკამდე სქროლი")
    public TaxiPageSteps scrollToShowLess() {
        showLessBtn.scrollTo();
        return this;
    }
    @Step("Show less ღილაკზე დაჭერა")
    public TaxiPageSteps clickShowLess(){
        showLessBtn.click();
        return this;
    }

}
