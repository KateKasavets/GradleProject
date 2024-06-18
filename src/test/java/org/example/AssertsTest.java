package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AssertsTest {
    public  WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://auth.applitools.com/users/general-register");
    }

    @Test
    public void testWithHardAsserts() {
        List<WebElement> firstName = driver.findElements(By.xpath("//input[@id='first-name']"));
        boolean isFirstNameDisplayed = !firstName.isEmpty() && firstName.get(0).isDisplayed();
        org.testng.Assert.assertTrue(isFirstNameDisplayed, "FirstName Field is not displayed");

        List<WebElement> ageField = driver.findElements(By.xpath("//input[@id='age']"));
        boolean isAgeFieldDisplayed = !ageField.isEmpty() && ageField.get(0).isDisplayed();
        org.testng.Assert.assertTrue(isAgeFieldDisplayed, "Age field is not displayed");

        List<WebElement> lastName = driver.findElements(By.xpath("//input[@id='last-name']"));
        boolean isLastNameDisplayed = !lastName.isEmpty() && lastName.get(0).isDisplayed();
        org.testng.Assert.assertTrue(isLastNameDisplayed, "LastName Field is not displayed");
    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> firstName = driver.findElements(By.xpath("//input[@id='first-name']"));
        softAssert.assertTrue(!firstName.isEmpty() && firstName.get(0).isDisplayed(), "Check firstname field is displayed");

        List<WebElement> ageField = driver.findElements(By.xpath("//input[@id='age']"));
        softAssert.assertTrue(!ageField.isEmpty() && ageField.get(0).isDisplayed(), "Age field is displayed");

        List<WebElement> lastName = driver.findElements(By.xpath("//input[@id='last-name']"));
        softAssert.assertTrue(!lastName.isEmpty() && lastName.get(0).isDisplayed(), "Check lastname field is displayed");

        //softAssert.assertAll();
    }
}