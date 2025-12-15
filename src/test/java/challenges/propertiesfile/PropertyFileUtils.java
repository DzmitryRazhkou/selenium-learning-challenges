package challenges.PropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {

    public static Properties loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = null;

        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static Properties loadApplicationProperties() throws IOException {
        Properties properties = loadProperties("src/test/java/Selenium/PropertiesFile/application.properties");
        return properties;
    }

}
