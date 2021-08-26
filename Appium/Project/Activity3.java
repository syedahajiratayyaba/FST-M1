package appiumProject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;


public class Activity3 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "syedaEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void add() throws InterruptedException {
    	
    	// wait for page to load
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	
    	//driver.findElementById("com.google.android.keep:id/menu_pin").click();
    	
    	//Clicking on New Note button
        driver.findElementById("com.google.android.keep:id/new_note_button").click();
       //Clicking and sending keys to title field
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Google Keep Reminder Activity");
                
      //Clicking and sending keys to Notes field
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Note\")")).sendKeys("Notes of Google keep activity");
          
        //Clicking on reminder icon
        driver.findElementById("com.google.android.keep:id/menu_reminder").click();
        
        //Adding a reminder to the above note
        driver.findElementById("com.google.android.keep:id/menu_text").click();
        
        //Pinning the activity
        driver.findElementById("com.google.android.keep:id/menu_pin").click();
        
      //Going back to notes home page to perform assertions
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
    	
        // Assertion
        
        String result = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Google Keep Reminder Activity\")")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "Google Keep Reminder Activity");
        
       }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}