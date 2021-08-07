package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void newJobListing() throws InterruptedException {
    	    	
    	//Clicking on 'Post a job' link from Navigation Bar
    	driver.findElement(By.linkText("Post a Job")).click();
    	
    	//Enter email in the your email field
        WebElement emailField = driver.findElement(By.id("create_account_email"));
        emailField.sendKeys("stay@in.ibm.com");
        
      //Enter job title in the job title field
        WebElement jobTitleField = driver.findElement(By.id("job_title"));
        jobTitleField.sendKeys("Tester");
        
      //Enter location in the location field
        WebElement locationField = driver.findElement(By.id("job_location"));
        locationField.sendKeys("Hyderabad");
      
        //Selecting Full time option from 'Job Type' dropdown
        Select dropdown = new Select(driver.findElement(By.id("job_type")));
        dropdown.selectByVisibleText("Full Time");
        
        //Enter description
        //Switch to first iFrame on the page
        driver.switchTo().frame(0);
        //Perform operation on the first frame
        WebElement description = driver.findElement(By.xpath("//body[@id='tinymce']"));
        description.sendKeys("Tester FST Selenium");
        //Switch back to parent page
        driver.switchTo().defaultContent();
        
      //Enter Application email/URL
        WebElement appEmail = driver.findElement(By.name("application"));
        appEmail.sendKeys("test@ibm.com");
        
      //Enter Company Name
        WebElement compName = driver.findElement(By.id("company_name"));
       compName.sendKeys("IBM India Pvt. Ltd.");
     //Click on Preview Button
       WebElement previewButton = driver.findElement(By.xpath("//input[@name='submit_job']"));
      previewButton.click();
      
    //Click on Submit Listing Button
      WebElement submitListingButton = driver.findElement(By.xpath("//input[@id='job_preview_submit_button']"));
      submitListingButton.click();
    //Click on click here link
      WebElement clickHereLink = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));
      clickHereLink.click();
      
    //Clicking on 'jobs' link from Navigation Bar
  	driver.findElement(By.linkText("Jobs")).click();
  	//Verify the job created is present
  	Thread.sleep(5000);
    	  	
  	   }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}