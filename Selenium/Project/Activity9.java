package seleinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    
    @BeforeMethod
    public void backendJobListing() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        
    }

    @Test
    public void backendSiteLogin() throws InterruptedException {
    	
    	Actions builder = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	
    	//Find the input fields
        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));
        //Enter text
        userName.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        //Click Login Button
        driver.findElement(By.id("wp-submit")).click();
      
        // Check the title of the page
        String title = driver.getTitle();   
         //Assertion for page title to check if we are in the right page
        Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", title);  
      //Finding and clicking Job Listings button
        WebElement jobListing = driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']/a/div[3]"));
        jobListing.click();
      //Finding and clicking add new button
        WebElement addNewButton = driver.findElement(By.xpath("(//a[contains(text(),'Add New')])[7]"));
        addNewButton.click(); 
        
        //Thread.sleep(5000);

        //Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("components-modal__header")));
        //Find the dialog box close button
        WebElement closeButton = driver.findElement(By.cssSelector(".components-modal__header path"));
        
      //Hover over button
        builder.moveToElement(closeButton).pause(Duration.ofSeconds(1)).build().perform();
      //close
       closeButton.click();
     //Entering Position in the position field
       WebElement positionField = driver.findElement(By.xpath("(//div[contains(@id,'editor')])[2]"));
       positionField.sendKeys("Tester");
     //Entering company website in the company website field
       WebElement compWebsiteField = driver.findElement(By.id("_company_website"));
       compWebsiteField.sendKeys("IBM");
     //Entering company twitter details in the company twitter field
       WebElement compTwitterField = driver.findElement(By.id("_company_twitter"));
       compTwitterField.sendKeys("@IBM India Pvt Ltd");
     //Entering job location in the job location field
       WebElement jobLocationField = driver.findElement(By.id("_job_location"));
       jobLocationField.sendKeys("Hyderabad");  
     //Entering company name in the company name field
       WebElement compNameField = driver.findElement(By.id("_job_location"));
       compNameField.sendKeys("IBM India Pvt. Ltd.");  
     //Entering company tag line in the company tagline field
       WebElement tagLineField = driver.findElement(By.id("_company_tagline"));
       tagLineField.sendKeys("Brightening up lives!");   
     //Clicking on Publish Button
       WebElement publishButton = driver.findElement(By.xpath("//button[contains(.,'Publish')]"));
       publishButton.click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@class='block-editor-editor-skeleton__body']//button[contains(@class, 'post-publish')]")).click();
       
       
     //Wait for view job to appear
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".post-publish-panel__postpublish-buttons > .components-button")));
       //Find the dialog box close button
       WebElement viewJobButton = driver.findElement(By.cssSelector(".post-publish-panel__postpublish-buttons > .components-button"));
       
     //Hover over button
       builder.moveToElement(viewJobButton).pause(Duration.ofSeconds(1)).build().perform();
     //close
      viewJobButton.click();
    
     //Find Sign out button
       WebElement button = driver.findElement(By.className("display-name"));
      //Hover over button
        builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
      //Wait for Signout link to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
        driver.findElement(By.linkText("Log Out")).click();
      
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
       driver.quit();
    }

}