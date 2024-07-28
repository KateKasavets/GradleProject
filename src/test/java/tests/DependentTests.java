package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LogPage;
import utils.ConfProperties;
import utils.WebDriverSingleton;

import static org.testng.Assert.assertTrue;

public class DependentTests extends BaseTest {
    private LogPage logPage;


    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getAppDemoPage());
        logPage = new LogPage(driver);
    }


    @Test
    public void loginTest() {
        logPage.login(ConfProperties.getLogin(), ConfProperties.getPassword2());
        assertTrue(logPage.isChooseProductButtonDisplayed(), "Choose product button is not displayed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void chooseEyesProduct() {
        logPage.chooseEyesProduct();
        assertTrue(logPage.isUserProfileButtonDisplayed(), "User profile button is not displayed");
    }

    @Test(dependsOnMethods = "chooseEyesProduct")
    public void navigateToProfileMenu() {
        logPage.clickUserProfileButton();
        assertTrue(logPage.isProfileMenuDisplayed(), "Profile menu did not display after clicking user profile button");
        Assert.assertEquals(logPage.getProfileUserName(), "Eva Evina", "Имя не соответствует ожидаемому");
    }

    @Test(dependsOnMethods = "navigateToProfileMenu")
    public void logOutTest() {
        logPage.clickLogOutButton();
        assertTrue(logPage.isSignInPageTitleDisplayed(), "Название страницы авторизации не отображается");
        Assert.assertEquals(logPage.getSignInPageTitleText(), "Sign in", "Пользователь не на странице авторизации");
    }
}
