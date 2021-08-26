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


public class Activity1 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "syedaEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        //caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void add() throws InterruptedException {
    	
    	// wait for page to load
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	
    	driver.findElementById("com.google.android.apps.tasks:id/welcome_get_started").click();
    	
    	//Adding and saving the first Task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        
      //Adding and saving the second Task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        
      //Adding and saving the third Task
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        
        // Assertion of the above three tasks
        String result1 = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Complete Activity with Google Tasks\")")).getText();
        System.out.println(result1);
        Assert.assertEquals(result1, "Complete Activity with Google Tasks");
        
        String result2 = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Complete Activity with Google Keep\")")).getText();
        System.out.println(result2);
        Assert.assertEquals(result2, "Complete Activity with Google Keep");
        
        String result3 = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Complete the second Activity Google Keep\")")).getText();
        System.out.println(result3);
        Assert.assertEquals(result3, "Complete the second Activity Google Keep");
    }
    


    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}