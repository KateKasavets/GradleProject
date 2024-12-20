package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utils.ConfProperties;

import java.util.concurrent.TimeUnit;


@Epic("Authorization")
@Feature("Parameterized test")
public class ParameterizedTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getChromeDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        driver.get(ConfProperties.getLoginPageUrl());
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {ConfProperties.getLogin(), ConfProperties.getPassword()},
                {ConfProperties.getLogin2(), ConfProperties.getPassword()}
        };
    }

    @Description("Check that profile page title is displayed after authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "loginData")
    public void loginTest(String login, String password) {
        loginPage.login(login, password);
        Assert.assertTrue(loginPage.isPageTitleDisplayed(), "Название страницы не отображается");
        Assert.assertEquals(loginPage.getPageTitleText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
