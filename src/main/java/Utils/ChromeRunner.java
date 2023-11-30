package Utils;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class ChromeRunner {
    @BeforeMethod(description = "ბრაუზერის კონფიგურაცია ტესტების გაშვებამდე")
    public void setUp(){
        open("https://www.booking.com/");
        sleep(3000);
        if ($(".f4552b6561").exists()){
            $(".f4552b6561").click();}; //close pop-up

    }

    @AfterMethod(description = "ბრაუზერის კონფიგურაცია ტესტების დასრულების შემდეგ")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
