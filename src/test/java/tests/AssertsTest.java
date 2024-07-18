package tests;

import pageObjects.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class AssertsTest extends BaseTest {
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        registrationPage = new RegistrationPage(driver);
        driver.get("https://auth.applitools.com/users/general-register");
    }

    @Test
    public void testWithHardAsserts() {
        assertTrue(registrationPage.getFirstNameField().isDisplayed(), "FirstName Field is not displayed");
        assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        assertTrue(registrationPage.getLastNameField().isDisplayed(), "LastName Field is not displayed");
    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(registrationPage.getFirstNameField().isDisplayed(), "Firstname field is not displayed");
        softAssert.assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        softAssert.assertTrue(registrationPage.getLastNameField().isDisplayed(), "Lastname field is not displayed");

        softAssert.assertAll();
    }
}
