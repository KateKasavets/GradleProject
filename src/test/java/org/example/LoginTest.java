package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        WebElement pageTitle = driver.findElement(By.xpath("//*[@class=\"title\"]"));
        assertTrue("Название страницы отображается", pageTitle.isDisplayed());
        assertEquals("Обзор учетной записи", pageTitle.getText(), "Текст заголовка не соответствует ожидаемому");
    }

}

