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

public class DependentTests {
    private static WebDriver driver;
    private static LogPage logPage;
    private static boolean isLoggedIn = false;
    private static boolean isUserProfileButton = false;

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
    public void loginTest() {
        logPage.login("evinasenla@gmail.com", "kk25474kkKK!");
        WebElement userProfileButton = driver.findElement(By.xpath("//button[@aria-label=\"User\"]"));
        isLoggedIn = userProfileButton.isDisplayed();  // Установка флага на основе видимости кнопки
        Assert.assertTrue(isLoggedIn, "User profile button is not displayed - Login may have failed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void navigateToProfileMenu() {
        WebElement userProfileButton = driver.findElement(By.xpath("//button[@aria-label=\"User\"]"));
        userProfileButton.click();

        WebElement profileMenu = driver.findElement(By.xpath("//div[@class=\"user-name\"]"));
        isUserProfileButton = profileMenu.isDisplayed();
        Assert.assertTrue(isUserProfileButton, "Profile menu did not display after clicking user profile button");
        Assert.assertEquals(profileMenu.getText(), "Eva Evina", "Имя не соответствует ожидаемому");
    }

    @Test(dependsOnMethods = "navigateToProfileMenu")
    public void logOutTest() {
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"dropdown-1\"]/div/button[4]/div/span"));
        logOutButton.click();

        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
        Assert.assertTrue(pageTitle.isDisplayed(), "Название страницы авторизации не отображается");
        Assert.assertEquals(pageTitle.getText(), "Sign in", "Пользователь не на странице авторизации");
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
