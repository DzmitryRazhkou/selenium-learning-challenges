package challenges.staleexception;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleStaleElementReferenceException {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Test
    public void handleStaleElementReferenceException() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        By removeButtonLocator = By.cssSelector("button[onclick=\"swapCheckbox()\"]");
        clickWithRetry(removeButtonLocator, 10);

        Thread.sleep(5000);

        String msgTxt = driver.findElement(By.cssSelector("#message")).getText().trim();
        Assert.assertSame(msgTxt.trim(), "It's gone!");

        Thread.sleep(2000);

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
