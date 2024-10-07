package selenideTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.WebDriverRunner;
import utils.ConfProperties;
import utils.WebDriverSingleton;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class RegistrationDemQATests {

    private RegistrationPageDemQA registrationPageDemQA;

    @BeforeMethod
    public void setUp() {

        WebDriverRunner.setWebDriver(WebDriverSingleton.getDriver());
        registrationPageDemQA = new RegistrationPageDemQA();
    }

    @Test
    public void RegistrationTests() {
        open(ConfProperties.getDemoQaPage());

        registrationPageDemQA.firstNameField.setValue("John");
        registrationPageDemQA.lastNameField.setValue("Johnovich");
        registrationPageDemQA.emailField.setValue("john@hmail.con");
        registrationPageDemQA.genderRadioButton.click();
        registrationPageDemQA.phoneNumberField.setValue("1212121212");
        registrationPageDemQA.dateOfBirthInput.click();
        registrationPageDemQA.yearSelect.selectOption("1970");
        registrationPageDemQA.monthSelect.selectOption("June");
        registrationPageDemQA.selectDay();
        registrationPageDemQA.selectSubject("Math");
        registrationPageDemQA.subjectsInput.click();
        registrationPageDemQA.hobbiesCheckbox2.click();
        registrationPageDemQA.hobbiesCheckbox3.click();
        registrationPageDemQA.uploadPictureInput.uploadFile(new File("C:\\Users\\ВИТАЛЬ\\Pictures\\tomato.jpg"));
        registrationPageDemQA.currentAddressField.setValue("Gomel");
        registrationPageDemQA.stateDropdown.click();
        registrationPageDemQA.ncrStateOption.click();
        registrationPageDemQA.cityDropdown.click();
        registrationPageDemQA.delhiCityOption.click();
        registrationPageDemQA.submitButton.click();


        String registrationProofText = registrationPageDemQA.registrationProof.getText();
        assertTrue(registrationProofText.contains("Thanks for submitting the form"), "Регистрация не прошла успешно.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
