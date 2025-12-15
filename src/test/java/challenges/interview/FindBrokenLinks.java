package challenges.interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindBrokenLinks {
    @Test
    public void doCheckBrokenLinks() throws InterruptedException {

        List<String> urlList = new ArrayList<>();

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        WebDriver driver = new ChromeDriver(opt);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(" =====> The Amount Of Links Are: " + links.size() + " <===== ");

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            urlList.add(url);
        }

        long stTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(s -> checkBrokenLinks(s));
        long endTime = System.currentTimeMillis();
        System.out.println("total time taken: " + (endTime - stTime));

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }

    public void checkBrokenLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " ---> " + httpURLConnection.getResponseMessage() + "is broken link");
            } else {
                System.out.println(linkUrl + " --->" + httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
