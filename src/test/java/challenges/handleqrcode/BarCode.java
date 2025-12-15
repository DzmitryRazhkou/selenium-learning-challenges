package challenges.handleqrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BarCode {
    @Test
    public void handleBarCode() throws IOException, NotFoundException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://barcode.tec-it.com/en");

        String barCodeUrl = driver.findElement(By.tagName("img")).getAttribute("src");
        System.out.println(barCodeUrl);

//      1. Create an Object of URL Class

        Assert.assertNotNull(barCodeUrl);
        URL url = new URL(barCodeUrl);

//      2. Pass the URL Class Object to Store the File as Image

        BufferedImage bufferedImage = ImageIO.read(url);

//      3. Process the Image

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

//      4. To Capture Details of QR Code

        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println("The Barcode contains: " +result.getText());

        driver.close();
    }
}
