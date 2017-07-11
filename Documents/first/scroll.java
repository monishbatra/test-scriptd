package first;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class scroll {
	 Dimension size;
	
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
	
	public class LaunchApps {
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;

  @Test()
  public void ScrollDown() throws InterruptedException {
	  //dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	 //((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
	 /*    String s5=dr.findElementByName("Instagram").getText();
	   System.out.println(s5);
	   *///dr.findElementByName("Instagram").click();
	  Thread.sleep(5000);
	  dr.swipe(80,796,572,758,2000);
	   for(int r=0;r<100;r++)
	   dr.swipe(346,416,368,577,1000); // ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().Id(\"com.instagram.android:id/media_option_button\"))");
	  // dr.sendKeyEvent(AndroidKeyCode.HOME);

	  
	    Thread.sleep(1000);
		 }
  
	
	  @BeforeMethod
	  public void beforeMethod() throws MalformedURLException  {
		  
		  DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
				capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
				capabilities.setCapability("deviceName", "0123456789ABCDEF");
				capabilities.setCapability("platformName", "Android");

				capabilities.setCapability("appPackage","launcher3.android.com.hivelauncher");
				capabilities.setCapability("appActivity","com.android.launcher3.Launcher");
				dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
				dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
			if (dr != null) {
				dr.quit();
			}
		
	  }

		}}

  