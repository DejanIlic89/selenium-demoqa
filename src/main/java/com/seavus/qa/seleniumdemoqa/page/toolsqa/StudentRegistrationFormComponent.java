package com.seavus.qa.seleniumdemoqa.page.toolsqa;

import com.seavus.qa.seleniumdemoqa.framework.annotation.PageFragment;
import com.seavus.qa.seleniumdemoqa.framework.constant.FrameworkConstants;
import com.seavus.qa.seleniumdemoqa.page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

@PageFragment
public class StudentRegistrationFormComponent extends Base {

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(xpath = "//*[contains(@class, 'react-datepicker__month-select')]")
    private WebElement monthSelect;

    @FindBy(xpath = "//*[contains(@class, 'react-datepicker__year-select')]")
    private WebElement yearSelect;

    @FindBy(xpath = FrameworkConstants.WEEKS_XPATH)
    private List<WebElement> weeks;

    @FindBy(xpath = "//*[contains(@class, 'custom-radio')]/*[contains(@class, 'custom-control-label')]")
    private List<WebElement> radioBtns;

    @FindBy(id = "subjectsInput")
    private WebElement subject;

    @FindBy(id = "userNumber")
    private WebElement mobile;

    @FindBy(xpath = "//*[contains(@class, 'custom-checkbox')]/*[contains(@class, 'custom-control-label')]")
    private List<WebElement> checkboxes;

    @FindBy(id = "//*[@id='currentAddress']")
    private WebElement currentAdd;

    @FindBy(xpath = "//*[contains(@class, 'form-control-file')]")
    private WebElement uploadPicture;

    @FindBy(xpath = "//*[@id='react-select-3-input']")
    private WebElement state;

    @FindBy(xpath = "//*[@id='react-select-4-input']")
    private WebElement city;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//*[contains(@class, 'modal-title')]")
    private WebElement modalTitleConfirmation;

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.firstName.isDisplayed());
    }

    public void fillInStudentForm(String firstName,
                                  String lastName,
                                  String email,
                                  String gender,
                                  String mobile,
                                  String birthday,
                                  String subjects,
                                  String hobbies,
                                  String picture,
                                  String currentAdd,
                                  String state,
                                  String city) throws IOException {
        super.sendKeys(this.firstName, firstName);
        super.sendKeys(this.lastName, lastName);
        super.sendKeys(this.userEmail, email);
        this.selectGender(gender);
        this.fillInMobile(mobile);
        this.selectDate(birthday);
        this.enterSubjects(subjects);
        this.checkHobbies(hobbies);
        this.selectPicture(picture); //comment this line when using Selenium Grid for running tests
        this.enterCurrentAdd(currentAdd);
        this.enterState(state);
        this.enterCity(city);
    }

    public boolean isConfirmationModalDispayled() {
        return super.isDisplayed(this.modalTitleConfirmation);
    }

    public void submit() {
        this.submit.submit();
    }

    public void enterFirstName(String firstName) {
        super.sendKeys(this.firstName, firstName);
    }

    public void enterLastName(String lastName) {
        super.sendKeys(this.lastName, lastName);
    }

    public void enterEmail(String userEmail) {
        super.sendKeys(this.userEmail, userEmail);
    }

    public void enterCity(String city) {
        super.enterDropdownListValue(this.city, city);
    }

    public void enterState(String state) {
        super.enterDropdownListValue(this.state, state);
    }

    public void enterCurrentAdd(String currentAdd) {
        ((JavascriptExecutor)this.driver).executeScript("$('#"+"currentAddress"+"').val('"+currentAdd+"');");
    }

    public void selectPicture(String picture) {
        String imagePath = FrameworkConstants.DATA_IMAGES_PATH + picture;
        this.uploadPicture.sendKeys(imagePath);
    }

    public void enterSubjects(String subjects) {
        String[] strings = subjects.split(", ");
        for (String s : strings) {
            super.clickOnElement(this.subject);
            super.sendKeys(this.subject, s);
            this.subject.sendKeys(Keys.ENTER);
        }
    }

    public void checkHobbies(String hobies) {
        String[] strings = hobies.split(", ");
        for (String s : strings) {
            this.checkboxes.stream()
                    .filter(element -> element.getText().equals(s))
                    .findFirst()
                    .get()
                    .click();
        }
    }

    public void selectDate(String birthday) {
        String[] date = birthday.split(" ");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        boolean flag = true;

        super.clickOnElement(dateOfBirthInput);

        Select selectMonth = new Select(monthSelect);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(yearSelect);
        selectYear.selectByVisibleText(year);

        for (int i = 0; i < this.weeks.size(); i++) {
            if (Integer.valueOf(day) > 25 && Integer.valueOf(day) < 32 && flag) {
                i++;
                flag = false;
            }
            List<WebElement> daysInAWeek = this.driver.findElements(
                    By.xpath(FrameworkConstants.WEEKS_XPATH + "[" + (i+1) +  "]" + FrameworkConstants.DAYS_XPATH)
            );
            for (int j = 0; j < daysInAWeek.size(); j++) {
                if (Integer.valueOf(daysInAWeek.get(daysInAWeek.size()-1).getText()) < Integer.valueOf(day)) break;
                if (daysInAWeek.get(i).getText().equals(day)) {
                    clickOnElement(daysInAWeek.get(i));
                    break;
                }
            }
        }
    }

    public void fillInMobile(String mobile) {
        if (mobile.toCharArray().length == 10) {
            super.sendKeys(this.mobile, mobile);
        } else {
            throw new IllegalStateException("User Number should have 10 digits");
        }
    }

    public void selectGender(String gender) {
        for (int i = 0; i < radioBtns.size(); i++) {
            if (radioBtns.get(i).getText().trim().equals(gender)) {
                super.clickOnElement(radioBtns.get(i));
                break;
            }
        }
    }
}
