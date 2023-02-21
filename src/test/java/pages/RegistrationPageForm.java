package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPageForm {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String titleText = "Student Registration Form";

    public RegistrationPageForm openPage() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('.sidebar-content').remove()");
        Selenide.executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPageForm setFirstName(String value) {
        $("#firstName").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageForm setLastName(String value) {
        $("#lastName").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageForm setEmail(String value) {
        $("#userEmail").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageForm setGender(String value) {
        $("#genterWrapper").find(byText(value)).click();

        return this;
    }

    public RegistrationPageForm setNumber(String value) {
        $("#userNumber").setValue(value).click();

        return this;
    }

    public RegistrationPageForm setBirthday(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPageForm setSubject(String value) {
        $("#subjectsContainer").click();
        $("#subjectsInput").val(value).pressEnter();

        return this;
    }
    public RegistrationPageForm setHobbies(String value) {
        $("#hobbiesWrapper").find(byText(value)).click();

        return this;
    }
    public RegistrationPageForm setLoadPicture(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }
    public RegistrationPageForm setAddress(String value) {
        $("#currentAddress-wrapper #currentAddress").setValue(value);

        return this;
    }
    public RegistrationPageForm setState(String value) {
        $(byText("Select State")).click();
        $(byText(value)).click();

        return this;
    }
    public RegistrationPageForm setCity(String value) {
        $(byText("Select City")).click();
        $(byText(value)).click();

        return this;
    }
    public RegistrationPageForm submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPageForm verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPageForm verifyResult(String label, String values) {
        registrationResultsModal.verifyResult(label, values);

        return this;
    }

    public RegistrationPageForm close() {
        registrationResultsModal.close();

        return this;
    }


}
