package challenges.credentlias;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class HashMapCredentials {

    public WebDriver driver;

    @Test
    public void handleHashMapCredentials() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
        driver.get("https://classic.freecrm.com/index.html");

        System.out.println(getCredentials().get("Customer"));
        driver.findElement(By.name("username")).sendKeys(getUserName("seller"));
        driver.findElement(By.name("password")).sendKeys(getPassword("admin"));

        driver.close();
        driver.quit();
    }

    public static HashMap<String, String> getCredentials() {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("Customer", "gansRazhkou:Test3036057Dr");
        userMap.put("admin", "aspit:34855");
        userMap.put("seller", "korina:3345986");
        userMap.put("deliveryGuy", "455566:hui");

        return userMap;
    }

    public static String getUserName(String role) {
        String credentials = getCredentials().get(role);
        return credentials.split(":")[0];
    }

    public static String getPassword(String role) {
        String credentials = getCredentials().get(role);
        return credentials.split(":")[1];
    }

}
