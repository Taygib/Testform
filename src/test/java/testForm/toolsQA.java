package testForm;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class toolsQA {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
       // Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('.sidebar-content').remove()");
        Selenide.executeJavaScript("$('#fixedban').remove()");

    }

    @Test
    void testForm () {
        String firstName = "T";
        String lastName = "I";
        String month = "May";
        String gender = "Male";

        $("#firstName").setValue(firstName).pressEnter();
        $("#lastName").setValue(lastName).pressEnter();
        $("#userEmail").setValue("autoqa@mail.ru").pressEnter();
        $(".custom-control").find(byText(gender)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").find(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").find(byText("2030")).click();
        $(".react-datepicker__month-container").find(byText("17")).click();
        $("#userNumber").setValue("9655555678").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").val("chemistry").pressEnter();
        $$("#hobbiesWrapper .custom-checkbox").get(2).$("label").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress-wrapper #currentAddress").setValue("EPRST");

        $(byText("Select State")).click();
        $(byText("Uttar Pradesh")).click();
        $(byText("Select City")).click();
        $(byText("Agra")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Label"), text("Values"), text("Student Name"), text("T I"),
                text("Student Email"), text("autoqa@mail.ru"), text("Gender"), text("Male"), text("Mobile"),
                text("9655555678"), text("Date of Birth"), text("17 May,2030"), text("Subjects"), text("Chemistry"),
                text("Hobbies"), text("Music"), text("Picture"), text("1.png"), text("Address"), text("EPRST"),
                text("State and City"), text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();

    }

}
