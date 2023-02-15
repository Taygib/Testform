package testForm;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;


public class ToolsQAPageObjects extends TestBase  {


    @Test
    void testForm() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = random(genderName);;
        String email = faker.internet().emailAddress();
        String year = "2030";
        String day = "17";
        String month = "May";
        String number = "9655555678";
        String subject = "Chemistry";
        String hobbies = random(hobbiesName);
        String loadPicture = "src/test/resources/1.png";
        String address = faker.address().cityName();
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
