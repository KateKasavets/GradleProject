package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private WebDriver driver;
    private By firstNameField = By.xpath("//input[@id='first-name']");
    private By ageField = By.xpath("//input[@id='age']");
    private By lastNameField = By.xpath("//input[@id='last-name']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public WebElement getAgeField() {
        return driver.findElement(ageField);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
