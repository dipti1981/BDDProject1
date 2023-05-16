package org.example;

import org.openqa.selenium.By;

public class AppleMacBookPro13Inch extends Utils{
    private By _emailAFriend = By.xpath("//div[@class=\"email-a-friend\"]/button");
    public void clickOnEmailAFriend(){
        //use wait
        explicitWaitClick(_emailAFriend);
        //click on email a friend
        clickOnTheElement(_emailAFriend);
    }
}
