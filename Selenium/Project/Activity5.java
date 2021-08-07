package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void navigateJobsPage() {
    	//Clicking on 'jobs' link from Navigation Bar
    	driver.findElement(By.linkText("Jobs")).click();
        // Check the title of the page after clicking on 'jobs' link
        String title = driver.getTitle();
            
        //Print the title of the 'jobs' page
        System.out.println("Page title is: " + title);
            
            //Assertion for page title
        Assert.assertEquals("Jobs – Alchemy Jobs", title);                   
                          
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}