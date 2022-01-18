package hansecom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FakerPracticeFormTests {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           email = faker.internet().emailAddress(),
           phone = "1234543456",
           uploadPhoto = "text.txt",
           address = String.valueOf(faker.address());




    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
       // $("#gender-radio-3").doubleClick();// bad variant
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--018").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for= hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath(uploadPhoto);
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        SelenideElement table = $(".modal-body").$("table").$("tbody");
        Assertions.assertEquals( firstName+" "+lastName, table.$("tr:nth-child(1)").$("td:nth-child(2)").getText());
        Assertions.assertEquals(email, table.$("tr:nth-child(2)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Female", table.$("tr:nth-child(3)").$("td:nth-child(2)").getText());
        Assertions.assertEquals(phone, table.$("tr:nth-child(4)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("18 November,1984", table.$("tr:nth-child(5)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Maths", table.$("tr:nth-child(6)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Reading", table.$("tr:nth-child(7)").$("td:nth-child(2)").getText());
        Assertions.assertEquals(uploadPhoto, table.$("tr:nth-child(8)").$("td:nth-child(2)").getText());
        Assertions.assertEquals(address, table.$("tr:nth-child(9)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("NCR Delhi", table.$("tr:nth-child(10)").$("td:nth-child(2)").getText());
        // Assertions.assertEquals("Veronika Padgok", $x("//*[@class=\"modal-body\"]//table/tbody/tr[1]/td[last()]").text());

    }
}
