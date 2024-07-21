package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ParameterizedTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getLoginPageUrl());
        loginPage = new LoginPage(driver);
    }


    @Test(dataProvider = "loginData", dataProviderClass = pageObjects.TestDataProvider.class)
    public void loginTest(String login, String password) {
        loginPage.login(login, password);
        assertTrue("Название страницы отображается", loginPage.isPageTitleDisplayed());
        assertEquals(loginPage.getPageTitleText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }

}
