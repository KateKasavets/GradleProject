package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonForDriver {
    private static WebDriver driver;

    private SingletonForDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
