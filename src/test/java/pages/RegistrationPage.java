package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement secondNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#gender-radio-2").parent();
    SelenideElement telNumberInput = $("#userNumber");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbyCheckBox = $("[for= hobbies-checkbox-2]");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement addressTextArea = $("#currentAddress");
    SelenideElement stateDropdown = $("#state");
    SelenideElement cityDropdown = $("#city");
    SelenideElement submitPress = $("#submit");
    SelenideElement table = $(".modal-body").$("table").$("tbody");
    //создали объект с переменными

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;

    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeSecondName(String value) {
        secondNameInput.setValue(value);
        return this;
    }

    // создали универсальный метод, где решаем, что и как передать
    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender() {
        genderRadioButton.click();
        return this;
    }

    public RegistrationPage enterTelNumber(String value) {
        telNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setBithdayDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage chooseHobby() {
        hobbyCheckBox.click();
        return this;
    }

    public RegistrationPage addFile(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage enterAddress(String value) {
        addressTextArea.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateDropdown.scrollTo().click();
        stateDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityDropdown.click();
        cityDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
        submitPress.click();
        return this;
    }

    public RegistrationPage assertForm() {
        Assertions.assertEquals("Veronika Padgok", table.$("tr:nth-child(1)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("testForm@mailinator.com", table.$("tr:nth-child(2)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Female", table.$("tr:nth-child(3)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("1234543456", table.$("tr:nth-child(4)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("18 November,1984", table.$("tr:nth-child(5)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Maths", table.$("tr:nth-child(6)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Reading", table.$("tr:nth-child(7)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("text.txt", table.$("tr:nth-child(8)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Minsk, 220117", table.$("tr:nth-child(9)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("NCR Delhi", table.$("tr:nth-child(10)").$("td:nth-child(2)").getText());
        return this;
    }
}
