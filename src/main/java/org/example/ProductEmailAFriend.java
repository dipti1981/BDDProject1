package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriend extends Utils{
    LoadProp loadProp = new LoadProp();
private By _friendsEmail = By.id("FriendEmail");
private By _yourEmailID = By.id("YourEmailAddress");
private By _sendEmail = By.xpath("//div[@class=\"buttons\"]/button");
private By _productName = By.xpath("//a[@href = \"/apple-macbook-pro-13-inch\"]");
private By _actualMessage = By.xpath("//div[@class=\"page-body\"]/div[2]");
private By _personalMessage = By.id("PersonalMessage");
private By _actualErrorMessage =By.xpath("//div[@class=\"message-error validation-summary-errors\"]");
    String expectedProductErrorMessage = loadProp.getProperty("expectedProductErrorMessage");
    String expectedMessageAfterEmail = loadProp.getProperty("expectedMessageAfterEmail");
    public void verifyTheMessage() {
        //capture the actualMessage
        String actualMessage = getTextFromElement(_actualMessage);
        System.out.println("Display message is: " + actualMessage);
        //Capture the product name
        String productName = getTextFromElement(_productName);
        System.out.println("Product name is: " + productName);
        //Assert to verify the actual message and expected message
        Assert.assertEquals(actualMessage, expectedMessageAfterEmail, "Display message is not same");
    }
    public void verifyTheErrorMessage(){
        //Type friend's Email id
        typeTheText(_friendsEmail, "Abc123@gmail.com");
        //Type your Email id
        typeTheText(_yourEmailID, "test@gmail.com");
        //Type personal message
        typeTheText(_personalMessage, "sample message");
        //Click on send Email button
        clickOnTheElement(_sendEmail);
        //Capture error message
        String actualErrorMessage = getTextFromElement(_actualErrorMessage);
        System.out.println("Error Message is: " + actualErrorMessage);
        //Assert to verify the actual message and expected message
        Assert.assertEquals(actualErrorMessage, expectedProductErrorMessage, "Please register to use Email a friend feature");

    }

public void fillTheDetails(){
        //type friend's email
    typeTheText(_friendsEmail,loadProp.getProperty("friendEmail"));
    //click on send email button
    clickOnTheElement(_sendEmail);
}

}
