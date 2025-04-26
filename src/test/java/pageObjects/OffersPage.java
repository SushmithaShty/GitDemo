package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) 
    {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("tr td:nth-child(1)"); 

    public void searchItem(String name) 
    {
    	driver.findElement(search).clear(); 
        driver.findElement(search).sendKeys(name);
    }
    public void getSearchText() 
    {
    	driver.findElement(search).getText();
    }

    public String getProductName() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }
}