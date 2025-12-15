package challenges.propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {

    public static Properties loadProperties(String path) {
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
        Properties prop = loadProperties("src/test/java/challenges/propertiesfile/application.properties");
        return prop;
    }

}
