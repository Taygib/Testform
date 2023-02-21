package testForm;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import pages.RegistrationPageForm;

@Tag("toolsQATest")
public class TestBase  {

    String [] hobbiesName = {"Sports", "Reading", "Music"};
    String [] genderName = {"Male", "Female", "Other"};

    RegistrationPageForm registrationPageForm = new RegistrationPageForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";


    }


}
