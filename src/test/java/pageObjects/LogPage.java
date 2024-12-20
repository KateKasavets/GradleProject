package pageObjects;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//div[@id=\"email-err-msg\"]")
    private WebElement emailErrMsg;

    public LogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Enter email /password and click SignIn btn")
    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
    }

    @Step("Enter invalid email or password")
    public String attemptInvalidLogin(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickSignInButton();
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessage, "Incorrect username or password."));
        return getErrorMessage();
    }

    @Step("Click on TryNowButton")
    public void signInWithTryNowButton() {
        tryNowButton.click();
    }

    @Step("Check that TryNowButtonDisplayed")
    public boolean isTryNowButtonDisplayed() {
        return tryNowButton.isDisplayed();
    }

    public void chooseEyesProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseEyesProduct)).click();
    }

    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    @Step("Click on SignIn button")
    private void clickSignInButton() {
        signInButton.click();
    }

    @Step("Get error message after unsuccessful login")
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getEmailErrMsg(){
        return emailErrMsg.getText();
    }

    @Step("Check that UserProfileDisplayed")
    public boolean isUserProfileButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userProfileButton)).isDisplayed();
    }

    @Step("Click on UserProfileButton")
    public void clickUserProfileButton() {
        userProfileButton.click();
    }

    @Step("Check  profile menu")
    public boolean isProfileMenuDisplayed() {
        return profileMenu.isDisplayed();
    }

    @Step("Get UserName")
    public String getProfileUserName() {
        return profileMenu.getText();
    }

    @Step("Click on LogOut Button")
    public void clickLogOutButton() {
        logOutButton.click();
    }

    @Step("Check Sign in page")
    public boolean isSignInPageTitleDisplayed(){
            return signInPageTitle.isDisplayed();
        }

    @Step("Get Title from SignIn page")
    public String getSignInPageTitleText() {
        return signInPageTitle.getText();
    }

    @Step("Check that ProductButton is displayed")
    public boolean isChooseProductButtonDisplayed() {
        return chooseEyesProduct.isDisplayed();
    }
}
