package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(id = "accountName")
    private WebElement loginField;

    @FindBy(id = "submit")
    private WebElement loginBtn;

    @FindBy(id = "password")
    private WebElement passwdField;

    @FindBy(xpath = "//button[@id=\"apple\"]")
    private WebElement loginExternal;

    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click();
    }
    public void clickLoginExternal() {
        loginExternal.click();
    }
}







