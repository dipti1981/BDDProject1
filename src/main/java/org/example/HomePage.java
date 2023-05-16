package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _registerButton = By.xpath("//a[@class = 'ico-register']");

    private By _addToCartAppleMacBook = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]");


    String expectedWelcomeMessage = loadProp.getProperty("expectedWelcomeMessage");

    public void clickOnRegisterButton() {
        //click on register button
        clickOnTheElement(_registerButton);
    }


    public void addToCartAppleMacBook() {
        //click on add to cart of Apple MacBook
        clickOnTheElement(_addToCartAppleMacBook);
    }


       }