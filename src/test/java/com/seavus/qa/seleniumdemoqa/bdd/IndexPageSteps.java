package com.seavus.qa.seleniumdemoqa.bdd;

import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.FormsPage;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.IndexPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class IndexPageSteps {

    @LazyAutowired
    private IndexPage indexPage;

    @LazyAutowired
    private FormsPage formsPage;

    @Given("I am on Index landing page")
    public void launchIndexPage() {
        this.indexPage.goTo();
        Assert.assertTrue(this.indexPage.isAt());
    }

    @Given("I click on Form Page")
    public void clickOnFormPage() {
        this.indexPage.clickOnForms();
    }

    @Then("Form Page is loaded")
    public void formPageIsLoaded() {
        Assert.assertTrue(this.formsPage.getLeftSidePannelComponent().formsPageIsLoaded());
    }


}
