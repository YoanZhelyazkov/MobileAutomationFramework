package com.endava.mobile.stepdefinitions;

import com.endava.mobile.steplibraries.WelcomeStepLibrary;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class WelcomeStepDefinitions {

    @Steps(shared = true)
    WelcomeStepLibrary welcomeStepLibrary;

    @Given("I tap on Login as Employee button")
    public void iTapOnLoginAsEmployeeButton() {
        welcomeStepLibrary.tapLoginAsEmployeeButton();
    }
}