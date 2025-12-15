package challenges.handleqrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
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

public class HandleQRCode {
    @Test
    public void handelQRCode() throws IOException, NotFoundException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.musthavemenus.com/feature/menu-qr-code.html");

        String QRCodeUrl = driver.findElement(By.xpath("//img[@src='/imageservice/images/img/13/qr/QR-Code-tt-insert.png']"))
                .getAttribute("src");

        System.out.println(QRCodeUrl);

//      1. Create an Object of URL Class

        URL url = new URL(QRCodeUrl);

//      2. Pass the URL Class Object to Store the File as Image

        BufferedImage bufferedImage = ImageIO.read(url);

//      3. Process the Image

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

//      4. To Capture Details of QR Code

        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println("The QRcode contains: " + result.getText());

        driver.close();
    }
}
