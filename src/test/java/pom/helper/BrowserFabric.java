package challenges.pom.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class BrowserFabric {
    public static WebDriver get(BrowserType browserType) throws IllegalAccessException {
        Objects.requireNonNull(browserType, "Browser type must not be null");

        switch (browserType) {
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            case CHROME:
                return getFirefoxDriver();

            default:
                throw new IllegalAccessException("Unsupported browser type: " + browserType);
        }
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1400,1000");
        WebDriverManager.operadriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.operadriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
