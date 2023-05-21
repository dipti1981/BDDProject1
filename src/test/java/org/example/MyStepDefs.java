package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyStepDefs extends Utils {
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

    @Given("I am on Demo nopcommerce homepage")
    public void iAmOnDemoNopcommerceHomepage() {
        homePage.verifyHomepageURL();

    }

    @When("I click on {string} button")
    public void iClickOnButton(String button_name) {
        clickOnTheElement(By.xpath("//a[text()='"+button_name+" ']"));
    }

    @Then("I should able to verify I am nevigated to related page {string} successfully")
    public void iShouldAbleToVerifyIAmNevigatedToRelatedPageSuccessfully(String page_url) {

        Assert.assertEquals(driver.getCurrentUrl(), page_url);
    }

    @And("I should able to verify the page title as {string}")
    public void iShouldAbleToVerifyThePageTitleAs(String page_title) {
       // Assert.assertEquals((By.tagName("h1")), page_title);
        Assert.assertEquals(getTextFromElement(By.cssSelector("div.page-title")),page_title);
    }
}