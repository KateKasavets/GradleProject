package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class PriorityTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test(priority = 1)
    public void checkLoginPage() {
        System.out.println("Executing checkLoginPage");
        WebElement pageTitle = driver.findElement(By.id("login-header"));
        Assert.assertEquals(pageTitle.getText(), "Авторизоваться", "Страница логина не найдена");;
    }
    @Test(priority = 3)
    public void testExternalLogin() {
        System.out.println("Executing testExternalLogin");
        loginPage.clickLoginExternal();
        WebElement loginWithApple = driver.findElement(By.xpath("//div[@id=\"signin\"]/app-title"));
        Assert.assertEquals(loginWithApple.getText(), "Используйте Apple ID для входа в приложение «Battle.net».", "Текст заголовка не соответствует ожидаемому");

    }
    @Test(priority = 2)
    public void testLoginWithoutCredentials() {
        System.out.println("Executing testLoginWithoutCredentials");
        driver.findElement(By.id("submit")).click();
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[@class=\"error-helper error-helper-accountName status-warning\"]"));
        System.out.println("Найдено сообщение об ошибке: " + errorMessageElement.getText());
        Assert.assertEquals(errorMessageElement.getText(), "Введите имя учетной записи.");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    }

