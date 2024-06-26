package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ParameterizedTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
    }

    @Parameters({"username1", "password1"})
    @Test
    public void loginTest1(String username, String password) {
        performLoginTest(username, password);
    }

    @Parameters({"username2", "password2"})
    @Test
    public void loginTest2(String username, String password) {
        performLoginTest(username, password);
    }

    private void performLoginTest(String username, String password) {
        loginPage.inputLogin(username);
        loginPage.inputPasswd(password);
        loginPage.clickLoginBtn();
        assertTrue("Название страницы отображается", loginPage.isPageTitleDisplayed());
        assertEquals(loginPage.getPageTitleText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
