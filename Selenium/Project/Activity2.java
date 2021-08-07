package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void verifyWebsiteHeading() {
       //Get and Print the first header of the page
    	WebElement firstHeader = driver.findElement(By.xpath("//header/h1"));
        System.out.println("Text in First Header: " + firstHeader.getText());
            
            //Assertion for Header Text
        Assert.assertEquals("Welcome to Alchemy Jobs", firstHeader.getText());                   
                          
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}