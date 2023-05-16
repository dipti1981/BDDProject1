package org.example;

import org.openqa.selenium.By;

public class LogInPage extends Utils{
    LoadProp loadProp = new LoadProp();

    private By _emailAddress = By.id("Email");
    private By _Password = By.id("Password");
    private By _logInSubmitButton = By.xpath("//div[@class=\"returning-wrapper fieldset\"]/form/div[3]/button");
    public void fillTheLogInDetails(){
        //type email address
        typeTheText(_emailAddress,loadProp.getProperty("rEmailAddress"));
        //type password
        typeTheText(_Password,loadProp.getProperty("rPassword"));
        //click on login submit button
        clickOnTheElement(_logInSubmitButton);
    }

}
