package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ExclusionTests extends BaseTest {
    private LogPage logPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        driver.get("https://auth.applitools.com/users/login");
        logPage = new LogPage(driver);

    }

    @Test
    public void loginWithInvalidPasswordTest() {
        String errorMessage = logPage.attemptInvalidLogin("evinasenla@gmail.com", "invalidPassword123");
        System.out.println("Найдено сообщение об ошибке: " + errorMessage);
        assertEquals(errorMessage, "Incorrect username or password.", "Сообщение об ошибке не соответствует ожидаемому");
    }

    @Test
    public void loginWithGoogleTest() {
        logPage.clickGoogleButton();

    }
}
