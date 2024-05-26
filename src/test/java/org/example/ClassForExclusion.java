package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


@Test(enabled = false)
public class ClassForExclusion {
    private WebDriver driver;
    private LogPage logPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://auth.applitools.com/users/login");
        logPage = new LogPage(driver);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        String errorMessage = logPage.attemptInvalidLogin("evinasenla@gmail.com", "invalidPassword123");
        System.out.println("Найдено сообщение об ошибке: " + errorMessage);
        assertEquals(errorMessage, "Incorrect username or password.", "Сообщение об ошибке не соответствует ожидаемому");
    }

    @Test
    public void LoginWithGoogle(){
    logPage.clickGoogleButton();
    }
}
