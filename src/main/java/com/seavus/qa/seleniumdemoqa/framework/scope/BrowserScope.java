package com.seavus.qa.seleniumdemoqa.framework.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

/**
 * Scope definition
 */
public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        // Getting object of WebDriver
        Object o =  super.get(name, objectFactory);

        // Checking the sessionId
        SessionId sessionId = ((RemoteWebDriver)o).getSessionId();

        // Create the new instance of the WebDriver if the current is not usable
        if (Objects.isNull(sessionId)) {
            super.remove(name);
            o = super.get(name, objectFactory);
        }

        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}
