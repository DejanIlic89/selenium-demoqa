package com.seavus.qa.seleniumdemoqa.testcase;

import com.seavus.qa.seleniumdemoqa.SpringBaseTestNGTest;
import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.FormsPage;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.IndexPage;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NavBarTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private IndexPage indexPage;

    @LazyAutowired
    private FormsPage formsPage;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterTest
    public void tearDown() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }

    @Test
    public void navBarFormTest() throws InterruptedException {
        this.indexPage.goTo();
        Thread.sleep(5000);
        this.indexPage.clickOnLogin();
        Thread.sleep(5000);

        Assert.assertTrue(this.indexPage.isAt());

        this.indexPage.clickOnForms();
        Assert.assertTrue(this.formsPage.getLeftSidePannelComponent().formsPageIsLoaded());
    }

}
