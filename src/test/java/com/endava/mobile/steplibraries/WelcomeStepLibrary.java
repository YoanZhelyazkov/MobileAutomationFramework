package com.endava.mobile.steplibraries;

import com.endava.mobile.components.WelcomeScreen;
import com.endava.utils.CustomActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;

public class WelcomeStepLibrary {

    @Steps(shared = true)
    WelcomeScreen welcomeScreen;

    @Steps(shared = true)
    CustomActions customActions;

    @Before
    public void allowNotifications() {
        if (welcomeScreen.ALLOW_NOTIFICATIONS_BUTTON.isDisplayed()) {
            customActions.tapOn(welcomeScreen.ALLOW_NOTIFICATIONS_BUTTON);
        }
    }

    @Step("Tap on Login as SFD Employee")
    public void tapLoginAsEmployeeButton() {
        customActions.tapOn(welcomeScreen.LOG_IN_AS_EMPLOYEE_BUTTON);
    }

    @Step("Tap on Login as Visitor")
    public void tapLoginAsVisitorButton() {
        customActions.tapOn(welcomeScreen.LOG_IN_AS_VISITOR_BUTTON);
    }
}