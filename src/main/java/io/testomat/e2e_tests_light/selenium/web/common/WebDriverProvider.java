package io.testomat.e2e_tests_light.selenium.web.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {


    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(ChromeDriver::new);

    public static WebDriver driver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
