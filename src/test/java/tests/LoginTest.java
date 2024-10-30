package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Authorization")
@Feature("Login 1 user")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getLoginPageUrl());
        loginPage = new LoginPage(driver);
    }

    @Test
    @Description("Check successful login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        loginPage.login(ConfProperties.getLogin(), ConfProperties.getPassword());

        assertTrue(loginPage.isPageTitleDisplayed(), "Название страницы не отображается");
        assertEquals(loginPage.getPageTitleText(), "Обзор учетной записи", "Текст заголовка не соответствует ожидаемому");
    }
}
