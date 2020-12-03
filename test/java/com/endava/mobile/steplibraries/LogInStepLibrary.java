package com.endava.mobile.steplibraries;

import com.endava.mobile.components.BenefitsScreen;
import com.endava.mobile.components.LogInScreen;
import com.endava.utils.CustomActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class LogInStepLibrary {

    @Steps(shared = true)
    LogInScreen logInScreen;

    @Steps(shared = true)
    BenefitsScreen benefitsScreen;

    @Steps(shared = true)
    CustomActions customActions;

    @Step("Enter {string} as login email")
    public void enterAsLoginEmail(String email) {
        customActions.enterText(logInScreen.EMAIL_FIELD, email);
    }

    @Step("Enter {string} as login password")
    public void enterAsLoginPassword(String password) {
        customActions.enterText(logInScreen.PASSWORD_FIELD, password);
    }

    @Step("Tap on Create new User button")
    public void tapOnCreateNewUserButton() {
        customActions.tapOn(logInScreen.CREATE_NEW_USER_BUTTON);
    }

    @Step("Click on Sign In button")
    public void clickOnSignInButton() {
        customActions.tapOn(logInScreen.SIGN_IN_BUTTON);
    }

    @Step("I should be correctly logged in")
    public boolean shouldBeCorrectlyLoggedIn() {
        return customActions.isDisplayed(benefitsScreen.BENEFITS_CATEGORIES_HEADER);
    }
}