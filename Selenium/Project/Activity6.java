package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void searchAndApplyJob() throws InterruptedException {
    	//Clicking on 'jobs' link from Navigation Bar
    	driver.findElement(By.linkText("Jobs")).click();
    	
    	//Enter Job search  Keyword in the keyword field
        WebElement jobSearchKeyword = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        jobSearchKeyword.sendKeys("Banking");
        
      //Click on Submit button to get job search details
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
        submitButton.click();
        Thread.sleep(5000);
      //Click on first search result after job search
        
        WebElement bankJob = driver.findElement(By.xpath("//article[@id='post-7']/div/div/ul/li/a/div/div/strong"));
        bankJob.click();
        
      //Click on Apply for job button 
        WebElement applyJobButton = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        applyJobButton.click();
        
      //Find the Email link using className()
        WebElement emailLink = driver.findElement(By.className("job_application_email"));
        System.out.println("Email: " + emailLink.getText());                
                          
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        //driver.quit();
    }

}