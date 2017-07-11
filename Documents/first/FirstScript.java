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



public class FirstScript {
	 Dimension size;
	
	public AndroidDriver dr;
	
	public class LaunchApps {
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;
		
		
		

  @SuppressWarnings("unchecked")
@Test()
  public void SearchAnApp() throws InterruptedException {
	  
	  
	  Thread.sleep(3000);
	  //Find Paytm in search bar
	  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("paytm");
		String t=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
		String e="Paytm";
		if(t.equals(e))
        	System.out.println("Paytm found");
        	
		//Found Calender when only 3 letters entered
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("cal");
		t=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
		e="Calender";
		if(t.equals(e))
        	System.out.println("Calender found");
        
		//Multiple applications found for string 'ma'
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("ma");
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
		  int ca2=ca.size(); 
		  if(ca2>1)
			  System.out.println("Multiple apps found");
		  
		 //Play Store launched from Get It link
		  dr.sendKeyEvent(AndroidKeyCode.HOME);
		  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("water");
			dr.findElementByName("Get more on Google Play").click();
			
		//The Application search using number
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("0");
			ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
			ca2=ca.size(); 
			if(ca2>0)
				  System.out.println("apps found with name starting with number");
			else
				System.out.println("apps not found with name starting with number");
			  
		  //The Play Store Application found using Capital Letters
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("N");
			ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
			ca2=ca.size(); 
			if(ca2>0)
				  System.out.println("apps found");
			else
				System.out.println("apps not found");
			
			//The Application not found for the special Characters
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("#");
			ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
			ca2=ca.size(); 
			if(ca2>0)
				  System.out.println("apps found");
			else
				System.out.println("apps not found");
			
			//The cancel button functionality
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("a");
			dr.findElementById("launcher3.android.com.hivelauncher:id/ib_orientation");
			
			//The key board should be hidden after launching homescreen
			
			//sky swing Application found after installed, in the App Tray
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Play Store\"))").click();
	         dr.findElementByName("Play Store").click();
	         dr.findElementById("com.android.vending:id/search_box_idle_text").sendKeys("Sky swing");
	         dr.findElementById("com.android.vending:id/li_overflow").click();
	         dr.findElementById("com.android.vending:id/title").click();
	         dr.findElementById("com.android.vending:id/continue_button").click();
	         dr.sendKeyEvent(AndroidKeyCode.HOME);
	         Thread.sleep(60000);
	         dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	         try
	         {
	        	 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"SkySwings\"))");	 
	         System.out.println("Sky swings found");
	         }
	         catch(Exception e1)
	         {
	        	 System.out.println("Sky swings not found");
	         }
	         
	         //scroll till last App(Youtube) app on the App tray.
	         dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
	
			 //Welcome page is displayed
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"HiveLauncher\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();
			 dr.findElementById("com.android.settings:id/button").click();
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 Thread.sleep(30000);
			 try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_longpress_info");
			 System.out.println("Welcome cling found");
			 }
			 catch(Exception e1)
			 {
				 System.out.println("Welcome cling not found");
				 	 
			 }
			 	
			 //By default Analytics checkbox is enabled
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"HiveLauncher\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();
			 dr.findElementById("com.android.settings:id/button").click();
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 Thread.sleep(30000);
			 t=((WebElement) dr.findElements(By.className("android.widget.CheckBox"))).getAttribute("checked");
				e="True";
			 if(t.equals(e))
					System.out.println("Checked");
			 else
				 System.out.println("Not Checked");
			 
			 //Terms & condition link is working
			 dr.findElementByName("By using our Services, you are agreeing to these terms. Please read them carefully.").click();
			 Thread.sleep(3000);
			 System.out.println("TERMS AND CONDITION link is working");
			    dr.navigate().back();
			    
			 
			 //Permission to make a call displayed
			 //Permission for contacts displayed
			 //Permission for media & file access
			 //Permission for location displayed
			 //Ram Cleaner description displayed
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"HiveLauncher\"))").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();
			 dr.findElementById("com.android.settings:id/button").click();
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 Thread.sleep(3000);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_longpress_info").click();
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 Thread.sleep(3000);
			 int i = 0;
			 try{
				 for(i=0;i<5;i++)
				 {
					 
					 dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
					 System.out.println(i+" permission cling appeared");
				 }
				 dr.findElementByName("launcher3.android.com.hivelauncher:id/cling_dismiss_ramcleaner_info").click();
			 }
			 catch(Exception e1)
			 {
				 System.out.println(i+" permission cling is not appearing");
			 }
			
			 
		// Expected home screens after clearing the Launcher is 3
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/inactive");
				ca2=ca.size();
				if(ca2==2)
					System.out.println("3 Default workspaces");
				else
					System.out.println("not 3 Default workspaces");
				
		//By default the google search bar is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				ca=dr.findElementsById("com.google.android.googlequicksearchbox:id/default_search_widget");
				ca2=ca.size();
				if(ca2==1)
					System.out.println("Google search bar found");
				else
					System.out.println("Google search bar not found");
			 
		//By default the google folder is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				try {
					dr.findElementByName("Google");
					System.out.println("Google folder found");
				} 
				catch (Exception e2) {
					System.out.println("Google folder not found");
				}
				
				
		//By default the play store is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				try {
					dr.findElementByName("Play Store");
					System.out.println("PlayStore found");
				} 
				catch (Exception e2) {
					System.out.println("PlayStore not found");
				}
				
				
		//Only one widget is present on First Home screen
				
		//2 Apps are present in the 1st home screen
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				ca=dr.findElementsByClassName("android.widget.TextView");
				ca2=ca.size()-5;
				if(ca2==2)
					System.out.println("2 apps found");
				else
					System.out.println("More than or less than 2 apps found");
			 
		//By default the Cube26 Widget is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				dr.swipe(586,578,139,606,1000);
				try
				{
					dr.findElementByClassName("android.widget.LinearLayout");
					System.out.println("Cube 26 present");
				}
				catch(Exception e1)
				{
					System.out.println("Cube 26 not present");
				}
				
				
		//By default the Power Control Widget is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				try
				{
					dr.findElementByClassName("android.appwidget.AppWidgetHostView");
					System.out.println("power control widget present");
				}
				catch(Exception e1)
				{
					System.out.println("power control widget not present");
				}
				
		//No Apps are present on second screen
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				ca=dr.findElementsByClassName("android.widget.TextView");
				ca2=ca.size();
				System.out.println(ca2+" apps present");
				
		//By default the clock widget is present
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				try
				{
					dr.findElementById("com.android.deskclock:id/analog_appwidget");
					System.out.println("clock widget present");
				}
				catch(Exception e1)
				{
					System.out.println("clock widget not present");
				}
				
		//By default the Gallery app is present
		//By default the Settings app is present

				dr.sendKeyEvent(AndroidKeyCode.HOME);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				dr.swipe(586,578,139,606,1000);
				Thread.sleep(2000);
				ca=dr.findElementsByClassName("android.widget.TextView");
				ca2=ca.size();
				for(i=0;i<ca2;i++)
				{
					t=ca.get(i).getText();
					e="Gallery";
					if(t.equals(e))
					{
						System.out.println("Gallery present");
						break;
					}
				}
				if(i>ca2)
					System.out.println("Gallery not present");
	
				for(i=0;i<ca2;i++)
				{
					t=ca.get(i).getText();
					e="Settings";
					if(t.equals(e))
					{
						System.out.println("Settings present");
						break;
					}
				}
				if(i>ca2)
					System.out.println("Settings not present");
	
				//Notification Installed Successfully is displayed
				//All the applications installed present on Home Screen
				dr.sendKeyEvent(AndroidKeyCode.HOME);
				 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				 dr.findElementByName("Play Store").click();
				 ca=dr.findElementsByClassName("com.android.vending:id/li_thumbnail");
					ca2=ca.size();
					
					for(i=0;i<3;i++)
					{
						ca.get(i).click();
						dr.findElementById("com.android.vending:id/buy_button").click();
						dr.sendKeyEvent(AndroidKeyCode.BACK);
					}
					dr.sendKeyEvent(AndroidKeyCode.HOME);
					dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
					for(i=0;i<3;i++)
					{
						try{
							dr.findElementByName(ca.get(i).getText());
							System.out.println(ca.get(i).getText()+" App present");
						}
						catch(Exception e1)
						{
							System.out.println("App not present");
						}
						dr.sendKeyEvent(AndroidKeyCode.BACK);
						dr.sendKeyEvent(AndroidKeyCode.BACK);
						dr.sendKeyEvent(AndroidKeyCode.BACK);
					}	
					dr.openNotifications();
					  Thread.sleep(2000);
					  for(i=0;i<3;i++)
						{
							try{
								dr.findElementByName(ca.get(i).getText());
								System.out.println(ca.get(i).getText()+" App present");
							}
							catch(Exception e1)
							{
								System.out.println("App not present");
							}
						}
	
					  //2 Apps are present on third screen
					  
					  dr.sendKeyEvent(AndroidKeyCode.HOME);
						dr.swipe(586,578,139,606,1000);
						Thread.sleep(2000);
						dr.swipe(586,578,139,606,1000);
						Thread.sleep(2000);
						dr.swipe(586,578,139,606,1000);
						ca=dr.findElementsByClassName("android.widget.TextView");
						ca2=ca.size()-15;
						if(ca2==2)
							System.out.println("Only two apps present");
						else
							System.out.println(ca2);
						
						//Wallpaper apply
						dr.sendKeyEvent(AndroidKeyCode.HOME);
						try{
							WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
							new TouchAction((MobileDriver) dr).longPress(fn).perform();
							 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
							 ca=dr.findElementsByClassName("launcher3.android.com.hivelauncher:id/wallpaper_image");
							 for(i=1;i<ca.size();i++)
							 {
								 dr.sendKeyEvent(AndroidKeyCode.HOME);
								 new TouchAction((MobileDriver) dr).longPress(fn).perform();
								 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
								 ca.get(i).click();
								 dr.findElementByName("Set wallpaper").click();
							 System.out.println(i+" wallpaper applied Succesfully");
							 
							 Thread.sleep(3000);
							 }  
							  }
							  catch(Exception e1)
								{
									System.out.println("Some Error while applying First wallpaper " + e);
									dr.sendKeyEvent(AndroidKeyCode.HOME);
									Thread.sleep(3000);
								}
					
						
					  
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

