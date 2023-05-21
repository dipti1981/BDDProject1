package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils {
    public boolean SAUCE_LAB = false;
    //public boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("false"));
    LoadProp loadProp = new LoadProp();
    public String userName = loadProp.getProperty("sauce_UserName");
    public String accessKey = loadProp.getProperty("sauce_AccessKey");
    public String URL = "https://" + userName + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
  // public String browserName = System.getProperty("browser");
    public String browserName = loadProp.getProperty("browser");
    MutableCapabilities sauceOptions = new MutableCapabilities();

    public void openBrowser() {
        if (SAUCE_LAB) {
            System.out.println("Running in SauceLab.....with browser" + browserName);
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Running locally;" + browserName);
            if (browserName.equalsIgnoreCase("Chrome")) {
                // open Chrome browser
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                //open firefox browser
               driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                //open edge browser
                driver = new EdgeDriver();
            } else {
                System.out.println("Browser name is wrong or not implemented: ");
            }
        }

        //   open URL
        driver.get(loadProp.getProperty("url"));
        //maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }




public static void closeBrowser()
{
        //  close browser
        driver.close();
        }

}
