package newtest;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Widgetplscing {
	int serial = 1;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
	  
	//excel.....
	
	void excel(String event,String No) throws Exception  
	  {  
		  FileInputStream fis = new FileInputStream("C://Users//56750//Desktop//deonach.xlsx");    
		  Workbook wb=WorkbookFactory.create(fis); 
		  Sheet s3=wb.getSheet("Sheet1"); 
		  int row=s3.getLastRowNum()+1;  
		  s3.createRow(row).createCell(0).setCellValue(serial);   
		  s3.getRow(row).createCell(1).setCellValue(event);
		  s3.getRow(row).createCell(2).setCellValue(No);
		  
		   FileOutputStream fos=new FileOutputStream("C://Users//56750//Desktop//deonach.xlsx");    
	  wb.write(fos); 
	  serial++;
	  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
@Test()
  public void Widget() throws Exception {
	  dr.sendKeyEvent(AndroidKeyCode.HOME);
 
	// scroll widgets untill deonach is found
	
	  Thread.sleep(1000);  
		WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
		new TouchAction((MobileDriver) dr).longPress(fn).perform();
	  dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
	 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Deonach\"))");
	 WebElement fn1=dr.findElementByName("Deonach");
	 System.out.println("Deonach found");
	 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Deonach")).moveTo(218, 64).release().perform();
	 
	 excel("deonach found?","yes");
	 
	 dr.sendKeyEvent(AndroidKeyCode.HOME);
	 
      
     String line;
     Process p = Runtime.getRuntime().exec("adb shell dumpsys package launcher3.android.com.hivelauncher | grep versionName");
     BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    int w=0;
	 while ((line = input.readLine()) != null) {
    	 System.out.println(line);
if(w==0)
{
excel("version name - ",line);
w++;
}    
     }
     input.close();
     
    
    //deonach placed and removed...
    
     int i=0;
     for(i=0;i<5;i++){ 
      try
      {
      dr.sendKeyEvent(AndroidKeyCode.HOME);
      Thread.sleep(2000);
      
    
      WebElement fn11=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
	  new TouchAction((MobileDriver) dr).longPress(fn11).perform();
dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
	 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Deonach\"))");
	 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Deonach")).moveTo(320,230 ).release().perform();
	 System.out.println("Deonach placed");
      }
      catch (Exception e)
      {
    	System.out.println("unable to place widget on home"+e);  
      }
     Thread.sleep(2000); 
     try{
    	 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Deonach")).moveTo(225,124 ).release().perform();
    	 System.out.println("Deonach removed");
         	 
     }
     catch(Exception e){
    	 System.out.println("unable to remove widget from home"+e);
     }
      
      }
     
     excel("number of times deonach placd and removed",""+i);
     
   Thread.sleep(1000);
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   Thread.sleep(2000);
   
 //deonach placed again
   
   WebElement fn11=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
	  new TouchAction((MobileDriver) dr).longPress(fn11).perform();
dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
	 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Deonach\"))");
	 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Deonach")).moveTo(320,230 ).release().perform();
	 System.out.println("Deonach placed");
   
   Thread.sleep(2000); 
 
   
   //Refreshing Deonach .. times
 
	   for(i=0;i<5;i++){
   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_refresh").click();
   System.out.println("refresh button clicked");
  
   Thread.sleep(11000);
	   }
	   
	   excel("number of times deonach refreshed?",""+i);
	   
   //swipe to next page
   
   //dr.swipe(x1,y,x2,y2,second);
	   
	   for(i=0;i<5;i++){   
   dr.swipe(473, 426, 13, 508, 1000);
   Thread.sleep(2000);
	   }
	   
	   excel("number of times pages swiped?",""+i);
   
   
   //resizing deonach 50 times
	   
   for( i=0;i<5;i++)
   {
   dr.sendKeyEvent(AndroidKeyCode.HOME);	
   WebElement fn22=dr.findElementByClassName("android.appwidget.AppWidgetHostView");	
   new TouchAction((MobileDriver) dr).longPress(fn22).perform();	
   Thread.sleep(1000);
   //	dr.findElementByClassName("android.appwidget.AppWidgetHostView").click();	
   dr.swipe(237,415,249,562,2000);
   Thread.sleep(2000);	
   
   List<WebElement>  ab=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_image");
   int ab2=ab.size();
   System.out.println(ab2);
   
   if(ab2 == 8)
   {
	   System.out.println("maximum number of apps = 8 apps found when widget size is increased");
   }
   
   new TouchAction((MobileDriver) dr).longPress(fn22).perform();	
   Thread.sleep(1000);	
   dr.swipe(238,553,247,427,2000);	
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   
   List<WebElement>  cd=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_image");
   int cd1=cd.size();
   System.out.println(cd1);
   
   if(cd1 == 4)
   {
	   System.out.println("minimum number of apps = 4 apps found when widget size is decreased");
   }
   
System.out.println("Deonach resized");
   }
dr.sendKeyEvent(AndroidKeyCode.HOME);

excel("number of times deonach resized?",""+i);

   
   //launching four apps from deonach
   
   //launching first app from deonach
String appn="";
try{
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_one").click();
   List<WebElement> appname=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
    appn=appname.get(0).getText();
   System.out.println(appn);
   Thread.sleep(2000);
   System.out.println("app launched");
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   Thread.sleep(2000);
}
catch(Exception e)
{
	}
 
excel("First App Launched?",appn);


   //launching second app from deonach
String appn1="";
try{

   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_two").click();
   List<WebElement> appname1=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   appn1=appname1.get(0).getText();
   System.out.println(appn1);
   Thread.sleep(2000);
   System.out.println("app launched");
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   Thread.sleep(2000);
}
catch(Exception e)
{
}
excel("second App Launched?",appn1);


   //launching third app from deonach
   
String appn2="";

   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_three").click();
   List<WebElement> appname2=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   appn2=appname2.get(0).getText();
   System.out.println(appn2);
   Thread.sleep(2000);
   System.out.println("app launched");
   Thread.sleep(2000);
   
   excel("Third App Launched?",appn2);

   //read more
   
   String ActualResult = dr.findElementById("launcher3.android.com.hivelauncher:id/readMore").getText();  
   System.out.println(ActualResult);  
   String ExpectedResult = "READ MORE...";  
   Assert.assertEquals(ActualResult, ExpectedResult);  
   System.out.println(" Read more button is present ");
   
   dr.findElementById("launcher3.android.com.hivelauncher:id/readMore").click();
   
   System.out.println(" Read more button is clicked ");
   
   excel("Read More clicked?","Read more button is clicked");
   
   Thread.sleep(1000);
   
   //scroll untill readless is found and clicked.
   
   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"READ LESS...\"))");
	 WebElement fn2=dr.findElementByName("READ LESS...");
	 
   String ActualResult1 = dr.findElementById("launcher3.android.com.hivelauncher:id/readMore").getText();  
   System.out.println(ActualResult1);  
   String ExpectedResult1 = "READ LESS...";  
   Assert.assertEquals(ActualResult1, ExpectedResult1);  
   System.out.println(" Read Less button is present ");
   
   dr.findElementById("launcher3.android.com.hivelauncher:id/readMore").click();
   
   System.out.println("READ LESS... clicked");
	 
   excel("Read More clicked?","Read more button is clicked");
   
	 dr.sendKeyEvent(AndroidKeyCode.HOME);
	 
   Thread.sleep(1000);
   
   //launching fourth app from deonach
   
   String appn3="";
   try{
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_four").click();
   List<WebElement> appname3=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   appn3=appname3.get(0).getText();
   System.out.println(appn3);
   Thread.sleep(2000);
   System.out.println("app launched");
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   }
   catch(Exception e)
   {  
   }
   excel("Fourth App Launched?",appn3);
   
   String appn4="";
   try
   {
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_four").click();
   List<WebElement> appname4=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
    appn4=appname4.get(0).getText();
   System.out.println(appn4);
   Thread.sleep(2000);
   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_download").click();
   dr.openNotifications();
   excel("Downloaded App name",appn4);
   Thread.sleep(2000);
   
   try {
   
   if(dr.findElementsById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").size()>0);
   {
   dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").click();
   System.out.println("Cancel button clicked");
   excel(appn4,"Download cancelled");
   }
   
   }
   
	 
   catch(Exception e)
	{
	   
	   WebDriverWait wait = new WebDriverWait(dr,500);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Successfully installed.")));
	   System.out.println("App successfully downloaded");
	   excel(appn4,"downloaded successfully");
	}

      }
   catch (Exception e)
   {
 	System.out.println("App already downloaded"+e);  
   }
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   dr.openNotifications();
	
 	dr.swipe(222,609,222,166,1000);
 	

   try
   {
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_three").click();
   List<WebElement> appname5=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   String appn5=appname5.get(0).getText();
   System.out.println(appn5);
   Thread.sleep(2000);
  
   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_download").click();
   dr.openNotifications();
	while(true){
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").click();
		System.out.println("Download cancelled");		
	  break;
			}
			catch(Exception e)
			{
				try{
					dr.findElementByName("Successfully installed.");
					System.out.println("app successfully downloaded");
					break;
				}
				catch(Exception e1)
				{
					
				}	
				
			}
		} 

   }
   catch (Exception e)
   
   {
 	System.out.println("App already downloaded"+e);  
   }
   
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   dr.openNotifications();
	
 	dr.swipe(221,608,221,165,1000);
 	
  	
   try
   {
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_two").click();
   List<WebElement> appname6=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   String appn6=appname6.get(0).getText();
   System.out.println(appn6);
   Thread.sleep(2000);
   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_download").click();
   dr.openNotifications();
 	while(true){
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").click();
		System.out.println("Download cancelled");		
	  break;
			}
			catch(Exception e)
			{
				try{
					dr.findElementByName("Successfully installed.");
					System.out.println("app successfully downloaded");
					break;
				}
				catch(Exception e1)
				{
					
				}
				
			}
		}

   }
   catch (Exception e)
   {
 	System.out.println("App already downloaded"+e);  
   }
   
   dr.sendKeyEvent(AndroidKeyCode.HOME);
   dr.openNotifications();
	
  	dr.swipe(222,609,222,166,1000);
  	try
   {
   dr.findElementById("launcher3.android.com.hivelauncher:id/flipper_one").click();
   List<WebElement> appname7=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
   String appn7=appname7.get(0).getText();
   System.out.println(appn7);
   Thread.sleep(2000);
   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_download").click();
   dr.openNotifications();
 	while(true){
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").click();
		System.out.println("Download cancelled");		
	  break;
			}
			catch(Exception e)
			{
				try{
					dr.findElementByName("Successfully installed.");
					System.out.println("app successfully downloaded");
					break;
				}
				catch(Exception e1)
				{
					
				}
				
			}
		}

   }
  catch (Exception e)
  {
	System.out.println("App already downloaded"+e);  
  }
  
   dr.sendKeyEvent(AndroidKeyCode.HOME);  
   dr.openNotifications();
	
 	dr.swipe(221,610,221,165,1000);
 	
  	
   
    
   List<WebElement> d = dr.findElementsByClassName("android.widget.AdapterViewFlipper");
   for(i=0;i<4;i++)
   {
	   d.get(i).click();
		  
   try
   {
	   
	   dr.findElementById("launcher3.android.com.hivelauncher:id/btn_download").click();
	   List<WebElement> appname8=dr.findElementsById("launcher3.android.com.hivelauncher:id/app_name");
	   String appn8=appname8.get(0).getText();
	   System.out.println(appn8);
		WebDriverWait wait = new WebDriverWait(dr,500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/btn_open")));
	   	System.out.println("app successfully downloaded");
		dr.sendKeyEvent(AndroidKeyCode.HOME); 
	   break;
		 
  }
  catch (Exception e)
  {
	System.out.println("App already downloaded ");  
	dr.sendKeyEvent(AndroidKeyCode.HOME);  
	   
  }
   }
   
   //app present in app drawer
   //try{
   //dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	// ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"appn8\"))");
	// WebElement fn3=dr.findElementByName("appn8");
	// System.out.println("app ispresent in app drawer");
  // }
   //catch(Exception e)
   //{
	//   System.out.println("app is not present in app drawer");
  // }
   
  //network switching
   try{
  dr.startActivity("com.android.settings","com.android.settings.wifi.WifiPickerActivity");
  dr.findElementById("com.android.settings:id/switch_widget").click();
    dr.startActivity("com.android.phone", "com.android.phone.MobileNetworkSettings");
    dr.findElementByName("Preferred network type").click();
    dr.findElementByName("WCDMA only").click();
    System.out.print("Downloading in 3G");
   }
   catch(Exception e)
   {
	   
   }
    
    //facebook scroll
	  try{
    dr.sendKeyEvent(AndroidKeyCode.HOME);
    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
     
    ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Facebook\"))").click();
      Thread.sleep(15000);
     for(int r=0;r<15;r++)
          dr.swipe(256,671,256,219,3000);   
	  }
	  catch(Exception e){
		  
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
		capabilities.setCapability("noReset", true);

		capabilities.setCapability("appPackage","com.android.settings");
		capabilities.setCapability("appActivity","com.android.settings.Settings");
		dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	 
		if (dr != null) {
			dr.quit();
		}
	
  }

}
