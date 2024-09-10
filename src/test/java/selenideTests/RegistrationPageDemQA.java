package selenideTests;

import com.codeborne.selenide.SelenideElement;
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


    public SelenideElement getFirstNameField() {
        return firstNameField;
    }

    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getGenderRadioButton() {
        return genderRadioButton;
    }

    public SelenideElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public SelenideElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    public SelenideElement getYearSelect() {
        return yearSelect;
    }

    public SelenideElement getMonthSelect() {
        return monthSelect;
    }

    public SelenideElement getDaySelect() {
        return daySelect;
    }

    public SelenideElement getSubjectsInput() {
        return subjectsInput;
    }

    public SelenideElement getHobbiesCheckbox2() {
        return hobbiesCheckbox2;
    }

    public SelenideElement getHobbiesCheckbox3() {
        return hobbiesCheckbox3;
    }

    public SelenideElement getUploadPictureInput() {
        return uploadPictureInput;
    }

    public SelenideElement getCurrentAddressField() {
        return currentAddressField;
    }

    public SelenideElement getStateDropdown() {
        return stateDropdown;
    }

    public SelenideElement getNcrStateOption() {
        return ncrStateOption;
    }

    public SelenideElement getCityDropdown() {
        return cityDropdown;
    }

    public SelenideElement getDelhiCityOption() {
        return delhiCityOption;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getRegistrationProof() {
        return registrationProof;
    }

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
