package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AutomationPracticeForm;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static testdata.UserData.*;

@ExtendWith({SoftAssertsExtension.class})
public class AutomationPracticeFormTest {

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();

    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.assertionMode = SOFT;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";



        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        helpers.Attach.screenshotAs("Last screenshot");
        helpers.Attach.pageSource();
        helpers.Attach.browserConsoleLogs();
        helpers.Attach.addVideo();
        closeWebDriver();
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
//                .uploadPicture(path)
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
//                .checkAutomationPracticeForm("Picture", path.substring(6))
                .checkAutomationPracticeForm("State and City", state + " " + city);
    }
}
