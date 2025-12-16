package testng.retrylogic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TeslaTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.tesla.com/");
    }

    @Test(priority = 1)
    public void teslaTest() {
        String title = driver.getTitle();
        System.out.println("The Header of Website is: " + title);
        Assert.assertEquals(title, "Electric Cars, Solar & Clean Energy | Tesla");
    }

    @Test(priority = 2)
    public void LogoTest(){
        WebElement logo = driver.findElement(By.xpath("//*[@class='tds-icon tds-icon-logo-wordmark tds-site-logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 2, enabled = false)
    public void LogoTest1(){
        WebElement logo = driver.findElement(By.xpath("//*[@class='tds-icon tds-icon-logo-wordmark tds-site-logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void LogoTest2(){
        WebElement logo = driver.findElement(By.xpath("//*[@class='tds-icon tds-icon-logo-wordmark tds-site-logo-icon__']"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
