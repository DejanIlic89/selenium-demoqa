package com.seavus.qa.seleniumdemoqa.bdd;

import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.FormsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class StudentSteps {

    @LazyAutowired
    private FormsPage formsPage;

    @Given("I am on Student registration form")
    public void launchSite() {
        this.formsPage.goTo();
        Assert.assertTrue(this.formsPage.isAt());
    }

    @When("I enter first name as {string}")
    public void enterFirstName(String firstName) {
        this.formsPage.getStudentRegistrationFormComponent().enterFirstName(firstName);
    }

    @And("I enter last name as {string}")
    public void enterLastName(String lastName) {
        this.formsPage.getStudentRegistrationFormComponent().enterLastName(lastName);
    }

    @And("I enter email as {string}")
    public void enterEmail(String email) {
        this.formsPage.getStudentRegistrationFormComponent().enterEmail(email);
    }

    @And("I enter gender as {string}")
    public void enterGender(String gender) {
        this.formsPage.getStudentRegistrationFormComponent().selectGender(gender);
    }

    @And("I enter mobile as {string}")
    public void enterMobile(String mobile) {
        this.formsPage.getStudentRegistrationFormComponent().fillInMobile(mobile);
    }

    @And("I enter date of birth as {string}")
    public void enterDateOfBirth(String birthDate) {
        this.formsPage.getStudentRegistrationFormComponent().selectDate(birthDate);
    }

    @And("I enter subjects as {string}")
    public void enterSubjects(String subjects) {
        this.formsPage.getStudentRegistrationFormComponent().enterSubjects(subjects);
    }

    @And("I enter hobbies as {string}")
    public void enterHobbies(String hobbies) {
        this.formsPage.getStudentRegistrationFormComponent().checkHobbies(hobbies);
    }

    @And("I enter picture as {string}")
    public void enterPicture(String picture) {
//        this.formsPage.getStudentRegistrationFormComponent().selectPicture(picture);
    }

    @And("I enter current address as {string}")
    public void enterCurrentAdd(String currentAddress) {
        this.formsPage.getStudentRegistrationFormComponent().enterCurrentAdd(currentAddress);
    }

    @And("I enter state as {string}")
    public void enterState(String state) {
        this.formsPage.getStudentRegistrationFormComponent().enterState(state);
    }

    @And("I enter city as {string}")
    public void enterCity(String city) {
        this.formsPage.getStudentRegistrationFormComponent().enterCity(city);
    }

    @And("I submit student registration form")
    public void submitForm() {
        this.formsPage.getStudentRegistrationFormComponent().submit();
    }

    @Then("I should see Student Confirmation Modal is displayed")
    public void confirmStudentModal() {
        Assert.assertTrue(this.formsPage.getStudentRegistrationFormComponent().isConfirmationModalDispayled());
    }

}
