package property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {
    private static String username, password, successfullyLoginUrl;
    private static String propertyFilePath = "src/main/resources/property.properties";

    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if (instance == null){
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }
    private void loadData(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        successfullyLoginUrl = properties.getProperty("successfullyLoginUrl");
    }
    public static void changeProperty(String key, String newValue){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);
            properties.setProperty(key, newValue);
            properties.store(new FileOutputStream(propertyFilePath), null);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        instance = null;
    }

    public String getSuccessfullyLoginUrl(){
        return successfullyLoginUrl;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
