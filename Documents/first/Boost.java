package first;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Boost{
	

	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

	public void version()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		@SuppressWarnings("unchecked")
		List<WebElement> ca=dr.findElementsByClassName("android.widget.TextView");
		  int ca2=ca.size();
		  String tmp="";
		 for(int i=0;i<ca2;i++)
		 tmp=ca.get(i).getText();
		   System.out.println(tmp);
		   }
	
	public void languagePopUp()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Storage").click();
		dr.findElementByName("Clear data").click();
		dr.findElementByName("OK").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementByName("GOT IT").click();
		dr.findElementByName("GOT IT").click();
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		while(true)
		{
			try
			{
				dr.findElementByName("Allow").click();
			}
			catch(Exception e)
			{
				break;
			}
		}
		
		dr.findElementByName("Boost").click();
		while(true)
		{
			try
			{
				Thread.sleep(2000);
				String tmp =dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_percentage_id").getText();
				String a="0%";
				if(tmp.equals(a))
					System.out.println("Language selection page validated");
				else
					System.out.println(tmp+" "+a);
				break;
				
}
			catch(Exception e)
			{
				System.out.println("Language selection page is not validated");
				break;
			}
			
		}
		dr.swipe(191, 232, 191, 232, 1000);
		
		
	}
	
	public void validatingDashBoard() throws InterruptedException
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		Thread.sleep(10000);
		String tmp1=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_endurance_id").getText();
		String tmp2=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
		String tmp3=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
		String tmp4="";
		int i=0;
				if(tmp1.equals(tmp4)&&tmp2.equals(tmp4)&&tmp3.equals(tmp4))
					System.out.println("Dashboard is empty");
				else
					System.out.println("Dashboard is validated");
			
		}
	
	public void fabButton()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/fab");
			String tmp="true";
			String b=dr.findElementById("launcher3.android.com.hivelauncher:id/fab").getAttribute("clickable");
			if(tmp.equals(b))
				System.out.println("Fab Button is Present and working ");
		}
		catch(Exception e)
		{
			System.out.println("Fab Button Not Present");
		}
	}
	
	
	public void Sections()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		try{
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Battery\"))");
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))");
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))");
			  System.out.println("All sections are present.");
		}
		catch(Exception e)
		{
			System.out.println("All sections are not present.");
		}
	}
	
	public void batterySaver()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Battery\"))").click();
		try{
			
			dr.findElementByName("Automatic battery saver").click();
			String tmp="true";
			String b=dr.findElementByName("Never").getAttribute("enabled");
			if(tmp.equals(b))
				System.out.println("Battery saver mode is Present and working ");
		}
		catch(Exception e)
		{
			System.out.println("Battery saver mode Not Present");
		}
		
	}
	
	public void clearCache()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();
		try{
			
			//dr.findElementByName("Automatic battery saver").click();
			String tmp="Your memory is at optimal level.";
			String b=dr.findElementById("launcher3.android.com.hivelauncher:id/cache_size_text").getText();
			//System.out.println(b);
			
			if(tmp.equals(b))
				{
				System.out.println("Clear Cache is Present and working ");
				}
			else
				{
				Thread.sleep(2000);
			//	System.out.println("fdsfwd");
				dr.findElementById("launcher3.android.com.hivelauncher:id/cache_claener_btn").click();
				Thread.sleep(10000);
			//	System.out.println("fdsfwd");
				String b1=dr.findElementById("launcher3.android.com.hivelauncher:id/cache_size_text").getText();
				if(tmp.equals(b1))
					System.out.println("Clear Cache is Present and working ");
				else
					System.out.println("Clear Cache is not Present and not working");
					
				}
		}
		catch(Exception e)
		{
			System.out.println("Clear Cache is not Present and not working");
		}
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public void cleanApp()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Amazon Shopping\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Paytm\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		dr.findElementByName("Boost").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))").click();
		String tmp="true";
		if(dr.findElementById("launcher3.android.com.hivelauncher:id/ram_clean_btn").getAttribute("enabled").equals(tmp))
			System.out.println("CLean apps button working");
		else
			System.out.println("CLean apps button not working");
	}
	
	@SuppressWarnings("rawtypes")
	public void languageChange()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection").click();
		try{
			dr.findElementByName("English");
			System.out.println("Language change button not working");
		}
		catch(Exception e)
		{
			System.out.println("Language change button not working");
		
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public void KnowledgePopUps()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
		dr.findElementByName("Boost").click();
		dr.findElementByName("Storage").click();
		dr.findElementByName("Clear data").click();
		dr.findElementByName("OK").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementByName("GOT IT").click();
		dr.findElementByName("GOT IT").click();
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Amazon Shopping\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Paytm\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"BeautyPlus Me\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
		dr.swipe(191, 232, 191, 232, 1000);
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Prformance\"))").click();
		int i=0;
		while(true)
		{
			try{
				if(i<3)
				{
				dr.findElementByName("Kill").click();
				dr.findElementByName("Ok").click();
				i++;
				}
				else
				{
					System.out.println("Kill button working");
				}
			}
			catch(Exception e)
			{
				if(i<1)
					System.out.println("Kill button not working");
				else
					System.out.println("Kill button working");
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public void batterySettings()
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))").click();
		List<WebElement> ca=dr.findElementsByClassName("android.widget.ImageButton");
		ca.get(1).click();
		dr.findElementByName("Show system").click();
		try{
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"BatterySettingsService\"))");
			System.out.println("Battery saver settings present");	
		}
		catch(Exception e)
		{
			System.out.println("Battery saver settings present");
		}
		
		
	}
  @Test()
  public void execute() throws InterruptedException, IOException {
	 	

	  clearCache();
  }
  
  
	  		
  




@SuppressWarnings("rawtypes")
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
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  try{
		if (dr != null) {
			dr.quit();
		}
	  }
	catch(Exception e)
	  {
		System.out.println(e);
	  }
  }

}

