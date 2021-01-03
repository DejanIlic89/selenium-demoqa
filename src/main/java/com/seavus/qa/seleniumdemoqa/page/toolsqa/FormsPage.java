package com.seavus.qa.seleniumdemoqa.page.toolsqa;

import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyAutowired;
import com.seavus.qa.seleniumdemoqa.framework.annotation.Page;
import com.seavus.qa.seleniumdemoqa.page.Base;
import org.springframework.beans.factory.annotation.Value;

@Page
public class FormsPage extends Base {

    @Value("${application.url}")
    private String baseUrl;

    @Value("${application.practice.form}")
    private String practiceFormEndpoint;

    @LazyAutowired
    private StudentRegistrationFormComponent studentRegistrationFormComponent;

    @LazyAutowired
    private LeftSidePannelComponent leftSidePannelComponent;

    public void goTo() {
        this.driver.get(baseUrl + practiceFormEndpoint);
    }

    public StudentRegistrationFormComponent getStudentRegistrationFormComponent() {
        return this.studentRegistrationFormComponent;
    }

    public LeftSidePannelComponent getLeftSidePannelComponent() {
        return this.leftSidePannelComponent;
    }

    @Override
    public boolean isAt() {
        return this.studentRegistrationFormComponent.isAt();
    }
}
