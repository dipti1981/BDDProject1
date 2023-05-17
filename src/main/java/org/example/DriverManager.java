package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;



import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils{
    LoadProp loadProp = new LoadProp();

    public void openBrowser(){
        if (loadProp.getProperty("browserName").equalsIgnoreCase(loadProp.getProperty("browserName"))) {
       // open Chrome browser
             driver = new ChromeDriver();
        }else if(loadProp.getProperty("browserName").equalsIgnoreCase(loadProp.getProperty("browserName"))){
            //open edge browser
            driver = new EdgeDriver();
        }else {
            System.out.println("Browser name is wrong or not implemented: " );
        }
         //   open URL
        driver.get(loadProp.getProperty("url"));
        //maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public static void closeBrowser(){
      //  close browser
        driver.close();
    }

}
