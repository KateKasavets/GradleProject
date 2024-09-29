package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LogPage;
import utils.ConfProperties;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class UnsuccessfulLoginSteps {
    private LogPage logPage;
    private String errorMessage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logPage = new LogPage(driver);
    }

    @Given("user navigates to the demo page")
    public void userNavigatesToDemoLoginPage() {
        driver.get(ConfProperties.getAppDemoPage());
    }

    @When("user attempts to log in with email {string} and invalid password {string}")
    public void userAttemptsToLoginWithInvalidPassword(String email, String password) {
        errorMessage = logPage.attemptInvalidLogin(email, password);
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) {
        assertEquals(errorMessage, expectedErrorMessage, "Сообщение об ошибке не соответствует ожидаемому");
    }

    @When("user attempts to log in with invalid email {string} and password {string}")
    public void userAttemptsToLoginWithInvalidEmail(String email, String password) {
        errorMessage = logPage.attemptInvalidLogin(email, password);
    }

    @When("user attempts to log in with invalid email format {string} and password {string}")
    public void userAttemptsToLoginWithInvalidEmailFormat(String email, String password) {
        logPage.login(email, password);
        errorMessage = logPage.getEmailErrMsg();
    }

    @When("user clicks {string} button")
    public void userClicksTryNowButton(String tryNowButton) {
        logPage.signInWithTryNowButton();
    }

    @Then("user should see the registration page")
    public void userShouldSeeRegistrationPage() {
        Assert.assertTrue(logPage.isTryNowButtonDisplayed(), "Кнопка регистрации 'Try now' не отображается");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
