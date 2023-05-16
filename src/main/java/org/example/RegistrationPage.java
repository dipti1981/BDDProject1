package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils{
    LoadProp loadProp = new LoadProp();
    private By _firstname = By.xpath("//input[contains(@id,\"FirstName\")]");
    private By _lastname = By.xpath("//input[contains(@id,\"LastName\")]");
    private By _emailAddress = By.xpath("//input[starts-with(@id,\"Email\")]");
    private By _password = By.xpath("//input[starts-with(@id,\"Password\")]");
    private By _confirmPassword = By.xpath("//input[starts-with(@id,\"ConfirmPassword\")]");
    private By _registerSubmitButton = By.xpath("//button[starts-with(@id,\"register-button\")]");
    private By _birthDate = By.xpath("//select[@name =\"DateOfBirthDay\"]");
    private By _birthMonth = By.xpath("//select[@name =\"DateOfBirthMonth\"]");
    private By _birthYear = By.xpath("//select[@name =\"DateOfBirthYear\"]");
    public void FillTheElement(){
        //Type the first name
        typeTheText(_firstname,loadProp.getProperty("firstName"));
        //Type the last name
        typeTheText(_lastname,loadProp.getProperty("lastName"));
        //Select day of birth from dropdown
        selectElementByIndex(_birthDate,Integer.parseInt(loadProp.getProperty("birthDate")));
        //select month of birth from dropdown
        selectElementByValue(_birthMonth,loadProp.getProperty("birthMonth"));
        //select year of birth from dropdown
        selectElementByText(_birthYear,loadProp.getProperty("birthYear"));
        //Type the email address
        typeTheText(_emailAddress,loadProp.getProperty("emailAddress")+ timestamp() + loadProp.getProperty("emailDomain"));
        //Type the password
        typeTheText(_password,loadProp.getProperty("password"));
        //Type the confirmPassword
        typeTheText(_confirmPassword,loadProp.getProperty("confirmPassword"));
        //Click on register submit
        clickOnTheElement(_registerSubmitButton);

    }
    public void ForRegisteredUser(){
        //Type the first name
        typeTheText(_firstname,loadProp.getProperty("firstName"));
        //Type the last name
        typeTheText(_lastname,loadProp.getProperty("lastName"));
        typeTheText(_emailAddress,loadProp.getProperty("rEmailAddress"));
        //Type the password
        typeTheText(_password,loadProp.getProperty("rPassword"));
        //Type the confirmPassword
        typeTheText(_confirmPassword,loadProp.getProperty("rConfirmPassword"));
        //Click on register submit
        clickOnTheElement(_registerSubmitButton);

    }

}
