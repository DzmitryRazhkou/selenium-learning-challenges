package challenges.shadowdom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowElementRoot {
    @Test(enabled = true)
    public void shadowRootHandles() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://selectorshub.com/xpath-practice-page/");

            // 1. Find shadow host (normal DOM element)
            WebElement shadowHost = driver.findElement(By.cssSelector("#userName"));

            // 2. Get shadow root via JS
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement shadowRoot = (WebElement) js.executeScript(
                    "return arguments[0].shadowRoot", shadowHost);

            // 3. Find element inside shadow root
            WebElement inner = shadowRoot.findElement(By.cssSelector("#kils"));

            // 4. Use it normally
            inner.sendKeys("Nofx");

        } finally {
            driver.quit();
        }
    }

    @Test(enabled = false)
    public void shadowRootHandlesSeleniumFour() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement el = driver.findElement(By.cssSelector("#userName"));
        SearchContext shadow = el.getShadowRoot();
        WebElement input = shadow.findElement(By.cssSelector("#kils"));
        input.sendKeys("Nofx");

        driver.close();
    }
}
