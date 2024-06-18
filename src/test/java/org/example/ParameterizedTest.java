package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ParameterizedTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Parameters({"username1", "password1"})
    @Test
    public void loginTest1(String username, String password) {
        performLoginTest(username, password);
    }

    @Parameters({"username2", "password2"})
    @Test
    public void loginTest2(String username, String password) {
        performLoginTest(username, password);
    }

    private void performLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin(username);
        loginPage.inputPasswd(password);
        loginPage.clickLoginBtn();
        WebElement pageTitle = driver.findElement(By.xpath("//*[@class=\"title\"]"));
        assertTrue("Название страницы отображается", pageTitle.isDisplayed());
        assertEquals(pageTitle.getText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
