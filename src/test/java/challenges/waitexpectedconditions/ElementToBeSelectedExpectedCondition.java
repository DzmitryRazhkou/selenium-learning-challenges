package challenges.waitexpectedconditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementToBeSelectedExpectedCondition {
    @Test
    public void handleElementToBeSelectedExpectedCondition() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        WebElement elemLi1 = driver.findElement(By.name("li1"));
        WebElement elemLi2 = driver.findElement(By.name("li2"));
        WebElement elemLi3 = driver.findElement(By.name("li3"));

        elemLi1.click();
        elemLi2.click();

        wait.until(ExpectedConditions.elementToBeSelected(elemLi1));
        wait.until(ExpectedConditions.elementToBeSelected(elemLi2));

        try {
            wait.until(ExpectedConditions.elementToBeSelected(elemLi3));
        } catch (TimeoutException err) {
            err.printStackTrace();
        }

        driver.close();
        driver.quit();
    }
}
