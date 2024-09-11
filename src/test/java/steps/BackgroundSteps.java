package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LogPage;
import utils.ConfProperties;
import utils.WebDriverSingleton;
import static org.testng.Assert.assertEquals;

public class BackgroundSteps {
    private LogPage logPage = new LogPage(WebDriverSingleton.getDriver());
    private String errorMessage;


    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {
        WebDriverSingleton.getDriver().get(ConfProperties.getAppDemoPage());
    }
    @When("the user attempts to login with invalid password")
    public void userEntersInvalidPassword(){
         errorMessage = logPage.attemptInvalidLogin("valid_email@example.com", "invalidPassword123");
    }

    @Then("the user should see an error message \"Incorrect username or password.\"")
    public void userShouldSeeErrorMessage(){
        assertEquals(errorMessage, "Incorrect username or password.", "Сообщение об ошибке не соответствует ожидаемому");
    }
    @When("the user clicks \"Try now\" button")
    public void userClicksTryNowButton(){
        logPage.signInWithTryNowButton();
    }
    @Then("the user should see the registration page")
    public void userShouldSeeRegistrationPage(){
        Assert.assertTrue(logPage.isTryNowButtonDisplayed(), "Кнопка Sign in не найдена или не видима на странице.");
    }

}
