package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private FileInputStream fileInputStream;

    public ConfigReader (String filePath) throws IOException {
        this.fileInputStream = new FileInputStream(filePath);
        this.properties = new Properties();
        this.properties.load(fileInputStream);
    }

    public String getStringFromConfigFile (String propertie) {
        return properties.getProperty(propertie);
    }

    public double getNumberFromConfigFile (String propertie) {
        return Double.valueOf(properties.getProperty(propertie));
    }
}
