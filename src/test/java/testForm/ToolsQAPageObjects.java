package testForm;

import org.junit.jupiter.api.Test;


public class ToolsQAPageObjects extends TestBase {


    @Test
    void testForm() {
        String firstName = "T";
        String lastName = "I";
        String gender = "Male";
        String email = "autoqa@mail.ru";
        String year = "2030";
        String day = "17";
        String month = "May";
        String number = "9655555678";
        String subject = "Chemistry";
        String hobbies = "Music";
        String loadPicture = "src/test/resources/1.png";
        String address = "EPRST";
        String state = "Uttar Pradesh";
        String city = "Agra";

        registrationPageForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthday(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setLoadPicture(loadPicture)
                .setAddress(address)
                .setState(state)
                .setCity(city);

        registrationPageForm.submit();

        registrationPageForm.verifyResultModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        registrationPageForm.close();


    }

}
