package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getAgeField() {
        return ageField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
