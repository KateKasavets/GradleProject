package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "accountName")
    private WebElement loginField;

    @FindBy(id = "submit")
    private WebElement loginBtn;

    @FindBy(id = "password")
    private WebElement passwdField;

    @FindBy(xpath = "//button[@id='apple']")
    private WebElement loginExternal;

    @FindBy(xpath = "//*[@class='title']")
    private WebElement pageTitle;

    @FindBy(id = "login-header")
    private WebElement loginHeader;

    @FindBy(xpath = "//div[@id='signin']/app-title")
    private WebElement loginWithAppleTitle;

    @FindBy(xpath = "//span[@class='error-helper error-helper-accountName status-warning']")
    private WebElement errorMessage;

    @Step("Enter email")
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("Enter password")
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    @Step("Click Login button")
    public void clickLoginBtn() {
        loginBtn.click();
    }

    @Step("Click Login with External")
    public void clickLoginExternal() {
        loginExternal.click();
    }

    @Step("Check that Page Title is Displayed")
    public boolean isPageTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    @Step("Get Page Title text")
    public String getPageTitleText() {
        return pageTitle.getText();
    }

    @Step("Get Text from LoginPage")
    public String getLoginHeaderText() {
        return loginHeader.getText();
    }

    @Step("Get text from LoginWithApple")
    public String getLoginWithAppleTitleText() {
        return loginWithAppleTitle.getText();
    }

    @Step("Get text from error message")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Step("Enter login and password and click Login button")
    public void login(String login, String password) {
        inputLogin(login);
        inputPasswd(password);
        clickLoginBtn();
    }
}
