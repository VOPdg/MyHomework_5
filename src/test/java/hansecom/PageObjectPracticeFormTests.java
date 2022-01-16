package hansecom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObjectPracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    void successTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Veronika");
        registrationPage.typeSecondName("Padgok");
        registrationPage.typeEmail("testForm@mailinator.com");
        registrationPage.chooseGender();
        registrationPage.enterTelNumber("1234543456");
        registrationPage.setBithdayDate("18", "November", "1984");
        registrationPage.typeSubject("Maths");
        registrationPage.chooseHobby();
        registrationPage.addFile("text.txt");
        registrationPage.enterAddress("Minsk, 220117");
        registrationPage.selectState("NCR");
        registrationPage.selectCity("Delhi");
        registrationPage.pressSubmit();
        registrationPage.assertForm();

    }
}
