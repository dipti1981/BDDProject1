package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Utils extends BasePage {
    public static void clickOnTheElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeTheText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void selectElementByText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    public static void selectElementByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public static void selectElementByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static void explicitWaitClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void explicitWaitInvisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void waitVisibilityOfAllElementsLocated(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public static void listMethod(By by) {
        List<WebElement> input = driver.findElements(by);
        for (WebElement e : input) {
            System.out.println(e.getText());
        }
    }



    public static List<WebElement> getTextFromElements(By by){
        List< WebElement> fullList = driver.findElements(by);
        for (WebElement nameOfEachElement:fullList){
            System.out.println(nameOfEachElement.getText());
        }return (fullList);
    }

    public static boolean getTextFromElements_Contains(By by, String text) {
        List<WebElement> productList = driver.findElements(by);
        for (WebElement productTitle : productList) {
            productTitle.getText();
            if (productTitle.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

        public static String currentTimeStamp () {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
            return sdf.format(date);
        }
        public static void captureScreenshot(String fileName){
        //convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            //call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //move images file to new destination
            File destFile = new File("src\\test\\Screenshots\\"+fileName+""+currentTimeStamp()+".png");
            //Copy file at destination
            try {
                FileUtils.copyFile(SrcFile, destFile);
            }catch(IOException e){e.printStackTrace();
            }
        }
    public void getCurrentURl() {
        String mainWindow = driver.getCurrentUrl();
        System.out.println("Current url is: " + mainWindow);
    }



}

