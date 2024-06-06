package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DataProviderParameterized {
    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = SingletonForDriver.getDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"catharinekosovets2189@gmail.com", "kk25474kk"},
                {"evinasenla@gmail.com", "kk25474kk"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        performLoginTest(username, password);
    }

    private void performLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin(username);
        loginPage.inputPasswd(password);
        loginPage.clickLoginBtn();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']")));


       String actualTitle = pageTitle.getText();
        assertTrue(pageTitle.isDisplayed(), "Название страницы отображается");
        assertEquals("Обзор учетной записи", actualTitle, "Текст заголовка не соответствует ожидаемому");
    }

    @AfterMethod
    public void tearDown() {
        SingletonForDriver.quitDriver();
    }
}
