package assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AutomationPracticeFormAssertions {

    public void checkAutomationPracticeForm(String firstname, String lastName, String email, String gender,
                                     String mobileNumber, String subject, String hobby, String path,
                                     String state, String city, String date, String month, String year){
        $(xpath("//td[text()='Student Name']/following-sibling::td")).shouldHave(text(firstname + " " + lastName));
        $(xpath("//td[text()='Student Email']/following-sibling::td")).shouldHave(text(email));
        $(xpath("//td[text()='Gender']/following-sibling::td")).shouldHave(text(gender));
        $(xpath("//td[text()='Mobile']/following-sibling::td")).shouldHave(text(mobileNumber));
        $(xpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text(date + " " + month +"," + year));
        $(xpath("//td[text()='Subjects']/following-sibling::td")).shouldHave(text(subject));
        $(xpath("//td[text()='Hobbies']/following-sibling::td")).shouldHave(text(hobby));
        $(xpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text(path.substring(6)));
        $(xpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text(state + " " + city));
    }
}
