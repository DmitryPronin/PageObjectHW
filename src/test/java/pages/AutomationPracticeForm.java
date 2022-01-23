package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class AutomationPracticeForm {

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement userNumber = $("#userNumber");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement uploadPicture = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement stateCity = $("#stateCity-wrapper");
    SelenideElement cityInput = $("#city");
    SelenideElement resultsTable = $(".table-responsive");


    public AutomationPracticeForm fillFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    public AutomationPracticeForm fillLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public AutomationPracticeForm clickGender(String gender){
        $(byText(gender)).click();
        return this;
    }

    public AutomationPracticeForm fillEmail(String email){
        userEmail.setValue(email);
        return this;
    }

    public AutomationPracticeForm fillUserNumber(String mobileNumber){
        userNumber.scrollTo().setValue(mobileNumber);
        return this;
    }

    public AutomationPracticeForm chooseDateOfBirth(String date, String month, String year){
        $(id("dateOfBirthInput")).click();
        $(className("react-datepicker__month-select")).selectOptionContainingText(month);
        $(className("react-datepicker__year-select")).selectOptionContainingText(year);
        $(className("react-datepicker__day--0"+date)).click();
        return this;
    }

    public AutomationPracticeForm chooseHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public AutomationPracticeForm chooseSubject(String subject) {
        subjectsInput.scrollTo().setValue(subject).pressEnter();
        return this;
    }

    public AutomationPracticeForm uploadPicture(String classPath) {
        uploadPicture.uploadFromClasspath(classPath);
        return this;
    }

    public AutomationPracticeForm fillAddressInformation(String address, String state, String city) {
        currentAddress.setValue(address);
        stateInput.click();
        stateCity.$(byText(state)).click();
        cityInput.click();
        stateCity.$(byText(city)).click();
        return this;
    }

    public AutomationPracticeForm submit() {
        $(("#submit")).click();
        return this;
    }

    public AutomationPracticeForm checkAutomationPracticeForm(String key, String value){
        resultsTable.shouldHave(text(key)).parent().shouldHave(text(value));
        return this;
    }

    public AutomationPracticeForm openPage() {
        open("/automation-practice-form");
        return this;
    }
}
