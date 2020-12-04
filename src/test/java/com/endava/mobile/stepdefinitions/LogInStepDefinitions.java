package com.endava.mobile.stepdefinitions;

import com.endava.mobile.steplibraries.LogInStepLibrary;
import com.endava.utils.CustomActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class LogInStepDefinitions {

    @Steps(shared = true)
    LogInStepLibrary logInStepLibrary;

    @Steps(shared = true)
    CustomActions customActions;

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

    @And("I tap on Sign In button")
    public void iTapOnSignInButton() {
        logInStepLibrary.tapOnSignInButton();
    }

    @And("I tap on Log In button")
    public void iTapOnLogInButton() {
        if (customActions.getDriverType().equals("Android"))
        logInStepLibrary.tapOnSignInButton();
    }

    @Then("I should see that I am correctly logged in")
    public void iShouldSeeThatIAmCorrectlyLoggedIn() {
        assertTrue(logInStepLibrary.shouldBeCorrectlyLoggedIn());
    }

    @Then("I should see Text input Error message {string}")
    public void iShouldSeeTextInputErrorMessage(String errorText) {
        assertTrue(logInStepLibrary.isTextInputErrorMessageCorrect(errorText));
    }
}
