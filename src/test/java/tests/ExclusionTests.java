package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LogPage;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;

public class ExclusionTests extends BaseTest {
    private LogPage logPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getAppDemoPage());
        logPage = new LogPage(driver);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        String errorMessage = logPage.attemptInvalidLogin("evinasenla@gmail.com", "invalidPassword123");
        assertEquals(errorMessage, "Incorrect username or password.", "Сообщение об ошибке не соответствует ожидаемому");
    }

    @Test
    public void loginWithInvalidEmailTest() {
        String errorMessage = logPage.attemptInvalidLogin("evinasenlaaaa@gmail.com", "kk25474kkKK!");
        assertEquals(errorMessage, "Incorrect username or password.", "Сообщение об ошибке не соответствует ожидаемому");
    }

    @Test
    public void loginWithInvalidEmailFormatTest() {
        logPage.login("evinasenlaaaa@gmail.com12", "kk25474kkKK!");
        String emailErrorMessage = logPage.getEmailErrMsg();
        assertEquals(emailErrorMessage, "Please enter a valid email", "Сообщение об ошибке email не соответствует ожидаемому");
    }

    @Test
    public void tryNowButton() {
        logPage.signInWithTryNowButton();
        Assert.assertTrue(logPage.isTryNowButtonDisplayed(), "Кнопка Sign in не найдена или не видима на странице.");
    }
}
