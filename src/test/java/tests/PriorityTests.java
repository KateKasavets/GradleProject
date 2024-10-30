package tests;

import io.qameta.allure.*;
import utils.ConfProperties;
import pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Authorization")
@Feature("Users actions on the login page")
public class PriorityTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getLoginPageUrl());
        loginPage = new LoginPage(driver);
    }

    @Description("Check header on the login page")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1)
    public void checkLoginPage() {
        Assert.assertEquals(loginPage.getLoginHeaderText(), "Авторизоваться с помощью", "Страница логина не найдена");
    }

    @Description("Check message after clicking on the login via the apple account")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void testExternalLogin() {
        loginPage.clickLoginExternal();
        Assert.assertEquals(loginPage.getLoginWithAppleTitleText(), "Использовать Аккаунт Apple для входа в приложение «Battle.net»", "Текст заголовка не соответствует ожидаемому");
    }

    @Description("Check logim with empty fields")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void testLoginWithoutCredentials() {
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Введите имя учетной записи.");
    }
}
