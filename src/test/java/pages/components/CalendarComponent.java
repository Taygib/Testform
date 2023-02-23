package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    public void setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").find(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").find(byText(year)).click();
        $(".react-datepicker__month-container").find(byText(day)).click();
    }
}
