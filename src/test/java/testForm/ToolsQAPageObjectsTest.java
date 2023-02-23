package testForm;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static utils.RandomUtils.*;

@Tag("toolsQATest")
public class ToolsQAPageObjectsTest extends TestBase {

    @Test
    void formTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                gender = random(genderName),
                email = faker.internet().emailAddress(),
                year = "2030",
                day = "17",
                month = "May",
                number = "9655555678",
                subject = "Chemistry",
                hobbies = random(hobbiesName),
                loadPicture = "src/test/resources/1.png",
                address = faker.address().cityName(),
                state = "Uttar Pradesh",
                city = "Agra";

        step("Открыть страницу", () -> {
            registrationPageForm.openPage();
        });

        step("Заполнение формы", () -> {

            step("Ввод в поле FirstName", () -> {
                registrationPageForm.setFirstName(firstName);
            });

            step("Ввод в поле LastName", () -> {
                registrationPageForm.setLastName(lastName);
            });

            step("Ввод в поле Email", () -> {
                registrationPageForm.setEmail(email);
            });

            step("Указать какой  Gender", () -> {
                registrationPageForm.setGender(gender);
            });

            step("Ввод в поле Mobile Number", () -> {
                registrationPageForm.setNumber(number);
            });

            step("Ввод в поле Birthday", () -> {
                registrationPageForm.setBirthday(day, month, year);
            });

            step("Ввод в поле Subject", () -> {
                registrationPageForm.setSubject(subject);
            });

            step("Ввод в поле Birthday", () -> {
                registrationPageForm.setHobbies(hobbies);
            });

            step("Ввод в поле LoadPicture", () -> {
                registrationPageForm.setLoadPicture(loadPicture);
            });

            step("Ввод в поле Address", () -> {
                registrationPageForm.setAddress(address);
            });

            step("Указать какой State", () -> {
                registrationPageForm.setState(state);
            });

            step("Указать какой City", () -> {
                registrationPageForm.setCity(city);
            });
        });

        step("Кнопка подтверждения submit", () -> {
            registrationPageForm.submit();
        });

        step("Проверка заполнение формы в всплывающем окне после submit", () -> {

            step("Проверка всплывающего окна", () -> {
                registrationPageForm.verifyResultModalAppears();
            });

            step("Проверка Student Name: FirstName и LastName", () -> {
                registrationPageForm.verifyResult("Student Name", firstName + " " + lastName);
            });

            step("Проверка Student Email", () -> {
                registrationPageForm.verifyResult("Student Email", email);
            });

            step("Проверка Gender", () -> {
                registrationPageForm.verifyResult("Gender", gender);
            });

            step("Проверка Mobile", () -> {
                registrationPageForm.verifyResult("Mobile", number);
            });

            step("Проверка Date of Birth", () -> {
                registrationPageForm.verifyResult("Date of Birth", day + " " + month + "," + year);
            });

            step("Проверка Subjects", () -> {
                registrationPageForm.verifyResult("Subjects", subject);
            });

            step("Проверка Hobbies", () -> {
                registrationPageForm.verifyResult("Hobbies", hobbies);
            });

            step("Проверка Picture", () -> {
                registrationPageForm.verifyResult("Picture", "1.png");
            });

            step("Проверка Address", () -> {
                registrationPageForm.verifyResult("Address", address);
            });

            step("Проверка State and City", () -> {
                registrationPageForm.verifyResult("State and City", state + " " + city);
            });
        });

        step("Закрыть всплывающее окно формы", () -> {
            registrationPageForm.close();
        });
    }
}