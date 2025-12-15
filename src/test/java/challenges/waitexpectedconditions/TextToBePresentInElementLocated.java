package challenges.waitexpectedconditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextToBePresentInElementLocated {

    @Test
    public void handleTextToBePresentInElementLocated() {

        String stText = "laudantium";
        int counter = 1;
        boolean bTextPresent = false;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_content?with_content=static.");

        By elem_dynamic_con_locator = By.cssSelector("#content.large-10 > div:nth-of-type(3) > .large-10");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        while (!bTextPresent) {
            try {
                System.out.println(driver.findElement(elem_dynamic_con_locator).getText());
                bTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(elem_dynamic_con_locator, stText));
                if (bTextPresent) {
                    System.out.println("The text " + stText + " is present");
                    break;
                }
            } catch (TimeoutException e) {
                /* e.printStackTrace(); */
                counter++;
                System.out.println("Presence: " + bTextPresent + " Counter " + counter);
                driver.navigate().refresh();
                continue;
            }
        }
        System.out.println("ExpectedConditions.textToBePresentInElement successful with text " + stText + " found after " + counter + " attempts\n");

        driver.close();
        driver.quit();
    }
}
