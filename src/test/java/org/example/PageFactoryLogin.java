package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLogin {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath ="//a[@class=\"product eyesProduct\"]" )
    private WebElement chooseProduct;

    public PageFactoryLogin(WebDriver driver) {
        this.driver = driver;
        // Инициализация элементов с использованием Page Factory
        PageFactory.initElements(driver, this);
    }

    // Методы взаимодействия с элементами страницы
    public void enterUsername(String username) {
        emailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignButton() {
        signInButton.click();
    }

    public void clickChooseProductButton() {
        chooseProduct.click();
    }
}
