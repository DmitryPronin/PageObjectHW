package guru.qa;

import assertions.AutomationPracticeFormAssertions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AutomationPracticeForm;

import static com.codeborne.selenide.AssertionMode.SOFT;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

@ExtendWith({SoftAssertsExtension.class})
public class HomeWork {

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();
    AutomationPracticeFormAssertions assertions = new AutomationPracticeFormAssertions();
    Faker faker = new Faker();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.assertionMode = SOFT;
    }

    @Test
    @DisplayName("Успешное создание пользователя")
    void forTest(){
        open("/automation-practice-form");
        String firstname = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String mobileNumber = "9274454680";
        String address = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";
        String subject = "Math";
        String gender = "Male";
        String hobby = "Sports";
        String path = "files/picture.jpeg";

        automationPracticeForm.fillFirstLastName(firstname, lastName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.fillUserNumber(mobileNumber);
        automationPracticeForm.clickGender(gender);
        automationPracticeForm.chooseDateOfBirth("27", "February", "1988");
        automationPracticeForm.chooseHobby(hobby);
        automationPracticeForm.chooseSubject(subject);
        automationPracticeForm.uploadPicture(path);
        automationPracticeForm.fillAddressInformation(address, state, city);
        $(id("submit")).click();

        assertions.checkAutomationPracticeForm(firstname, lastName, email, gender,
                mobileNumber, subject, hobby, path, state, city, "27", "February", "1988");
    }
}
