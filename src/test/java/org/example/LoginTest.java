package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {


        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));

        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        loginPage.clickLoginBtn();

        WebElement pageTitle = driver.findElement(By.xpath("//*[@class=\"title\"]"));
        assertTrue("Название страницы отображается", pageTitle.isDisplayed());

        String expectedTitle = "Обзор учетной записи";
        String actualTitle = pageTitle.getText();
        assertEquals("Название страницы не соответствует ожидаемому", expectedTitle, actualTitle);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}


