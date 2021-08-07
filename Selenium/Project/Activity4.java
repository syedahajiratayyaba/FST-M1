package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void verifySecondHeading() {
       //Get and Print the second header of the page
    	WebElement secondHeader = driver.findElement(By.xpath("//h2"));
        System.out.println("Text in second Header: " + secondHeader.getText());
            
            //Assertion for Header Text
        Assert.assertEquals("Quia quis non", secondHeader.getText());                   
                          
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}