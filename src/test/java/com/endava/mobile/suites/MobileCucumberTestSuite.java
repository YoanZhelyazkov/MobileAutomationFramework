package com.endava.mobile.suites;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features/mobile/",
        glue = "com.endava.mobile.stepdefinitions"
)
public class MobileCucumberTestSuite {}