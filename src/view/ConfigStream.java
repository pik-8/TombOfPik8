package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigStream {

    private Properties properties;
    private FileInputStream fileInputStream;

    public ConfigStream(String filePath) throws IOException {
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


    public void setValueToKey (String key, String value) {
        this.properties.setProperty(key, String.valueOf(value));
    }


    public void setValueToKey (String key, double value) {
        this.properties.setProperty(key, String.valueOf(value));
    }

    public void close () {
        if (fileInputStream != null) {
            try {
                this.fileInputStream.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
