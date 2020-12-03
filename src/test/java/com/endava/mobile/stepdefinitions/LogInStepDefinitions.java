package com.endava.mobile.stepdefinitions;

import com.endava.mobile.steplibraries.LogInStepLibrary;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class LogInStepDefinitions {

    @Steps(shared = true)
    LogInStepLibrary logInStepLibrary;

    @And("I tap on Create new User button")
    public void iTapOnCreateNewUserButton() {
        logInStepLibrary.tapOnCreateNewUserButton();
    }

    @When("I enter {string} as login email")
    public void iEnterAsLoginEmail(String email) {
        logInStepLibrary.enterAsLoginEmail(email);
    }

    @And("I enter {string} as login password")
    public void iEnterAsLoginPassword(String password) {
        logInStepLibrary.enterAsLoginPassword(password);
    }

    @And("I click on Sign In button")
    public void iClickOnSignInButton() {
        logInStepLibrary.clickOnSignInButton();
    }

    @Then("I should see that I am correctly logged in")
    public void iShouldSeeThatIAmCorrectlyLoggedIn() {
        assertTrue(logInStepLibrary.shouldBeCorrectlyLoggedIn());
    }
}
