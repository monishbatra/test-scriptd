package first;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checklist {
Dimension size;
static int CountNotificationclicked=0;
static int NotificationAppeared=0;
	
int index =1;
public void excel1(int index,String a, String b, String c) throws EncryptedDocumentException, InvalidFormatException, IOException
{

	FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/App World AutomationChecklist.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet1");
	int row=s.getLastRowNum()+1;
	s.createRow(row).createCell(0).setCellValue(index);
	 s.getRow(row).createCell(1).setCellValue(a);
	 s.getRow(row).createCell(2).setCellValue(b);
	 s.getRow(row).createCell(3).setCellValue(c);
		
		  FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/App World AutomationChecklist.xlsx");
			wb.write(fos);
index++;
}
	
	public AndroidDriver dr;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	 @Test()
	  public void SearchAnApp() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		  
// To verify whether App world has 2 categories- APPS and GAMES
	 try
	    {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
		  
		if( dr.findElementsById("com.hiveinside.gamestore:id/tab_1").size()>0&& dr.findElementsById("com.hiveinside.gamestore:id/tab_2").size()>0)
		  {
			System.out.println("App world has 2 categories- APPS and GAMES both are present");
			 
		  }
  		excel1(index,"To verify whether App world has 2 categories- APPS and GAMES","pass","executed");

	    }
	    catch(Exception e)
	    {
	  		excel1(index,"To verify whether App world has 2 categories- APPS and GAMES","fail"," not executed");
	
	    }
		
		
//		 To verify details present for games/app in App world
		 try
		    {
		    dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
			  dr.findElementByName("App World").click();
			  dr.findElementByName("Games").click();
			  dr.findElementById("com.hiveinside.gamestore:id/card_view").click();
			dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
			
				
			if( dr.findElementsById("com.hiveinside.gamestore:id/text_name").size()>0&& dr.findElementsById("com.hiveinside.gamestore:id/text_publisher").size()>0&& dr.findElementsById("com.hiveinside.gamestore:id/text_size").size()>0&& dr.findElementsById("com.hiveinside.gamestore:id/button_download").size()>0)
			  {
				System.out.println("All details present for games/app in App world");
				 
			  }
			 dr.sendKeyEvent(AndroidKeyCode.BACK);
		  		excel1(index,"To verify details present for games/app in App world","pass","executed");

		    }
		    catch(Exception e)
		    {
		  		excel1(index,"To verify details present for games/app in App world","fail"," not executed");

		    }	
		
	

	 
//	 To verify the Search Keyword text after clicking on Search button
	 
	 try
	    {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
		  
		  List<WebElement> qw= dr.findElementsById("com.hiveinside.gamestore:id/search_keyword_text");
		  for(WebElement a : qw )
		  {
			  System.out.println(a.getText());
		  }
		excel1(index,"verify the Search Keyword text after clicking on Search button","pass","executed");
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
         Thread.sleep(1000);
	    }
	    catch(Exception e)
	    {
			excel1(index,"verify the Search Keyword text after clicking on Search button","fail"," not executed");
	
	    }
	 
//To verify the number of notification, multiple notification should not appear for single game
	 try
	    {
		 long startTime= System.currentTimeMillis();
		  dr.openNotifications();
		  List<WebElement> ca=dr.findElementsById("android:id/title");
         int ca2= ca.size();
         System.out.println("Notification Present =" +ca2); 
     	 Thread.sleep(500);
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
		  dr.findElementByName("Games").click();
		  dr.findElementById("com.hiveinside.gamestore:id/install_menu").click();
		  dr.findElementById("com.hiveinside.gamestore:id/title").click();
		  dr.openNotifications();
  List<WebElement> ca1=dr.findElementsById("android:id/title");
          int ca21= ca1.size();
          System.out.println("Notification Present =" +ca21); 		  
		  if(ca21 > ca2)
		  {
			  System.out.println("number of notification, multiple notification should not appear for single game");			  
		  }
		  excel1(index,"To verify the number of notification, multiple notification should not appear for single game","pass","executed");
	    }
	    catch(Exception e)
	    {
	    	excel1(index,"To verify the number of notification, multiple notification should not appear for single game","fail"," not executed");
	    }
	 
	 
// To verify the game status while downloading and installing
	try
	    {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
		  
		  dr.findElementByName("Games").click();
		  dr.findElementById("com.hiveinside.gamestore:id/category_type_text").click();
		  dr.findElementById("com.hiveinside.gamestore:id/text_name").click(); 
		  System.out.println(dr.findElementById("com.hiveinside.gamestore:id/text_name").getText()); 
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  System.out.println("Install Button clicked");
		  System.out.println(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText()); 
		  WebDriverWait wait = new WebDriverWait(dr,200);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Launch")));	 
		  System.out.println(dr.findElementByName("Launch").getText());
		  Thread.sleep(1000);
		    dr.sendKeyEvent(AndroidKeyCode.BACK);
            dr.sendKeyEvent(AndroidKeyCode.BACK);
		    dr.sendKeyEvent(AndroidKeyCode.BACK);
			  excel1(index,"To verify the game status while downloading and installing","pass","executed");

	    }
	    catch(Exception e)
	    {
			  excel1(index,"To verify the game status while downloading and installing","fail"," not executed");

	    }
	 
// To verify My games page functionality
	 try
	    {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click(); 
		  dr.findElementByName("Games").click();
		  dr.findElementById("com.hiveinside.gamestore:id/card_view").click();
		Comparable<String> str=  dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
		System.out.println(str);
		  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
		  WebDriverWait wait = new WebDriverWait(dr,200);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Launch")));
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  dr.findElementById("com.hiveinside.gamestore:id/action_my_downloads").click();
		  List<WebElement> t = dr.findElementsById("com.hiveinside.gamestore:id/text_name");
		  for (WebElement a : t)
		  {
			  if(a.getText().equals(str))
			  {
				
				  System.out.println("Validated in My games page");
				  excel1(index,"To verify My games page functionality","pass","executed");

				  break;
			  }
			  
		  }
		 
//To verify Games in notification panel		  
		dr.openNotifications();
		 List<WebElement> t1 = dr.findElementsById("android:id/title");
		  for (WebElement a : t1)
		  {
			  if(a.getText().equals(str))
			  {
				
				  System.out.println("Validated in notifiaction panel");
				  excel1(index,"To verify Games in notification panel	","pass","executed");

				  break;
				  
			  }
		  }
		  dr.sendKeyEvent(AndroidKeyCode.HOME);
	    }
	    catch(Exception e)
	    {
			  excel1(index,"To verify Games in notification panel	","fail"," not executed");

	    }
	 
//	 To verify the APP world state in No Internet connection
	 try
	    {
		 Thread.sleep(2000);
		 dr.startActivity("com.android.settings", "com.android.settings.wifi.WifiPickerActivity");
		 dr.findElementById("com.android.settings:id/switch_widget").click();
		 Thread.sleep(2000);
		    	dr.sendKeyEvent(AndroidKeyCode.HOME);
		    
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))");
			 WebElement fn1=dr.findElementByName("App World");
			 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("App World")).moveTo(394,149).release().perform();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Storage\"))").click();

			  ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Clear data\"))").click();
			  ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"OK\"))").click();
			  dr.sendKeyEvent(AndroidKeyCode.HOME);
			  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		 
		     dr.findElementByName("App World").click();
		  
		    if( dr.findElementsById("com.hiveinside.gamestore:id/text_no_internet_message").size()>0)
		  {
			System.out.println(dr.findElementById("com.hiveinside.gamestore:id/text_no_internet_message").getText());
			 
		  }
		  		excel1(index,"To verify the APP world state in No Internet connection","pass","executed");

	    }
	    catch(Exception e)
	    {
	  		excel1(index,"To verify the APP world state in No Internet connection","fail"," not executed");
	
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
			dr = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"),capabilities);
			dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@AfterMethod
public void afterMethod() {
	  
		if (dr != null) {
			dr.quit();
		}
	
}

	}