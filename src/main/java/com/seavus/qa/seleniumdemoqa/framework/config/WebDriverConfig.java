package com.seavus.qa.seleniumdemoqa.framework.config;

import com.seavus.qa.seleniumdemoqa.framework.annotation.LazyConfiguration;
import com.seavus.qa.seleniumdemoqa.framework.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> langs = new HashMap<String, Object>();
        langs.put("de", "en");
        prefs.put("translate", "{'enabled' : true}");
        prefs.put("translate_whitelists", langs);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

}
