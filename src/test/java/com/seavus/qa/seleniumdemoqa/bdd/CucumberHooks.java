package com.seavus.qa.seleniumdemoqa.bdd;

import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext applicationContext;

    @After
    public void afterScenario(Scenario scenario) {
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
