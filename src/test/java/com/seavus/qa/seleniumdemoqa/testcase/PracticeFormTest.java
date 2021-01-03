package com.seavus.qa.seleniumdemoqa.testcase;

import com.seavus.qa.seleniumdemoqa.SpringBaseTestNGTest;
import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import com.seavus.qa.seleniumdemoqa.framework.constant.FrameworkConstants;
import com.seavus.qa.seleniumdemoqa.framework.service.DataService;
import com.seavus.qa.seleniumdemoqa.page.toolsqa.FormsPage;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;

public class PracticeFormTest extends SpringBaseTestNGTest {

    private String pathLocation;

    @LazyAutowired
    private FormsPage formsPage;

    @LazyAutowired
    private DataService dataService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @BeforeTest
    public void init() {
        pathLocation = ClassLoader.getSystemClassLoader().getResource(FrameworkConstants.DATA_PATH).getPath();
    }

    @AfterTest
    public void tearDown() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }

    @Test(dataProvider = "getTestData")
    public void formsPageTest(String firstName,
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

        this.formsPage.goTo();
        this.formsPage.getStudentRegistrationFormComponent().fillInStudentForm(
                firstName, lastName, email, gender, mobile, birthday, subjects, hobbies, picture, currentAdd, state, city
        );
        this.formsPage.getStudentRegistrationFormComponent().submit();
        Assert.assertTrue(this.formsPage.getStudentRegistrationFormComponent().isConfirmationModalDispayled());
    }

    @DataProvider
    public Object[][] getTestData() throws IOException {
        return dataService.readDataFromExcelFile(pathLocation);
    }

}
