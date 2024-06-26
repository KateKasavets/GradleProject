package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriorityTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void checkLoginPage() {
        System.out.println("Executing checkLoginPage");
        Assert.assertEquals(loginPage.getLoginHeaderText(), "Авторизоваться с помощью", "Страница логина не найдена");
    }

    @Test(priority = 3)
    public void testExternalLogin() {
        System.out.println("Executing testExternalLogin");
        loginPage.clickLoginExternal();
        Assert.assertEquals(loginPage.getLoginWithAppleTitleText(), "Используйте Apple ID для входа в приложение «Battle.net».", "Текст заголовка не соответствует ожидаемому");
    }

    @Test(priority = 2)
    public void testLoginWithoutCredentials() {
        System.out.println("Executing testLoginWithoutCredentials");
        loginPage.clickLoginBtn();
        System.out.println("Найдено сообщение об ошибке: " + loginPage.getErrorMessageText());
        Assert.assertEquals(loginPage.getErrorMessageText(), "Введите имя учетной записи.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
