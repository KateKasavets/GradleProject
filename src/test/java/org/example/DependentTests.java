package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class DependentTests extends BaseTest {
    private LogPage logPage;

    @BeforeClass
    public void setup() {
        super.setup();
        driver.get("https://auth.applitools.com/users/login");
        logPage = new LogPage(driver);
    }

    @Test
    public void loginTest() {
        logPage.login("evinasenla@gmail.com", "kk25474kkKK!");
        assertTrue(logPage.isUserProfileButtonDisplayed(), "User profile button is not displayed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void navigateToProfileMenu() {
        logPage.clickUserProfileButton();
        assertTrue(logPage.isProfileMenuDisplayed(), "Profile menu did not display after clicking user profile button");
        assertEquals(logPage.getProfileUserName(), "Eva Evina", "Имя не соответствует ожидаемому");
    }

    @Test(dependsOnMethods = "navigateToProfileMenu")
    public void logOutTest() {
        logPage.clickLogOutButton();
        assertTrue(logPage.isSignInPageTitleDisplayed(), "Название страницы авторизации не отображается");
        assertEquals(logPage.getSignInPageTitleText(), "Sign in", "Пользователь не на странице авторизации");
    }
}
