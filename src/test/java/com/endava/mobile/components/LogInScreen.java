package com.endava.mobile.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LogInScreen extends PageObject {

    @AndroidFindBy(id = "textinput_placeholder")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='e.g. firstname.lastname@endava.com']")
    public WebElement EMAIL_FIELD;

    @AndroidFindBy(id = "password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement PASSWORD_FIELD;

    @AndroidFindBy(id = "loginButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SIGN IN']")
    public WebElement SIGN_IN_BUTTON;

    @AndroidFindBy(id = "registerButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create one!']")
    public WebElement CREATE_NEW_USER_BUTTON;
}