package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getLoginPageUrl());
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.login(ConfProperties.getLogin(), ConfProperties.getPassword());
        assertTrue("Название страницы отображается", loginPage.isPageTitleDisplayed());
        assertEquals("Обзор учетной записи", loginPage.getPageTitleText(), "Текст заголовка не соответствует ожидаемому");
    }
}



