package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverSingleton;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
