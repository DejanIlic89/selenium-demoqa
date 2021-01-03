package com.seavus.qa.seleniumdemoqa.page.toolsqa;

import com.seavus.qa.seleniumdemoqa.framework.annotation.PageFragment;
import com.seavus.qa.seleniumdemoqa.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class LeftSidePannelComponent extends Base {

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Elements')]")
    private WebElement elements;

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Forms')]")
    private WebElement forms;

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Alerts, Frame & Windows')]")
    private WebElement alertsFrameWindows;

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Interactions')]")
    private WebElement interactions;

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Widgets')]")
    private WebElement widgets;

    @FindBy(xpath = "//*[contains(@class, 'header-text') and contains(text(), 'Book Store Application')]")
    private WebElement bookStoreApp;

    @FindBy(xpath = "//*[contains(@class, 'main-header') and contains(text(), 'Forms')]")
    private WebElement formsHeader;

    public boolean formsPageIsLoaded() {
        return super.isDisplayed(formsHeader);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.forms.isDisplayed());
    }
}
