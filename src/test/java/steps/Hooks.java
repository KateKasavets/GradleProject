package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LogPage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class Hooks {
    protected static WebDriver driver;
    protected static LogPage logPage;
    protected static LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        logPage = new LogPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
