package challenges.staleexception;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleElementReferenceException extends Throwable {

    protected WebDriverWait driver;
    protected WebDriverWait wait;

    @Test
    public void handleReCaptcha() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.addArguments("disable-infobars");
        opt.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(opt);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");



        driver.quit();
    }

    protected void clickWithRetry(By locator, int maxRetries) throws StaleElementReferenceException {
        for (int attempt = 0; attempt < maxRetries; attempt++) {
            // Wait for the element to be clickable and then click
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            return; // success, leave method
        }
        throw new RuntimeException("Failed to click element after " + maxRetries + " attempts: " + locator);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
