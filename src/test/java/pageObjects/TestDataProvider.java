package pageObjects;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"evinasenla@gmail.com", "kk25474kk"},
                {"catharinekosovets2189@gmail.com", "kk25474kk"}

        };
    }
}
