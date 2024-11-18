package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Android Emulator");
                capabilities.setCapability("appPackage", "com.android.calculator2");
                capabilities.setCapability("appActivity", ".Calculator");
                capabilities.setCapability("automationName", "UiAutomator2");

                driver = new AndroidDriver(new URL("http:localhost"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Falha ao iniciar o drive: " + e.getMessage());
            }
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
