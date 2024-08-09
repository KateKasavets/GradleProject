package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties")) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getLogin() {
        return getProperty("login");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getLoginPageUrl() {
        return getProperty("loginpage");
    }

    public static String getChromeDriverPath() {
        return getProperty("chromedriverpath");
    }

    public static String getRegistrationPage() {
        return getProperty("registrationpage");
    }

    public static String getAppDemoPage() {
        return getProperty("appdemopage");
    }

    public static String getPassword2() {
        return getProperty("password2");
    }

    public static String getLogin2() {
        return getProperty("login2");
    }
}
