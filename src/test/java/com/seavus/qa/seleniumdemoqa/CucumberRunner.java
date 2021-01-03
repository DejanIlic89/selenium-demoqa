package com.seavus.qa.seleniumdemoqa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        strict = true,
        tags = "@dev",
        features = "classpath:features",
        glue = "com.seavus.qa.seleniumdemoqa.bdd",
        plugin = {
                "pretty",
                "html:../test-output/"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
