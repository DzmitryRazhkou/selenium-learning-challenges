package challenges.jsexecutor;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Arrays;

public class JSExecutor {

    @Test
    public void jsExecutorHandle() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        Faker faker = new Faker();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String URL = "https://letcode.in/forms";
        driver.manage().window().maximize();
        driver.get(URL);

        WebElement firstNameInput = driver.findElement(By.cssSelector("#firstname"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#lasttname"));
        lastNameInput.sendKeys(lastName);

        // SendKeys Using JS Executor:
        WebElement emaiInput = driver.findElement(By.cssSelector("#email"));
        emaiInput.clear();
        js.executeScript("arguments[0].value=arguments[1]", emaiInput, email);

        // Scroll To JS Executor:
        WebElement dobInput = driver.findElement(By.cssSelector("#Date"));
        js.executeScript("arguments[0].scrollIntoView(true);", dobInput);

        // Click Using JS Executor:
        WebElement agreeToTermsAndConditions = driver.findElement(By.cssSelector("input[type='checkbox']"));
        js.executeScript("arguments[0].click()", agreeToTermsAndConditions);

        Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
