package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
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

    @Test(priority=1)
    public void correctLogin() throws InterruptedException {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.training-support.net/selenium");
        Thread.sleep(10000);
        
     // Scroll to 'To-Do List' card element into view and click it
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Popups\")")).click();
        //clicking on Signin button
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
        
     //Sending username and password to login
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"username\")")).sendKeys("admin");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"password\")")).sendKeys("password");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
        
        //assertion of successful login
      //Striking the third task
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Welcome Back, admin")));
             
        String result = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Welcome Back, admin\")")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "Welcome Back, admin"); 
    }
    
    @Test(priority=2)
    public void inCorrectLogin() throws InterruptedException {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(10000);
        driver.get("https://www.training-support.net/selenium");
        Thread.sleep(10000);
        
     // Scroll to 'To-Do List' card element into view and click it
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Login Form\")")).click();
      //clicking on Signin button
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
      //Sending username and password to login
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"username\")")).sendKeys("admin123");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"password\")")).sendKeys("paasssword");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
        
        //assertion of incorrect login
         
        String result = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Invalid Credentials\")")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "Invalid Credentials"); 
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}