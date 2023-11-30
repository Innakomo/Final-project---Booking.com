import StepObject.StaySearchPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.StaySearchPageData.searchInput;
import static DataObject.StaySearchPageData.searchInput2;

public class StaySearchPageTests extends ChromeRunner {
    StaySearchPageSteps searchPageSteps = new StaySearchPageSteps();


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("ვახორციელებთ ძებლას ლოკაციის და თარიღების მითითებით და ვამოწმებთ, რომ ძებნის შედეგებში ყველგან წერია შესაბამისი ლოკაცია")
    public void searchCheck(){
        searchPageSteps
                .insertLocation(searchInput)
                .openCalendar()
                .selectFromDate()
                .selectDurationOption()
                .searchForResult();
        Assert.assertEquals(searchPageSteps.propertyAddress.getText(), searchInput, "Comparing search location to the property address");
    }
    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("ვამოწმებთ ლოკაციის ველის ვალიდაციას")
    public void searchCheckEmptyLocation(){
        searchPageSteps
                .searchForResult();
        Assert.assertTrue(searchPageSteps.locationValidation.exists(), "Validation message appearance");
    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("ვაწარმოებთ ძებნას ლოკაციის და თარიღების მიხედვით, ვალაგებთ ფასის მატების მიხედვით და ვამოწმებთ რომ ფასები იზრდება ზემოდან ქვემოთ")
    public void sortingCheck(){
        searchPageSteps
                .insertLocation(searchInput)
                .openCalendar()
                .selectFromDate()
                .selectDurationOption()
                .searchForResult()
                .openSortingOptions()
                .selectOpt_LowerPriceAsc()
                .orderCheck_Asc();

        Assert.assertTrue(searchPageSteps.orderCheck_Asc(), "Checking the prices have ascending order");
    }
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("ვახორციელებთ ძებნას ლოკაციის და თარიღების მიხედვით, ვფილტრავთ 1კმ დისტანციის მიხედვით, ვამოწმებთ რომ შედეგების რაოდენობა შეიცვალა")
    public void filterCheck(){
        searchPageSteps
                .insertLocation(searchInput2)
                .openCalendar()
                .selectFromDate()
                .selectDurationOption()
                .searchForResult()
                .selectFilterOpt_Distance_1km();

            String[] propAmountBeforeFilter = searchPageSteps.propAmountBeforeFilter.getText().split(" ", 4);
            int propAmountBeforeFilter1 = Integer.valueOf(propAmountBeforeFilter[1]);
            String[] propAmountAfFilter = searchPageSteps.propAmountAfterFilter.getText().split(" ", 4);
            int propAmountAfterFilter1 = Integer.valueOf(propAmountAfFilter[1]);

        Assert.assertNotEquals(propAmountAfterFilter1==propAmountBeforeFilter1, "Checking property amounts before and after applying filter");

    }
}
