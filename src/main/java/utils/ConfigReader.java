package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();   // FIX

    static {
        try {

            String env = System.getProperty("environment", "qa");
            String configPath = "src/test/resources/config-" + env + ".properties";

            FileInputStream fis = new FileInputStream(configPath);

            properties.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
