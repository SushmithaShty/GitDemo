package utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver; // Global WebDriver instance
    public String landingPageproductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
	public String offerPageProductName;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        driver = testBase.WebDriverManager();     // ✅ Initializes driver
        testBase.driver = driver;                 // ✅ Explicitly assign it back (most important!)
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }


}
