package challenges.jsexecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleTrickyFrameShadowRoot {

    @Test
    public void handleTrickyFrameShadowRoot() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        driver.get("https://selectorshub.com/xpath-practice-page/");

//        driver.switchTo().frame("pact");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement $element = (WebElement)
                jse.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
        String js = "arguments[0].setAttribute('value', 'British Tea')";
        jse.executeScript(js, $element);
        System.out.println("---->>> Done <<<------");

        driver.close();
        driver.quit();
    }
}
