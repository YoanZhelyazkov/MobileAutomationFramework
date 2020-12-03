package com.endava.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class CustomActions extends PageObject {

    public void tapOn(WebElement webElement) {
        $(webElement).waitUntilClickable().click();
    }

    public void enterText(WebElement webElement, String text) {
        $(webElement).type(text);
    }

    public boolean isDisplayed (WebElement webElement) {
        return $(webElement).isDisplayed();
    }

    public String getText (WebElement webElement) {
        return $(webElement).getText();
    }
}
