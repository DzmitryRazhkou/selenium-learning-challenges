package challenges.pagefactory;

import challenges.screenshot.ScreenshotUtility;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageFactory {
    public WebDriver driver;
    public WebDriverWait wait;
    public Faker faker;
    public JavascriptExecutor js;

    // Locators:
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lasttname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailNameInput;

    @FindBy(xpath = "//input[@id='Phno']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='Addl1']")
    private WebElement addressFirstLineInput;

    @FindBy(xpath = "//input[@id='Addl2']")
    private WebElement addressSecondLineInput;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='postalcode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement agreeToTermsAndConditions;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;


    @Test
    public void handlePageFactory() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://letcode.in/forms");
        initElements(driver, this);

        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        emailNameInput.clear();
        emailNameInput.sendKeys(faker.internet().emailAddress());
        phoneInput.sendKeys(faker.phoneNumber().cellPhone());
        addressFirstLineInput.sendKeys(faker.address().streetAddress());
        addressSecondLineInput.sendKeys(faker.address().secondaryAddress());
        stateInput.sendKeys(faker.address().state());
        postalCodeInput.sendKeys(faker.address().zipCode());

        String script = "arguments[0].scrollIntoView(true);";
        js.executeScript(script, agreeToTermsAndConditions);
        if (!agreeToTermsAndConditions.isSelected()) {
            agreeToTermsAndConditions.click();
        }

        submitButton.click();

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }

    @AfterTest
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtility.takeScreenshot(driver, ScreenshotUtility.getScreenshotFileName("Name"));
        }
    }
}
