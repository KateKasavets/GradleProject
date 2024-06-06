package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class PageFactoryTest {

    private WebDriver driver;
    private PageFactoryLogin pageFactoryLogin;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        pageFactoryLogin = new PageFactoryLogin(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("applitoolsPage"));
    }

    @Test
    public void testLogin(){
        pageFactoryLogin.enterUsername("evinasenla@gmail.com");
        pageFactoryLogin.enterPassword("kk25474kkKK!");
        pageFactoryLogin.clickSignButton();
        pageFactoryLogin.clickChooseProductButton();

        WebElement userProfileButton = driver.findElement(By.xpath("//button[@aria-label=\"User\"]"));
        assertTrue("Иконка пользователя присутствует", userProfileButton.isDisplayed());

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
