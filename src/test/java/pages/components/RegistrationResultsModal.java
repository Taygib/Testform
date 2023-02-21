package pages.components;

import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Tag("toolsQATest")
public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void verifyResult(String label, String values) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(values));


    }
    public void close() {
        $("#closeLargeModal").click();
    }


}
