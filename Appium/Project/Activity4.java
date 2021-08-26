package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "syedaEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
     
        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSearchAppium() throws InterruptedException {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(10000);
        driver.get("https://www.training-support.net/selenium");
        Thread.sleep(10000);
        
     // Scroll to 'To-Do List' card element into view and click it
       driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").click();
       driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\")")).click();
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"To-Do List\").instance(0))")).click();
    
      //Adding and saving the first Task
        driver.findElementById("taskInput").sendKeys("Add tasks to list");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
        
      //Adding and saving the second Task
        driver.findElementById("taskInput").sendKeys("Get number of tasks");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
        
      //Adding and saving the third Task
        driver.findElementById("taskInput").sendKeys("Clear the list");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
        
        //Striking the first task
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add tasks to list")));
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
        
      //Striking the second task
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Get number of tasks")));
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
        
      //Striking the third task
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clear the list")));
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
        
        //Clearing the list
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear List\")")).click();
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}