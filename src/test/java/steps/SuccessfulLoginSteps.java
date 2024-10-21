package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;


public class SuccessfulLoginSteps extends BaseSteps{
    private  LoginPage loginPage;

    public SuccessfulLoginSteps(){
        super(Hooks.driver);
        this.loginPage = new LoginPage(driver);
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
}
