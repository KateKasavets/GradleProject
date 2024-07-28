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
    public void tryNowButton() {
        logPage.signInWithTryNowButton();
        WebElement tryNowElement = driver.findElement(By.xpath("//a[@class='link']"));
        Assert.assertTrue(tryNowElement.isDisplayed(), "Кнопка Sign in не найдена или не видима на странице.");
    }
}
