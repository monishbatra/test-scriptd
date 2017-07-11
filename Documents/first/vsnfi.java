package first;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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



public class vsnfi {
	 Dimension size;
	
	public AndroidDriver dr;
	
	public class LaunchApps {
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;
		
		List<String> arr = new ArrayList<String>();
		String l="Launch";
		
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

	void singleAppFromAction(){
	dr.sendKeyEvent(AndroidKeyCode.HOME);
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
		 dr.findElementByName("action").click();
		 String str6= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
		  System.out.println(str6);
		  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
		  dr.findElementById("com.hiveinside.gamestore:id/title").click();
		  
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		
	}

		@SuppressWarnings("rawtypes")
		void facebookScroll() throws InterruptedException
		{
			try{
		//dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Facebook\"))");
		     String s4=dr.findElementByName("Facebook").getText();
		     System.out.println(s4);
		     dr.findElementByName("Facebook").click();
		     Thread.sleep(15000);
		  	 for(int r=0;r<15;r++)
			   	    dr.swipe(375,892,360,212,3000);

//	    dr.swipe(478,1005,368,149,5000);
		     dr.sendKeyEvent(AndroidKeyCode.HOME);
			}
			catch(Exception e)
			{
				System.out.println("Fb Not executed");
			}
		}
		
		void instaScroll() throws InterruptedException
		{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
		     String s5=dr.findElementByName("Instagram").getText();
		     System.out.println(s5);
		   	 dr.findElementByName("Instagram").click(); 
		   	 Thread.sleep(10000);
		  	 for(int r=0;r<15;r++)
		  		 dr.swipe(375,892,360,212,3000);
//	    dr.swipe(478,1005,368,149,5000);
		     dr.sendKeyEvent(AndroidKeyCode.HOME);
		}


		@SuppressWarnings("rawtypes")
		void launchAppFromLavaWorld() throws InterruptedException{
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
		  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
		  String str= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
		  System.out.println(str);
		  arr.add(str);
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  while (true)
		  {try{
		  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
		  break;}
		  catch(Exception e)
		  {
			  
		  }
		  }
		/*  Thread.sleep(4000);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  Thread.sleep(4000);
		  dr.findElementByName("COMMUNICATION").click();
		  String str1= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
		  System.out.println(str1);
		  arr.add(str1);
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  while (true)
		  {try{
		  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
		  break;}
		  catch(Exception e)
		  {
			  
		  }
		  }
		  Thread.sleep(4000);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  Thread.sleep(4000);
		  
		  
		  dr.findElementById("com.hiveinside.gamestore:id/tab_2").click();
		  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
		  String str2= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
		  System.out.println(str2);
		  arr.add(str2);
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  while (true)
		  {try{
		  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
		  break;}
		  catch(Exception e)
		  {
			  
		  }
		  }
		  Thread.sleep(4000);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  Thread.sleep(4000);
		  dr.findElementByName("RACING").click();
		  String str3= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();;
		  System.out.println(str3);
		  arr.add(str3);
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  while (true)
		  {try{
		  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
		  break;}
		  catch(Exception e)
		  {
			  
		  }
		  }
		  Thread.sleep(1000);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  Thread.sleep(4000);*/
		  }

	void applySystemWallpaper() throws InterruptedException
	{

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
		
	}

	void downloadMultileAppsFromActionInLavaWorld(){

	try{
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
	         dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
	         dr.findElementById("com.hiveinside.gamestore:id/cancel_icon").click();
			 dr.findElementByName("action").click();
			 Thread.sleep(4000);
			  List<WebElement> ca=dr.findElementsById("com.hiveinside.gamestore:id/text_name"); 
			  int ca2=ca.size();
			  ca2= ca2-4;
			  if(ca2>=8)
				  ca2++;
			  
			  System.out.println("Apps Present in first set =" +ca2); 
			  for(int i=0;i<ca2;i++)
			  {
				  String s=ca.get(i).getText();
				  System.out.println(s);
				  arr.add(s);
				  dr.findElementByName(s).click();
				  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
				  while (true)
				  {try{
				  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
				  break;}
				  catch(Exception e)
				  {
					  
				  }
				  }
				  dr.sendKeyEvent(AndroidKeyCode.BACK);
				  System.out.println("App  " +(i+1) +"   "  +s  +"  Downloading");
				  Thread.sleep(4000);
		     }}
	  catch(Exception e){
		  System.out.println("fail to download" +e);
	  }
	}
		
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
				  for(int i=0;i<4;i++)
					  
				  {
					  int w= (int)(Math.random() * 24) + 1;
					  String s=ca.get(w).getText();
					  System.out.println(s);
					  dr.findElementByName(s).click();
					  System.out.println("App  " +(w) +"   "  +s   +"  Launched");
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

  @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
@Test()
  public void SearchAnApp() throws InterruptedException {
	  
	  
	  Thread.sleep(3000);
	  
    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();

//    Random downloading from Apps & Games of Lava World
	launchAppFromLavaWorld();	  
//Launching apps from App drawer
//homeScreen();
  	  
//Open Facebook and scrolling	  
//facebookScroll();
	  
//Open Instagram and scrolling	  
	//    instaScroll();
	  
//Again Open Lava World to download single app from action category
//singleAppFromAction();	
	   
	     
//Again Open Lava World to download	
	// downloadMultileAppsFromActionInLavaWorld();
	 // dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  
// TO apply system wallpaper 
//	  applySystemWallpaper();  

//Again Launching apps from App drawer
	//	homeScreen();
		  
//Creating Folder on Homescreen
//	dr.sendKeyEvent(AndroidKeyCode.HOME);
	
	/*	for (int i = 1; i < 6; i++) {
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
	
		//Changing Font Size
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Display\"))").click();
//		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Font Size\"))").click();
		 dr.findElementByXPath("//android.widget.LinearLayout[@index='6']").click();	
		 dr.findElementByName("Huge").click();
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		
		  
	//Downloading Hill Climb from Lava World  
		 try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				
//					 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				 
				 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
			    dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
			    dr.findElementById("com.hiveinside.gamestore:id/cancel_icon").click(); 
			    dr.findElementById("com.hiveinside.gamestore:id/search_text").sendKeys("Hill Climb Racing 2");
				  String s1= "Hill Climb Racing 2";
				  Thread.sleep(5000);
				  dr.findElementById("com.hiveinside.gamestore:id/search_auto_complete_item_text").click();
				  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
				  String s2=dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
				  System.out.println(s2);
				  arr.add(s2);
					  
					         System.out.println("Hill Climb Racing 2 found");
					  //       dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
					         dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
					         System.out.println("Hill Climb Racing 2 found");
//					         dr.findElementById("com.hiveinside.gamestore:id/app_container").click();
//					         dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
					         while (true)
								  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
								  break;
								  
					         dr.sendKeyEvent(AndroidKeyCode.BACK);
					        dr.sendKeyEvent(AndroidKeyCode.BACK);
					         dr.sendKeyEvent(AndroidKeyCode.BACK);
					    	 dr.sendKeyEvent(AndroidKeyCode.HOME);
					    

						  
						  
				 
				  
				 }
				 catch(Exception e)
				 {
					 System.out.println("exception while downloading hill climb racing ");
				 }

	// Creating Loop inside Lava World

		 try{
	 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
		  dr.findElementByName("Games").click();
		  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  Thread.sleep(1000);
	   for(int i= 0; i<=2;i++)
	   {
				 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"MORE\"))").click();
				  String s=dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
				  System.out.println(s);
				  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
		  
		  String s3= "Similar apps";
	      System.out.println(s3);
	}
	   Thread.sleep(2000);
	   dr.sendKeyEvent(AndroidKeyCode.HOME);
	   dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	   
}
catch(Exception e)
{
	System.out.println("exception in lava world loop");
}
	   
	//Creating Loop inside Playstore
try
{
	 dr.sendKeyEvent(AndroidKeyCode.HOME);
	 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	 
	((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Play Store\"))").click();
Thread.sleep(10000);
		  dr.findElementByName("APPS & GAMES").click();
		  dr.findElementById("com.android.vending:id/cluster_header").click();
		  dr.findElementById("com.android.vending:id/li_title").click();
		  Thread.sleep(1000);
		  for(int i= 0; i<=2;i++){
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Similar apps\"))");
		  String str11=dr.findElementById("com.android.vending:id/li_title").getText();
		  System.out.println(str11);
		  dr.findElementById("com.android.vending:id/li_title").click();
	  }
		  
		  Thread.sleep(2000);
}
catch(Exception e)
{
	System.out.println("exception in loops");
}
	//   dr.sendKeyEvent(AndroidKeyCode.HOME);
		  
		 
	   
	 //Clear Data of Lava World  
	    try
	    {
	    	dr.sendKeyEvent(AndroidKeyCode.HOME);
	    
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))");
		 WebElement fn1=dr.findElementByName("Lava World");
		 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Lava World")).moveTo(394,149).release().perform();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();

		  ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Clear data\"))").click();
		  ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"OK\"))").click();
		  dr.sendKeyEvent(AndroidKeyCode.HOME);
		  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();

	    }
	    catch(Exception e)
	    {
	    	System.out.println("clear data not done");
	    }
	    
	    
	    
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();
		  dr.findElementByName("Lava World").click();
		  for(int r=0;r<5;r++)
		  {
			  if(r%2==0)
				  dr.findElementByName("Games").click();
			  else
				  dr.findElementByName("APPS").click();
		  }
	
	*/	  
		  //validating apps in app drawer
				  for(int r=0;r<arr.size();r++)
				  {
					int o=0;
					  String s = arr.get(r);
					  String[] words = s.split("\\s+");
					  for(int w=0;w<words.length;w++)
					  {
					  try{
						  String tmp = "";
						  for(o=0;o<w;o++)
							 if(o==0)
							  tmp = words[o];
							 else
								 tmp=tmp+" "+words[o];
						  dr.sendKeyEvent(AndroidKeyCode.HOME);
						  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
						// System.out.println(tmp);
						  ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+tmp+"\"))");
						  System.out.println(arr.get(r)+" app present in app drawer");
						  break;
					  	}
					  catch(Exception e2)
					  {
						  if(o==words.length-1)
						 System.out.println(arr.get(r)+" app not present in app drawer"); 
					  }
					  }
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

