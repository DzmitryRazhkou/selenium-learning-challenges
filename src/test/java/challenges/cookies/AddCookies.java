package challenges.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCookies {
    @Test
    public void handleCookies() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        String email = "dimagadjilla@gmail.com";
        String valid_password = "ab2941117";

        driver.get("https://www.pinterest.com/login/");

        driver.manage().addCookie(new Cookie("user", "1234"));
        Cookie cookie = driver.manage().getCookieNamed("user");
        System.out.println(cookie);

        By emailField = By.xpath("//*[@placeholder='Email']");
        By passwordField = By.xpath("//*[@placeholder='Password']");
        By loginBtn = By.xpath("//*[text()='Log in']");
        By pinLogo = By.xpath("(//*[@role='img'])[1]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).sendKeys(valid_password);
        driver.findElement(loginBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(pinLogo));

        driver.close();
        driver.quit();
    }
}
