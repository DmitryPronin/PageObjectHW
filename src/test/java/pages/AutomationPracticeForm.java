package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

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


    public void fillFirstLastName(String firstName, String lastName){
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);

    }

    public void clickGender(String gender){
        $(byText(gender)).click();
    }

    public void fillEmail(String email){
        userEmail.setValue(email);
    }

    public void fillUserNumber(String mobileNumber){
        userNumber.scrollTo().setValue(mobileNumber);
    }

    public void chooseDateOfBirth(String date, String month, String year){
        $(id("dateOfBirthInput")).click();
        $(className("react-datepicker__month-select")).selectOptionContainingText(month);
        $(className("react-datepicker__year-select")).selectOptionContainingText(year);
        $(className("react-datepicker__day--0"+date)).click();
    }

    public void chooseHobby(String hobby) {
        $(byText(hobby)).click();
    }

    public void chooseSubject(String subject) {
        subjectsInput.scrollTo().setValue(subject).pressEnter();
    }

    public void uploadPicture(String classPath) {
        uploadPicture.uploadFromClasspath(classPath);

    }

    public void fillAddressInformation(String address, String state, String city) {
        currentAddress.setValue(address);
        stateInput.click();
        stateCity.$(byText(state)).click();
        cityInput.click();
        stateCity.$(byText(city)).click();
    }
}
