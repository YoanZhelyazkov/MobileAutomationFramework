package com.endava.mobile.stepdefinitions;

import com.endava.mobile.steplibraries.RegisterStepLibrary;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterNewUserStepDefinitions {

    @Steps(shared = true)
    RegisterStepLibrary registerStepLibrary;

    @When("I Enter {string} as Register Email")
    public void iEnterAsRegisterEmail(String email) {
        registerStepLibrary.enterRegisterEmail(email);
    }

    @And("I Enter {string} as Register Password")
    public void iEnterAsRegisterPassword(String password) {
        registerStepLibrary.enterRegisterPassword(password);
    }

    @And("I Enter {string} as Register Confirm Password")
    public void iEnterAsRegisterConfirmPassword(String password) {
        registerStepLibrary.enterRegisterConfirmPassword(password);
    }

    @And("I tap on the register button")
    public void iTapOnTheRegisterButton() {
        registerStepLibrary.clickRegisterButton();
    }

    @Then("I should see Notification message {string}")
    public void iShouldSeeMessage(String message) {
        // Needed as in iOS version, there is no notification
        if (registerStepLibrary.isNotificationTextVisible()) {
            assertEquals(registerStepLibrary.getNotificationMessageText(), message);
        }
    }
}