package challenges.pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.helper.BrowserFabric;
import pom.helper.BrowserType;

public class BaseTest {

    protected WebDriver driver;
    protected String email = "dimagadjilla@gmail.com";
    protected String valid_password = "ab2941117";
    protected String wrong_password = "1234";

    @BeforeMethod
    public void startUp() throws IllegalAccessException {
        driver = BrowserFabric.get(BrowserType.CHROME);
    }

    @AfterMethod
    public void TearDown() {
        driver.close();
        driver.quit();
    }
}
