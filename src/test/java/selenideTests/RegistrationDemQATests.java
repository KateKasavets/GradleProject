package selenideTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfProperties;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@Epic("Registration")
@Feature("Successful registration")
public class RegistrationDemQATests {

    private RegistrationPageDemQA registrationPageDemQA;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.headless = true;
        registrationPageDemQA = new RegistrationPageDemQA();
    }

    @Description("Check successful registration with Selenide")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void RegistrationTests() {
        open(ConfProperties.getDemoQaPage());

        registrationPageDemQA.getFirstNameField().setValue("John");
        registrationPageDemQA.getLastNameField().setValue("Johnovich");
        registrationPageDemQA.getEmailField().setValue("john@hmail.con");
        registrationPageDemQA.getGenderRadioButton().click();
        registrationPageDemQA.getPhoneNumberField().setValue("1212121212");
        registrationPageDemQA.getDateOfBirthInput().click();
        registrationPageDemQA.getYearSelect().selectOption("1970");
        registrationPageDemQA.getMonthSelect().selectOption("June");
        registrationPageDemQA.selectDay();
        registrationPageDemQA.selectSubject("Math");
        registrationPageDemQA.getSubjectsInput().click();
        registrationPageDemQA.getHobbiesCheckbox2().click();
        registrationPageDemQA.getHobbiesCheckbox3().click();
        registrationPageDemQA.getUploadPictureInput().uploadFile(new File("src/test/resources/images/tomato.jpg"));
        registrationPageDemQA.getCurrentAddressField().setValue("Gomel");
        registrationPageDemQA.getStateDropdown().click();
        registrationPageDemQA.getNcrStateOption().click();
        registrationPageDemQA.getCityDropdown().click();
        registrationPageDemQA.getDelhiCityOption().click();
        registrationPageDemQA.getSubmitButton().click();

        registrationPageDemQA.getRegistrationProof().shouldHave(text("Thanks for submitting the form"));
    }
}
