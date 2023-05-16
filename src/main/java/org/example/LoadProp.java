package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.example.BasePage.driver;
import static org.example.Utils.currentTimeStamp;

public class LoadProp {
        static Properties prop = new Properties();
    static FileInputStream input;
    static String propertiesFileLocation = "src/test/java/TestConfig/TestData.properties";

    public String getProperty(String key){
        try{
            input = new FileInputStream(propertiesFileLocation);
            prop.load(input);
            input.close();}
        catch (IOException e)
        {e.printStackTrace();
        }
        return prop.getProperty(key);

        }

    }


