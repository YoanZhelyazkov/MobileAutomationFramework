package com.endava.mobile.steplibraries;
import com.endava.mobile.components.RegisterScreen;
import com.endava.utils.CustomActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class RegisterStepLibrary {

    @Steps(shared = true)
    RegisterScreen registerScreen;

    @Steps(shared = true)
    CustomActions customActions;

    @Step("Enter Register Email")
    public void enterRegisterEmail(String email) {
        customActions.enterText(registerScreen.REGISTER_EMAIL_FIELD, email);
    }

    @Step("Enter Register Password")
    public void enterRegisterPassword(String password) {
        customActions.enterText(registerScreen.REGISTER_PASSWORD_FIELD, password);
    }

    @Step("Enter Register Confirm Password")
    public void enterRegisterConfirmPassword(String password) {
        customActions.enterText(registerScreen.REGISTER_CONFIRM_PASSWORD_FIELD, password);
    }

    @Step("Click Register button")
    public void clickRegisterButton() {
        customActions.tapOn(registerScreen.REGISTER_BUTTON);
    }

    @Step("Get Notification Message text")
    public String getNotificationMessageText() {
        return customActions.getText(registerScreen.NOTIFICATION_MESSAGE).trim();
    }

    @Step("Is Notification Message text visible")
    public boolean isNotificationTextVisible() {
        return customActions.isVisible(registerScreen.NOTIFICATION_MESSAGE);
    }
}