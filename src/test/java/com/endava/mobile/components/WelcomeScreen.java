package com.endava.mobile.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class WelcomeScreen extends PageObject {

    @AndroidFindBy(id = "loginEmployeeButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login as SFD Employee']")
    public WebElement LOG_IN_AS_EMPLOYEE_BUTTON;

    @AndroidFindBy(id = "loginVisitorButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login as Visitor']")
    public WebElement LOG_IN_AS_VISITOR_BUTTON;
}