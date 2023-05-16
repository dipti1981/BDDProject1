package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _actualMessage = By.xpath("//div[@class =\"result\"]");
    private By _loginButton = By.xpath("//a[@class = \"ico-login\"]");
    String expectedRegistrationCompleteMessage = loadProp.getProperty("expectedRegistrationCompleteMessage") ;

    public void verifyUserRegisterSuccessfully() {
        //capture the actual message
        String actualMessage = getTextFromElement(_actualMessage);
        System.out.println("Actual message is: " + actualMessage);
        //Assert to verify the actual message and expected message
        Assert.assertEquals(actualMessage, expectedRegistrationCompleteMessage, "your registration is not working");

    }

    public void clickOnLoginButton() {
        //click on login button
        clickOnTheElement(_loginButton);
    }
}