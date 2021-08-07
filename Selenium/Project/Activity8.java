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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        
    }

    @Test
    //Getting parameters from xml file
    @Parameters({"username", "password"})
    public void backendSiteLogin(String username, String password) {
    	
    	Actions builder = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	
    	//Find the input fields
        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement passWord = driver.findElement(By.id("user_pass"));
        //Enter text
        userName.sendKeys(username);
        passWord.sendKeys(password);
        //Click Login Button
        driver.findElement(By.id("wp-submit")).click();
      
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
         //Assertion for page title to check if we are in the right page
        Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", title);                   
                            
      
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