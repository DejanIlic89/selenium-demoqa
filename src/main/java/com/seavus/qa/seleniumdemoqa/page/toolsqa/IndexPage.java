package com.seavus.qa.seleniumdemoqa.page.toolsqa;

import com.seavus.qa.seleniumdemoqa.framework.annotation.Page;
import com.seavus.qa.seleniumdemoqa.page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

@Page
public class IndexPage extends Base {

    @Value("${application.url}")
    private String baseUrl;

    @FindBy(xpath = "//*[contains(@class, 'card-body')]/h5[contains(text(), 'Forms')]")
    private WebElement formCard;

    public void goTo() {
        this.driver.get(baseUrl);
    }

    public void clickOnLogin() {
        this.driver.findElement(By.id("footerLogin")).click();
    }

    public void clickOnForms() {
        super.clickOnElement(this.formCard);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.formCard.isDisplayed());
    }
}
