package Util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties prop;

    //String File="/Users/techops/IdeaProjects/com.SpreeHomePage/src/test/testData/config/testconfig.properties";

    public ConfigFileReader() {
        String configFilename = "testconfig.properties";
        FileInputStream inputFileStream = null;
        this.prop = new Properties();
        String configFilePath = System.getProperty("user.dir") + "/" + "src/test/testData/config" + "/" + configFilename;

        try {
            inputFileStream = new FileInputStream(configFilePath);
            prop.load(inputFileStream);
        }

        catch (IOException e) {
            e.printStackTrace();
        }




    }

    public String getProperty(String propertyname)
    {
        return this.prop.getProperty(propertyname);
    }
}
