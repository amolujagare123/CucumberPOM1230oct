package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static String url;


    public ConfigReader() throws IOException {

        Properties prop = new Properties();
        FileInputStream fp
                = new FileInputStream("resources\\confing.properties");
        // load a properties file
        prop.load(fp);
        // get the property value and print it out
        this.url = prop.getProperty("url");

    }

    public  String getUrl() {
        return url;
    }

}
