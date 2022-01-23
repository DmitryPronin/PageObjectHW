package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AutomationPracticeForm;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static testdata.UserData.*;

@ExtendWith({SoftAssertsExtension.class})
public class AutomationPracticeFormTest {

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.assertionMode = SOFT;
    }

    @Test
    @DisplayName("Успешное создание пользователя")
    void forTest(){
        automationPracticeForm
                .openPage()
                .fillFirstName(firstname)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillUserNumber(mobileNumber)
                .clickGender(gender)
                .chooseDateOfBirth("27", "February", "1988")
                .chooseHobby(hobby)
                .chooseSubject(subject)
                .uploadPicture(path)
                .fillAddressInformation(address, state, city)
                .submit();

        automationPracticeForm
                .checkAutomationPracticeForm("Student Name", firstname + " " + lastName)
                .checkAutomationPracticeForm("Student Email", email)
                .checkAutomationPracticeForm("Gender", gender)
                .checkAutomationPracticeForm("Mobile", mobileNumber)
                .checkAutomationPracticeForm("Date of Birth", "27 February,1988")
                .checkAutomationPracticeForm("Subjects", subject)
                .checkAutomationPracticeForm("Hobbies", hobby)
                .checkAutomationPracticeForm("Picture", path.substring(6))
                .checkAutomationPracticeForm("State and City", state + " " + city);
    }
}
