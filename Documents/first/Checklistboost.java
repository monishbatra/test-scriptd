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

public class Checklist{
	int index=0;
	public void playstore()
	   {
	    try{
	    

	     
	     FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet s3=wb.getSheet("Sheet3");
	    int row=s3.getLastRowNum()+1;
	    
	       
	   
	    dr.sendKeyEvent(AndroidKeyCode.HOME);      
	   dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Play Store\"))").click();
	   try{
	    dr.findElementById("com.android.vending:id/search_box_idle_text").click();
	    
	   }
	   catch(Exception e)
	   {
	    
	   }
	   dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("payzapp");
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
	   
	  row++;
	   dr.sendKeyEvent(AndroidKeyCode.BACK);
	   
	   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"APPS & GAMES\"))");
	   try{
	    dr.findElementById("com.android.vending:id/search_box_idle_text").click();
	    
	   }
	   catch(Exception e)
	   {
	    
	   }
	   dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("jigsaw puzzel");
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
	    
	     FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	    wb.write(fos);
	       
	      
	    }
	    catch(Exception e)
	    {
	     System.out.println("Exception while downloading games");
	    }
	   
	   
	    
	    
	    
	   }
	public void excel1(int index,String a, String b) throws EncryptedDocumentException, InvalidFormatException, IOException
	{

	 FileInputStream fis = new FileInputStream("C:/Users/Monish/Documents/checklistt.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet s=wb.getSheet("Sheet1");
	 int row=s.getLastRowNum()+1;
	 s.createRow(row).createCell(0).setCellValue(index);
	  s.getRow(row).createCell(1).setCellValue(a);
	  s.getRow(row).createCell(2).setCellValue(b);
	  
	  
	    FileOutputStream fos=new FileOutputStream("C:/Users/Monish/Documents/checklistt.xlsx");
	   wb.write(fos);
	index++;
	}
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
	 
	  @Test()
	  public void SearchAnApp() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	      
	      String line;
	      Process p = Runtime.getRuntime().exec("adb shell dumpsys package launcher3.android.com.hivelauncher | grep versionName");
	      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	      while ((line = input.readLine()) != null) {
	        System.out.println(line);
	      }
	      input.close();
	  
	      }
	  
	      
	    
	  
	@SuppressWarnings("rawtypes")
	public void languagePopUp() throws EncryptedDocumentException, InvalidFormatException, IOException
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
				{
					System.out.println("Language selection page validated");
					excel1(index,"languagePopUp","pass");
					break;
				}
				else
				{
					System.out.println(tmp+" "+a);
				break;
				}
}
			catch(Exception e)
			{
				System.out.println("Language selection page is not validated");
				excel1(index,"languagePopUp","fail");
				break;
			}
			
		}
		WebElement el = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_percentage_id");
		Point p = ((Locatable)el).getCoordinates().onPage();
		dr.swipe(p.getX(),(p.getY()-70),p.getX(),(p.getY()-70),1000);
		dr.findElementById("launcher3.android.com.hivelauncher:id/fab").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		
	}
	
	public void validatingDashBoard() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
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
					{
					System.out.println("Content missing in Dashboard");
					excel1(index,"validating dashboard","fail");
					}
				else
				{
					System.out.println("Dashboard is validated");
					excel1(index,"validating dashboard","pass");
				}
		}
	
	public void fabButton() throws EncryptedDocumentException, InvalidFormatException, IOException
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
			excel1(index,"validating fab button","pass");
		}
		catch(Exception e)
		{
			System.out.println("Fab Button Not Present");
			excel1(index,"validating fab button","fail");
		}
	}
	
	
	public void Sections() throws EncryptedDocumentException, InvalidFormatException, IOException
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
			  excel1(index,"validating Sections","pass");
		}
		catch(Exception e)
		{
			System.out.println("All sections are not present.");
			excel1(index,"validating sections","fail");
		}
	}
	
	public void batterySaver() throws EncryptedDocumentException, InvalidFormatException, IOException
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
			excel1(index,"Battery savermode","pass");
		}
		catch(Exception e)
		{
			System.out.println("Battery saver mode Not Present");
			excel1(index,"Battery saver mode","fail");     	
		}
		
	}
	
	public void clearCache() throws EncryptedDocumentException, InvalidFormatException, IOException
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
				excel1(index,"validating clear cache button","pass");	
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
					{
					System.out.println("Clear Cache is Present and working ");
					excel1(index,"validating clear cache button","pass");
					}
				else
					{
					System.out.println("Clear Cache is not Present and not working");
					excel1(index,"validating clear cache button","fail");
					}
					
				}
		}
		catch(Exception e)
		{
			System.out.println("Clear Cache is not Present and not working");
			excel1(index,"validating clear cache button","fail");		
		}
		
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public void cleanApp() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"PayZapp\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Jigsaw\"))").click();
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))").click();
		String tmp="true";
		if(dr.findElementById("launcher3.android.com.hivelauncher:id/ram_clean_btn").getAttribute("enabled").equals(tmp))
			{
			System.out.println("CLean apps button working");
			excel1(index,"validating clean apps button","pass");
			}
		else
			System.out.println("CLean apps button not working");
		excel1(index,"validating clean apps button","fail");
	}
	
	@SuppressWarnings("rawtypes")
	public void languageChange() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Boost\"))").click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection").click();
		try{
			dr.findElementByName("English").click();
			System.out.println("Language change button working");
			excel1(index,"validating language change","pass");
		}
		catch(Exception e)
		{
			System.out.println("Language change button not working");
			excel1(index,"validating language change","fail");
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public void KnowledgePopUps() throws EncryptedDocumentException, InvalidFormatException, IOException
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
		dr.findElementByName("Boost").click();
		while(true)
		{
			try
			{
				Thread.sleep(2000);
				String tmp =dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_percentage_id").getText();
				String a="0%";
				if(tmp.equals(a))
					{
					System.out.println("Language selection page validated");
					excel1(index,"validating Knowledge popups","fail");
					}
				else
					System.out.println(tmp+" "+a);
				break;
				
}
			catch(Exception e)
			{
				System.out.println("Language selection page is not validated");
				excel1(index,"validating Knowledge popups","fail");
				break;
			}
			
		}
		WebElement el = dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_percentage_id");
		Point p = ((Locatable)el).getCoordinates().onPage();
		dr.swipe(p.getX(),(p.getY()-70),p.getX(),(p.getY()-70),1000);
		dr.findElementById("launcher3.android.com.hivelauncher:id/fab").click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))").click();
		//dr.swipe(191, 232, 191, 232, 1000);
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Performance\"))").click();
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
					break;
				}
			}
			catch(Exception e)
			{
				if(i<1)
					System.out.println("Kill button not working");
				else
					System.out.println("Kill button working");
				break;
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public void batterySettings() throws EncryptedDocumentException, InvalidFormatException, IOException
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
			excel1(index,"validating battery setting service","pass");
		}
		catch(Exception e)
		{
			System.out.println("Battery saver settings is not present");
			excel1(index,"validating battery settings","fail");
		}
		
		
	}
  @Test()
  public void execute() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
	 	
	  languagePopUp();
	  validatingDashBoard();
	  fabButton();
	  Sections();
	  batterySaver();
	  clearCache();
	  cleanApp();
	  languageChange();
	  KnowledgePopUps();
	  batterySettings();
	  
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

