package testng.singletonthreadlocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverManagerSingletonThreadLocal {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Ensures only one instance of a class exists across the JVM:
    // Common use cases:
    // • WebDriver manager
    // • Configuration reader
    // • Logger
    // • Database connection

    // 🔥 Interview Notes
	// • Singleton alone is NOT enough for parallel execution
	// • Combine with ThreadLocal
	// • Avoid global static WebDriver without ThreadLocal

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
