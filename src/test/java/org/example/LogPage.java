package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogPage {

    private WebDriver driver;
    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов на странице логина
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By chooseProduct = By.xpath("//a[@class=\"product eyesProduct\"]");
    private By errorMessage = By.xpath("//div[@class=\"form-submit-error\"]");
    private By googleButton = By.id("google-signin");



    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(signInButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(chooseProduct).click();
    }
    public String attemptInvalidLogin(String email, String password) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(signInButton).click();
        try {
            Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
        }


        WebElement errorElement = driver.findElement(errorMessage);
        String errorMessageText = errorElement.getText();
        System.out.println("Фактическое сообщение об ошибке: " + errorMessageText);
        return errorMessageText;

    }
    public void clickGoogleButton() {
        driver.findElement(googleButton).click();
    }
}
