package selenideTests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageDemQA {

    public SelenideElement firstNameField = $("#firstName");
    public SelenideElement lastNameField = $("#lastName");
    public SelenideElement emailField = $("#userEmail");
    public SelenideElement genderRadioButton = $x("//label[@for='gender-radio-1']");
    public SelenideElement phoneNumberField = $("#userNumber");
    public SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public SelenideElement yearSelect = $(".react-datepicker__year-select");
    public SelenideElement monthSelect = $(".react-datepicker__month-select");
    public SelenideElement daySelect = $(".react-datepicker__day.react-datepicker__day--013");
    public SelenideElement subjectsInput = $("#subjectsInput");
    public SelenideElement hobbiesCheckbox2 = $x("//label[@for='hobbies-checkbox-2']");
    public SelenideElement hobbiesCheckbox3 = $x("//label[@for='hobbies-checkbox-3']");
    public SelenideElement uploadPictureInput = $("#uploadPicture");
    public SelenideElement currentAddressField = $("#currentAddress");
    public SelenideElement stateDropdown = $("#state .indicatorContainer");
    public SelenideElement ncrStateOption = $x("//div[@id='stateCity-wrapper']//div[contains(text(),'NCR')]");
    public SelenideElement cityDropdown = $("#city .indicatorContainer");
    public SelenideElement delhiCityOption = $x("//div[@id='stateCity-wrapper']//div[contains(text(),'Delhi')]");
    public SelenideElement submitButton = $("#submit");
    public SelenideElement registrationProof = $("#example-modal-sizes-title-lg");

    public void selectDay() {
        daySelect.scrollTo().click();
    }

    public void selectSubject(String subject) {
        subjectsInput.setValue(subject);
        $x("//div[contains(@class, 'subjects-auto-complete__option') and contains(text(), '" + subject + "')]")
                .shouldBe(visible)
                .click();
    }
}
