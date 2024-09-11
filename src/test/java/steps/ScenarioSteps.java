package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LogPage;
import utils.ConfProperties;
import utils.WebDriverSingleton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ScenarioSteps {
    private LogPage logPage;
    private WebDriver driver;

    @Given("the user navigates to the demo login page")
    public void userNavigatesToDemoLoginPage() {
        driver = WebDriverSingleton.getDriver();
        driver.get(ConfProperties.getAppDemoPage());
        logPage = new LogPage(driver);
    }

    @When("the user enters their credentials")
    public void userEntersLoginPassword() {
        logPage.login(ConfProperties.getLogin(), ConfProperties.getPassword2());
    }

    @When("the user clicks the \"Sign in\" button")
    public void userClicksSigninButton() {
    }

    @Then("the user should see the \"Choose product\" button")
    public void UserSeeChooseProductButton() {
        Assert.assertTrue(logPage.isChooseProductButtonDisplayed(), "Choose product button is not displayed");
    }

    @When("the user chooses the Eyes product")
    public void UserClickschooseEyesProduct() {
        logPage.chooseEyesProduct();
    }

    @Then("the user should see their profile button")
    public void UserSeeProfileMenuButton() {
        assertTrue(logPage.isUserProfileButtonDisplayed(), "User profile button is not displayed");
    }

    @And("the user clicks the profile button")
    public void userClicksProfileButton() {
        logPage.clickUserProfileButton();
    }

    @When("the user clicks the \"Log  out\" button")
    public void UserclickLogOutButton() {
        logPage.clickLogOutButton();
    }

    @Then("the user should see the Authorization page")
    public void UserSeeAuthorizationPage() {
        assertTrue(logPage.isSignInPageTitleDisplayed(), "Название страницы авторизации не отображается");
        assertEquals(logPage.getSignInPageTitleText(), "Sign in", "Пользователь не на странице авторизации");
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
