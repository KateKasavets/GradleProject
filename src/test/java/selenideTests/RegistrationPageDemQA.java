package selenideTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageDemQA {

    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement emailField = $("#userEmail");
    private SelenideElement genderRadioButton = $x("//label[@for='gender-radio-1']");
    private SelenideElement phoneNumberField = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement daySelect = $(".react-datepicker__day.react-datepicker__day--013");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckbox2 = $x("//label[@for='hobbies-checkbox-2']");
    private SelenideElement hobbiesCheckbox3 = $x("//label[@for='hobbies-checkbox-3']");
    private SelenideElement uploadPictureInput = $("#uploadPicture");
    private SelenideElement currentAddressField = $("#currentAddress");
    private SelenideElement stateDropdown = $("#state");
    private SelenideElement ncrStateOption = $x("//div[@id='stateCity-wrapper']//div[contains(text(),'NCR')]");
    private SelenideElement cityDropdown = $("#city");
    private SelenideElement delhiCityOption = $x("//div[@id='stateCity-wrapper']//div[contains(text(),'Delhi')]");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement registrationProof = $("#example-modal-sizes-title-lg");


    @Step("Get first name field")
    public SelenideElement getFirstNameField() {
        return firstNameField;
    }

    @Step("Get last name field")
    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    @Step("Get email field")
    public SelenideElement getEmailField() {
        return emailField;
    }

    @Step("Get gender radio button")
    public SelenideElement getGenderRadioButton() {
        return genderRadioButton;
    }

    @Step("Get phone number field")
    public SelenideElement getPhoneNumberField() {
        return phoneNumberField;
    }

    @Step("Get date of birth input")
    public SelenideElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    @Step("Get year select")
    public SelenideElement getYearSelect() {
        return yearSelect;
    }

    @Step("Get month select")
    public SelenideElement getMonthSelect() {
        return monthSelect;
    }

    @Step("Get day select")
    public SelenideElement getDaySelect() {
        return daySelect;
    }

    @Step("Get subjects input")
    public SelenideElement getSubjectsInput() {
        return subjectsInput;
    }

    @Step("Get hobbies checkbox 2")
    public SelenideElement getHobbiesCheckbox2() {
        return hobbiesCheckbox2;
    }

    @Step("Get hobbies checkbox 3")
    public SelenideElement getHobbiesCheckbox3() {
        return hobbiesCheckbox3;
    }


    @Step("Get upload picture input")
    public SelenideElement getUploadPictureInput() {
        return uploadPictureInput;
    }

    @Step("Get current address field")
    public SelenideElement getCurrentAddressField() {
        return currentAddressField;
    }

    @Step("Get state dropdown")
    public SelenideElement getStateDropdown() {
        return stateDropdown;
    }


    @Step("Get NCR state option")
    public SelenideElement getNcrStateOption() {
        return ncrStateOption;
    }

    @Step("Get city dropdown")
    public SelenideElement getCityDropdown() {
        return cityDropdown;
    }

    @Step("Get  city option")
    public SelenideElement getDelhiCityOption() {
        return delhiCityOption;
    }

    @Step("Get submit button")
    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    @Step("Get registration proof")
    public SelenideElement getRegistrationProof() {
        return registrationProof;
    }

    @Step("Select day of birth")
    public void selectDay() {
        daySelect.scrollTo().click();
    }

    @Step("Select subject")
    public void selectSubject(String subject) {
        subjectsInput.setValue(subject);
        $x("//div[contains(@class, 'subjects-auto-complete__option') and contains(text(), '" + subject + "')]")
                .shouldBe(visible)
                .click();
    }
}
