package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void headerImageURL() {
    	//Get the Image webelement
    	WebElement Image = driver.findElement(By.tagName("img"));

    	//Print the image URL to the console		
    	System.out.println("Image URL: "+Image.getAttribute("src"));
    	               
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}