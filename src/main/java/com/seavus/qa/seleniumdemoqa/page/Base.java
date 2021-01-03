package com.seavus.qa.seleniumdemoqa.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    public void clickOnElement(WebElement element) {
        boolean isDisplayed = isDisplayed(element);
        if (isDisplayed) element.click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendKeys(WebElement element, String inputText) {
        boolean isDisplayed = isDisplayed(element);
        if (isDisplayed) {
            element.click();
            element.clear();
            element.sendKeys(inputText);
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return this.wait.until(d -> element.isDisplayed());
        } catch (Exception ex) {
            throw new NoSuchElementException("Element " + element + " is not found. " + "Stacktrace: " + ex.getStackTrace());
        }
    }

    protected void enterDropdownListValue(WebElement element, String state) {
        this.scrollToElement(element);
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
    }
}
