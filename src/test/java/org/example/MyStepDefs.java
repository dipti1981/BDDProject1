package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();
    LogInPage logInPage = new LogInPage();
    AppleMacBookPro13Inch appleMacBookPro13Inch = new AppleMacBookPro13Inch();
   ProductEmailAFriend productEmailAFriend = new ProductEmailAFriend();
    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        //click on register button
        homePage.clickOnRegisterButton();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        //fill all the elements
        registrationPage.FillTheElement();
    }

    @Then("I should able to register successfully")
    public void i_should_able_to_register_successfully() {
        //verify registration complete message
        registerResultPage.verifyUserRegisterSuccessfully();
    }

    @Given("I am a registered user")
    public void iAmARegisteredUser() {
        homePage.clickOnRegisterButton();
        registrationPage.ForRegisteredUser();
    }

    @When("I log in")
    public void iLogIn() {
        registerResultPage.clickOnLoginButton();
    }

    @And("I enter required log in details")
    public void iEnterRequiredLogInDetails() {
        logInPage.fillTheLogInDetails();
    }

    @And("I add Apple Mac Book in cart")
    public void iAddAppleMacBookInCart() {
        homePage.addToCartAppleMacBook();

    }

    @And("I click on email a friend")
    public void iClickOnEmailAFriend() {
        appleMacBookPro13Inch.clickOnEmailAFriend();
    }

    @And("I enter required details")
    public void iEnterRequiredDetails() {
        productEmailAFriend.fillTheDetails();
    }

    @Then("I should able to refer a product successfully")
    public void iShouldAbleToReferAProductSuccessfully() {
        productEmailAFriend.verifyTheMessage();
    }
}