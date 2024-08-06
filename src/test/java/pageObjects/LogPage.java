package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='product eyesProduct']")
    private WebElement chooseEyesProduct;

    @FindBy(xpath = "//div[@class='form-submit-error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@class='link']")
    private WebElement tryNowButton;

    @FindBy(xpath = "//button[@aria-label='User']")
    private WebElement userProfileButton;

    @FindBy(xpath = "//div[@class='user-name']")
    private WebElement profileMenu;

    @FindBy(xpath = "//span[@class='menu-item-text' and text()='Log out']")
    private WebElement logOutButton;

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement signInPageTitle;

    public LogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
    }

    public String attemptInvalidLogin(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
        return getErrorMessage();
    }

    public void signInWithTryNowButton() {
        tryNowButton.click();
    }

    public void chooseEyesProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseEyesProduct)).click();
    }

    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    private void clickSignInButton() {
        signInButton.click();
    }

    private String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isUserProfileButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userProfileButton)).isDisplayed();
    }

    public void clickUserProfileButton() {
        userProfileButton.click();
    }

    public boolean isProfileMenuDisplayed() {
        return profileMenu.isDisplayed();
    }

    public String getProfileUserName() {
        return profileMenu.getText();
    }

    public void clickLogOutButton() {
            logOutButton.click();
    }

    public boolean isSignInPageTitleDisplayed() {
        return signInPageTitle.isDisplayed();
    }

    public String getSignInPageTitleText() {
        return signInPageTitle.getText();
    }

    public boolean isChooseProductButtonDisplayed() {
        return chooseEyesProduct.isDisplayed();
    }
}
