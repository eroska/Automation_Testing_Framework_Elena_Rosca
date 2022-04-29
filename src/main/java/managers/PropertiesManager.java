package managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties propertiesDeTestre;
    private static String pathToProperties = "src/main/resources/configuration.properties";

    public static void initiaizareProperties() {
        propertiesDeTestre = new Properties();
        try {
            propertiesDeTestre.load(new FileReader(pathToProperties));
        } catch (IOException eexception) {
            eexception.printStackTrace();
        }
    }

    public static String getbrowserType() {
        if (propertiesDeTestre == null) initiaizareProperties();
        String cllectedBrowserType = propertiesDeTestre.getProperty("browserType");
        if (cllectedBrowserType != null) {
            return cllectedBrowserType;
        } else {
            throw new RuntimeException("The browser type was defined in configuration . Please, take a look at it");
        }
    }

    public static String getBaseUrl() {
        if (propertiesDeTestre == null) initiaizareProperties();
        String colectedBaseUrl = propertiesDeTestre.getProperty("Base_URL");
        if (colectedBaseUrl != null) {
            return colectedBaseUrl;
        } else {
            throw new RuntimeException("The base URL was defined in configuration . Please, take a look at it");
        }
    }
}
