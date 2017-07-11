package boost;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;









import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cdc{
	int index=0;
	AndroidDriver dr;
	public void playstore()
	 {
	 try{
	 
 
	 
	   
	 dr.sendKeyEvent(AndroidKeyCode.HOME);   
	dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Play Store\"))").click();
	try{
	dr.findElementById("com.android.vending:id/search_box_idle_text").click();
	}
	catch(Exception e)
	{
	}
	dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("State Bank Buddy");
	dr.findElementById("com.android.vending:id/suggest_text").click();
	try{
	dr.findElementById("com.android.vending:id/play_card").click();
	}
	catch(Exception e)
	{
	}
	dr.findElementById("com.android.vending:id/buy_button").click();
	try{
	dr.findElementById("com.android.vending:id/continue_button").click();
	}
	catch(Exception e)
	{
	}
	while(true)
	{
	try{
	dr.findElementById("com.android.vending:id/cancel_download");
	}
	catch(Exception e)
	{
	break;
	}
	}
	
	dr.sendKeyEvent(AndroidKeyCode.BACK);
	((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"APPS & GAMES\"))");
	try{
	dr.findElementById("com.android.vending:id/search_box_idle_text").click();
	}
	catch(Exception e)
	{
	}
	dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("Paytmpuzzel");
	dr.findElementById("com.android.vending:id/suggest_text").click();
	try{
	dr.findElementById("com.android.vending:id/play_card").click();
	}
	catch(Exception e)
	{
	}
	dr.findElementById("com.android.vending:id/buy_button").click();
	try{
	dr.findElementById("com.android.vending:id/continue_button").click();
	}
	catch(Exception e)
	{
	}
	while(true)
	{
	try{
	dr.findElementById("com.android.vending:id/cancel_download");
	}
	catch(Exception e)
	{
	break;
	}
	}
	dr.sendKeyEvent(AndroidKeyCode.HOME); 
	 
	 }
	 catch(Exception e)
	 {
	 System.out.println("Exception while downloading games");
	 }
	 
	 
	 
	 }

	void test(){
		
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
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"State Bank Buddy\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Jigsaw\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
		WebElement el = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_percentage_id");
		Point p = ((Locatable)el).getCoordinates().onPage();
		dr.swipe(p.getX(),(p.getY()-70),p.getX(),(p.getY()-70),1000);
		String ram = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
		String storage = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
		System.out.println(ram);
		System.out.println(storage);
		dr.findElementByName("Performance").click();
		for(int i=0;i<3;i++)
		{
			try{
				switch(i){
				case 0 :dr.findElementByName("Mischievous Apps"); System.out.println("Mischievous Apps sections present"); break;
				case 1 :dr.findElementByName("State Bank Buddy"); System.out.println("State Bank Buddy present"); break;
				case 2:	dr.findElementByName("Jigsaw"); System.out.println("jigsaw present"); break;
				}
				}
			catch(Exception e ){
				switch(i){
				case 1 : System.out.println("State Bank Buddy not present"); break;
				case 2:	 System.out.println("jigsaw not present"); break;
				
				}
			}
			
		}
		System.out.println("validating kill and resume button");
			while(true)
			{
				try
				{
					dr.findElementById("launcher3.android.com.hivelauncher:id/freeze_btn").click();
					dr.findElementById("android:id/button1").click();
				}
				catch(Exception e)
				{
					break;
				}
			}
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			String ram1 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
			String storage1 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
			System.out.println(ram1);
			System.out.println(storage1);
			System.out.println("pass");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			dr.findElementByName("Performance").click();
			for(int i=0;i<3;i++)
			{
				try{
					switch(i){
					case 0 :dr.findElementByName("Mischievous Apps"); System.out.println("Mischievous Apps sections present"); break;
					case 1 :dr.findElementByName("Downloads"); System.out.println("Downloads present"); break;
					case 2:	dr.findElementByName("Browser"); System.out.println("Browser present"); break;
					}
					}
				catch(Exception e ){
					switch(i){
					case 0 : System.out.println("Mischievous Apps section not present"); break;
					case 1 : System.out.println("Browser not present"); break;
					case 2 : System.out.println("Downloads not present"); break;
					
					}
				}
				
			}
			System.out.println("validating boost should not carry stock apps");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"State Bank Buddy\"))").click();
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Jigsaw\"))").click();
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			dr.findElementByName("Performance").click();
			for(int i=0;i<3;i++)
			{
				try{
					switch(i){
					case 0 :dr.findElementByName("Mischievous Apps"); System.out.println("Mischievous Apps sections present"); break;
					case 1 :dr.findElementByName("State Bank Buddy"); System.out.println("State Bank Buddy present"); break;
					case 2:	dr.findElementByName("Jigsaw"); System.out.println("Paytmpresent"); break;
					}
					}
				catch(Exception e ){
					switch(i){
					case 0 : System.out.println("State Bank Buddy not present"); break;
					case 1:	 System.out.println("Paytm not present"); break;
					
					}
				}
				
			}
			System.out.println("validating clean apps button");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			String ram3 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
			String storage3 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
			System.out.println(ram3);
			System.out.println(storage3);
			System.out.println("pass");
			String tmp="true";
			if(dr.findElementById("launcher3.android.com.hivelauncher:id/ram_clean_btn").getAttribute("enabled").equals(tmp))
				{
				System.out.println("CLean apps button working");
				dr.findElementById("launcher3.android.com.hivelauncher:id/ram_clean_btn").click();
				}
			else
				System.out.println("CLean apps button not working");

			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			String ram2 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
			String storage2 = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
			System.out.println(ram2);
			System.out.println(storage2);
			System.out.println("pass");
		
			System.out.println("validating delete duplicate image button");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
			dr.findElementByName("Storage").click();
			if(dr.findElementById("launcher3.android.com.hivelauncher:id/delete_all").getAttribute("enabled").equals("true"))
			{
				dr.findElementById("launcher3.android.com.hivelauncher:id/delete_all").click();
				System.out.println("Duplicate images found and deleted");
			}
			else
			{
				System.out.println("Duplicate images not found");
			}
	}
	  @Test()
  public void execute() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
			 dr.sendKeyEvent(AndroidKeyCode.HOME);   
				dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
				((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Play Store\"))").click();
				try{
				dr.findElementById("com.android.vending:id/search_box_idle_text").click();
				}
				catch(Exception e)
				{
				}
				dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("buddy");
				dr.findElementById("com.android.vending:id/suggest_text").click();
				try{
				dr.findElementById("com.android.vending:id/play_card").click();
				}
				catch(Exception e)
				{
				}
				dr.findElementById("com.android.vending:id/buy_button").click();
				try{
				dr.findElementById("com.android.vending:id/continue_button").click();
				}
				catch(Exception e)
				{
				}
				while(true)
				{
				try{
				dr.findElementById("com.android.vending:id/cancel_download");
				}
				catch(Exception e)
				{
				break;
				}
				}
//				row++;
				dr.sendKeyEvent(AndroidKeyCode.BACK);
				dr.sendKeyEvent(AndroidKeyCode.BACK);
				
				((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"APPS & GAMES\"))");
				try{
				dr.findElementById("com.android.vending:id/search_box_idle_text").click();
				}
				catch(Exception e)
				{
				}
				dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("paytm");
				dr.findElementById("com.android.vending:id/suggest_text").click();
				try{
				dr.findElementById("com.android.vending:id/play_card").click();
				}
				catch(Exception e)
				{
				}
				dr.findElementById("com.android.vending:id/buy_button").click();
				try{
				dr.findElementById("com.android.vending:id/continue_button").click();
				}
				catch(Exception e)
				{
				}
				while(true)
				{
				try{
				dr.findElementById("com.android.vending:id/cancel_download");
				}
				catch(Exception e)
				{
				break;
				}
				}
				dr.sendKeyEvent(AndroidKeyCode.HOME); 

		  test();
	 
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

