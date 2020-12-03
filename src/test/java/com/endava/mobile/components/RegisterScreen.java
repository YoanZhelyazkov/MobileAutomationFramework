package com.endava.mobile.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class RegisterScreen extends PageObject {

    @AndroidFindBy(id = "registerUsername")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='e.g. firstname.lastname@endava.com']")
    public WebElement REGISTER_EMAIL_FIELD;

    @AndroidFindBy(id = "registerPassword")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement REGISTER_PASSWORD_FIELD;

    @AndroidFindBy(id = "registerConfirmPassword")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField)[2]")
    public WebElement REGISTER_CONFIRM_PASSWORD_FIELD;

    @AndroidFindBy(id = "registerButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='REGISTER']")
    public WebElement REGISTER_BUTTON;

    @AndroidFindBy(id = "snackbar_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='REGISTER']")
    public WebElement NOTIFICATION_MESSAGE;
}
