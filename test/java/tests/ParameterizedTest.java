package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfProperties;
import utils.WebDriverSingleton;

public class ParameterizedTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getLoginPageUrl());
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {ConfProperties.getLogin(), ConfProperties.getPassword()},
                {ConfProperties.getLogin2(), ConfProperties.getPassword()}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String login, String password) {
        loginPage.login(login, password);
        Assert.assertTrue(loginPage.isPageTitleDisplayed(), "Название страницы не отображается");
        Assert.assertEquals(loginPage.getPageTitleText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
