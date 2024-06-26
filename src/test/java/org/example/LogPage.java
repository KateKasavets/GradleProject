package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogPage {

    private WebDriver driver;


    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By chooseProduct = By.xpath("//a[@class='product eyesProduct']");
    private By errorMessage = By.xpath("//div[@class='form-submit-error']");
    private By googleButton = By.id("google-signin");

    private By userProfileButton = By.xpath("//button[@aria-label='User']");
    private By profileMenu = By.xpath("//div[@class='user-name']");
    private By logOutButton = By.xpath("//*[@id='dropdown-1']/div/button[4]/div/span");
    private By signInPageTitle = By.xpath("//h1[@class='title']");

    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
        chooseProduct();
    }

    public String attemptInvalidLogin(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
        return getErrorMessage();
    }

    public void clickGoogleButton() {
        driver.findElement(googleButton).click();
    }


    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    private void chooseProduct() {
        driver.findElement(chooseProduct).click();
    }

    private String getErrorMessage() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.getText();
    }


    public boolean isUserProfileButtonDisplayed() {
        return driver.findElement(userProfileButton).isDisplayed();
    }

    public void clickUserProfileButton() {
        driver.findElement(userProfileButton).click();
    }

    public boolean isProfileMenuDisplayed() {
        return driver.findElement(profileMenu).isDisplayed();
    }

    public String getProfileUserName() {
        return driver.findElement(profileMenu).getText();
    }

    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }

    public boolean isSignInPageTitleDisplayed() {
        return driver.findElement(signInPageTitle).isDisplayed();
    }

    public String getSignInPageTitleText() {
        return driver.findElement(signInPageTitle).getText();
    }
}
