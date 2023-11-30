import StepObject.TaxiPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.TaxiPageData.*;
import static com.codeborne.selenide.Selenide.sleep;

public class TaxiPageTests extends ChromeRunner {
    TaxiPageSteps taxiPageSteps = new TaxiPageSteps();


    @Test(priority = 4)
    @Severity(SeverityLevel.MINOR)
    @Description("აეროპორტის ტაქსების გვერდზე გადასვლა და დაბრუნების შესაძლებლობის არჩევა. რადიო ღილაკის შეცვლის შემოწმება. მეორე ძებნის ველის გამოჩენის შემოწმება")
    public void selectReturnOpt(){
        taxiPageSteps
                .goToTaxiPage()
                .selectReturnOption();
        Assert.assertEquals(taxiPageSteps.returnRadio.getValue(), selectedState,"Return radio is selected");
        Assert.assertTrue(taxiPageSteps.returnPickupLocation.exists(), "Return search fields appearance check");

    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description("აეროპორტის ტაქსების გვერდზე დაბრუნების შესაძლებლობის არჩევისას ზედა ხაზზშე ჩასხდომის და დანიშნულების ლოკაციის შევსებისას იმის გადამოწმება, რომ ქვედა ხაზზეც დაბრუნების ველებიც შეივსო შესაბამისად")
    public void returnSearchLineAutoFill() {
        taxiPageSteps
                .goToTaxiPage()
                .selectReturnOption()
                .enterPickUpLocation()
                .enterDropOffLocation();
        Assert.assertEquals(taxiPageSteps.returnPickupLocation.getValue(), taxiPageSteps.dropOffLocationField.getValue(),"Return pickup field autofill check");
        Assert.assertEquals(taxiPageSteps.returnDropOffLocation.getValue(), taxiPageSteps.pickUpLocationField.getValue(), "Return pickup field autofill check");
    }
    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("ტაქსების ვარიანტების ძებნა ჩასხდომის და საბოლოო დანიშნულების ველების შევსებით. Show more და Show less ღილაკებზე დაჭერის შედეგად შესაძლო ვარიანტების რაოდენობის ცვლილების გადამოწმება")
    public void showMoreCheck() {
        taxiPageSteps
                .goToTaxiPage()
                .enterPickUpLocation()
                .enterDropOffLocation()
                .clickSearch();
        sleep(5000);
        taxiPageSteps.scrollToShowMore();

        int optNum = taxiPageSteps.taxiOption.size();

        taxiPageSteps
                .clickShowMore();

        int optNumShowMore = taxiPageSteps.taxiOption.size();
        Assert.assertNotEquals(optNum,optNumShowMore,"Show more button reveals more options");

        taxiPageSteps
                .scrollToShowLess()
                .clickShowLess();

        int optNumShowLess = taxiPageSteps.taxiOption.size();
        Assert.assertEquals(optNum,optNumShowLess,"Show less button shows initial number of options");
    }
}
