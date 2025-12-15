package challenges.highlightelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//*[contains(text(), 'Create new account')]")).click();
        Thread.sleep(500);

        WebElement firstName = driver.findElement(By.name("firstname"));
        Helper.highLightElement(driver, firstName);
        firstName.sendKeys("Dzmitry");

        WebElement lastName = driver.findElement(By.name("lastname"));
        Helper.highLightElement(driver, lastName);
        lastName.sendKeys("Razhkou");

        WebElement email = driver.findElement(By.name("reg_email__"));
        Helper.highLightElement(driver, email);
        email.sendKeys("dimagadjilla@gmail.com");

        System.out.println("\n_____________");
        System.out.println("Completed");
        Thread.sleep(1500);

        driver.close();
        driver.quit();
    }
}
