package first;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
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



public class AgingScenariosTest {
	 Dimension size;
	
	public AndroidDriver dr;
	void appName(String Appname)
	{
	    try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+Appname+"\"))");
		 WebElement fn=dr.findElementByName(Appname);
		 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName(Appname)).moveTo(431, 851).release().perform();
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 Thread.sleep(2000);
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}
	
	public class LaunchApps {
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;
		void homeScreen()
		{
			  dr.sendKeyEvent(AndroidKeyCode.HOME); 
				 
			  long startTime= System.currentTimeMillis();
			  try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			  @SuppressWarnings("unchecked")
				List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
				  int ca2=ca.size();
				
				  System.out.println("Apps Present in first set =" +ca2); 
				  for(int i=0;i<ca2;i++)
					  
				  {
					  String s=ca.get(i).getText();
					  System.out.println(s);
					  dr.findElementByName(s).click();
					  System.out.println("App  " +(i+1) +"   "  +s   +"  Launched");
					//  Thread.sleep(5000);
					    dr.sendKeyEvent(AndroidKeyCode.HOME);
					    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
					    ++CountAppsLaunched;
				  }
				  dr.sendKeyEvent(AndroidKeyCode.HOME);
			  }
			  catch(Exception e)
				{
					System.out.println("Exception While launching the apps " + e);
				}
		}

  @SuppressWarnings("unchecked")
@Test()
  public void SearchAnApp() throws InterruptedException {
	  
	  
	  Thread.sleep(3000);
	  
    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();

//    Random downloading from Apps & Games of Lava World
	  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
	  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
	  String str= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
	  System.out.println(str);
	  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
	  dr.findElementById("com.hiveinside.gamestore:id/title").click();
	  Thread.sleep(1000);
	  dr.sendKeyEvent(AndroidKeyCode.BACK);

	  dr.findElementByName("COMMUNICATION").click();
	  String str1= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
	  System.out.println(str1);
	  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
	  dr.findElementById("com.hiveinside.gamestore:id/title").click();
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  Thread.sleep(1000);
	 
	  
	  dr.findElementById("com.hiveinside.gamestore:id/tab_2").click();
	  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
	  String str2= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
	  System.out.println(str2);
	  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
	  dr.findElementById("com.hiveinside.gamestore:id/title").click();
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  dr.findElementByName("RACING").click();
	  String str3= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
	  System.out.println(str3);
	  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
	  dr.findElementById("com.hiveinside.gamestore:id/title").click();
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  Thread.sleep(1000);
	  
//Launching apps from App drawer
	homeScreen();
	  
	  
//Open Facebook and scrolling	  
	     dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Facebook\"))");
	     String s4=dr.findElementByName("Facebook").getText();
	     System.out.println(s4);
	   	 dr.findElementByName("Facebook").click(); 
	  	 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Shop Now\"))");
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
//Open Instagram and scrolling	  
	     dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
	     String s5=dr.findElementByName("Instagram").getText();
	     System.out.println(s5);
	   	 dr.findElementByName("Instagram").click(); 
	  	 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Install Now\"))");
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
//Again Open Lava World to download	
	 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	 dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
	 dr.findElementByName("action").click();
	 String str6= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
	  System.out.println(str6);
	  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
	  dr.findElementById("com.hiveinside.gamestore:id/title").click();
	  
	  dr.sendKeyEvent(AndroidKeyCode.BACK);
	  
	     
//Again Open Lava World to download	
	  try{
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
         dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
		 dr.findElementByName("action").click();
		  List<WebElement> ca=dr.findElementsById("com.hiveinside.gamestore:id/text_name"); 
		  int ca2=ca.size();
		  ca2= ca2-4;
		  if(ca2>=9)
			  ca2++;
		  AppsPresent=ca2;
		  System.out.println("Apps Present in first set =" +ca2); 
		  for(int i=0;i<ca2;i++)
		  {
			  String s=ca.get(i).getText();
			  System.out.println(s);
			  dr.findElementByName(s).click();
			  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
			  dr.sendKeyEvent(AndroidKeyCode.BACK);
			  System.out.println("App  " +(i+1) +"   "  +s  +"  Downloading");
			  
	     }}
  catch(Exception e){
	  System.out.println("fail to download" +e);
  }
	  dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  
// TO apply system wallpaper 
	  try{
		WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
		new TouchAction((MobileDriver) dr).longPress(fn).perform();
		 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
		 dr.findElementByName("Black Hole").click();
		 dr.findElementByName("Set wallpaper").click();
		 System.out.println("First wallpaper applied Succesfully");
		 Thread.sleep(3000);
		   
		  }
		  catch(Exception e)
			{
				System.out.println("Some Error while applying First wallpaper " + e);
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				Thread.sleep(3000);
			}
	  
	  
//Again Launching apps from App drawer
		homeScreen();
		  
//Creating Folder on Homescreen
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		
		for (int i = 1; i < 6; i++) {
			System.out.print(i +" ");
			String sd="";
			Thread.sleep(2000);
		try{
			switch(i){
				 
			    case 1 :
			    	sd="Gmail";
			    	appName(sd);
				   break;
				   
			    case 2 :
			    	sd="Email";
			    	appName(sd);
			    	break;
				   
			    case 3 :
			    	sd="Hangouts";
			    	appName(sd);
				   break;
				   
			    case 4 :
			    	sd="Music";
			    	appName(sd);
				   break;
				   
			    case 5 :
			    	sd="Maps";
			    	appName(sd);
				   break;		
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing " +i  +"th " +"case statement");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
		}}
	  
	  
	  
	  
	  
	  
	  
	  
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

