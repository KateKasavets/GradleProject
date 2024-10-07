package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.ConfProperties;
import java.util.concurrent.TimeUnit;

public class SuccessfulLoginSteps {
    private LoginPage loginPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getChromeDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Given("user navigates to {string}")
    public void userNavigatesToPage(String url) {
        driver.get(url);
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String login, String password) {
        loginPage.login(login, password);
    }

    @Then("user should see title {string}")
    public void userSeePageTitle(String expectedTitle) {
        Assert.assertEquals(loginPage.getPageTitleText(), expectedTitle, "The page title does not match");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
