package first;

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
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class directdownload1 {
	
	
	
	public AndroidDriver dr;

	String timestamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String cs=dateFormat.format(date).toString();
		return cs;
	}
	void excel(String event, String Time) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/directDownload.xlsx");
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet s3=wb.getSheet("Sheet3");
	    int row=s3.getLastRowNum()+1;
	    s3.createRow(row).createCell(0).setCellValue(event);
	    s3.getRow(row).createCell(1).setCellValue(Time);
	    FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/directDownload.xlsx");
	    wb.write(fos);
	}
	
	void campaignShown(){
		try {
		dr.openNotifications();
   		WebDriverWait wait = new WebDriverWait(dr,500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/notification_title")));        
        String cs = timestamp();
		excel("Campaign Shown",cs);
		}
		catch(Exception e){
			System.out.println("error ");
		}
	}
	void campaignDismiss(){
		   try{
			   campaignShown();
			   WebElement el = dr.findElementById("launcher3.android.com.hivelauncher:id/notification_title");
					  Point p = ((Locatable)el).getCoordinates().onPage();
					Thread.sleep(2000);
					try {
						  dr.swipe(p.getX(),p.getY(),(p.getX()+200),p.getY(),500);
									  System.out.println("Swiped");
					}
					catch (Exception e )
					{
						System.out.println(e);
					}
					String cs = timestamp();
					excel("campaign dismissed",cs);    
				
			     dr.sendKeyEvent(AndroidKeyCode.HOME);		  
			     }
		         
		   	  catch(Exception e)
		 		{
		 			System.out.println("Exception occured " + e);
		 			 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 		}
	}
	
	
	void campaignClicked() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		 campaignShown();
		 dr.findElementById("launcher3.android.com.hivelauncher:id/notification_title").click();
		 String cs = timestamp();
		excel("campaign Clicked",cs);

	}
	
	void campaignDownloadStarted() throws EncryptedDocumentException, InvalidFormatException, IOException{
		campaignClicked();
		dr.openNotifications();
   		while(true){
   			try{
   				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn");
   				String cs = timestamp();
   				excel("Download Started",cs);
   				break;
   			}
   			catch(Exception e)
   			{
   				
   				
   			}
   		}
	}
	void campaignDownloadCancelled() throws InterruptedException
	{
		dr.openNotifications();
   		
		while(true){
   			try{
   				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn").click();
   				String cs = timestamp();
   				excel("download cancelled",cs);
   				break;
   			}
   			catch(Exception e)
   			{
   				
   				
   			}
   		}
	}
	
	void campaignInstallStarted(){
		dr.openNotifications();
   		while(true)
   		{
   			try{
   				dr.findElementById("android:id/text");
   				System.out.println(dr.findElementById("android:id/text").getText());
   				if(	dr.findElementById("android:id/text").getText().contains("Installing"))
   					{
   					String cs = timestamp();
   					excel("install started",cs);   	   				
   						break;
   					}
   				}
   			catch(Exception e)
   				{
   		
   				}
   		}
	
		
	}
	
	void campaignInstallFailed() throws EncryptedDocumentException, InvalidFormatException, IOException{
		dr.openNotifications();
		int check=0;
   		while(check==0){
   			try{
   				if(	dr.findElementById("android:id/text").getText().contains("Installing"))
					{
   					continue;
					}
   				else check=10;
   	   			}
   			catch(Exception e)
   			{
   				
   			}
   		}
   			try{
					dr.findElementByName("Successfully installed.");
					
				}
				catch(Exception e1)
				{
					String cs = timestamp();
					excel("Install successful",cs);
				}

   		}
	
	void campaignInstallSuccess()
	{
		dr.openNotifications();
   			try{
			dr.findElementByName("Successfully installed.");
			String cs = timestamp();
			excel("Installed successfully",cs);
			
		}
		catch(Exception e)
		{
			System.out.print("Not installed yet");
		}
		}
	
	void downloadCancelled() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException{
		for(int i=0;i<10;i++)
		{
			dr.openNotifications();
		   	//check presence of active download 
			if(	dr.findElementById("android:id/text").getText().contains("Installing"))
			{
				continue;
			}
			
			//interrupt the download via wi-fi or aeroplane mode 
			if(i%2==0)
			{
				Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 1");
		        Runtime.getRuntime().exec("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true");
		        dr.openNotifications();
		        Thread.sleep(5000);
		        try{
	   				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn");
	   				System.out.println("fwuvsfuvuwsfuwtfd");
		        }
	   			catch(Exception e)
	   			{
	   				String cs = timestamp();
	   					excel(" Download interrupted",cs);
	   				
	   			}
		   		WebDriverWait wait = new WebDriverWait(dr,1000);
		   		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.systemui:id/airplane")));
		   		Thread.sleep(3000);
		        Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 0");
		        Runtime.getRuntime().exec("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false");       
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/notification_title")));
			
			}
			else
			{
			    dr.sendKeyEvent(AndroidKeyCode.HOME);		 
				 dr.startActivity("com.android.settings", "com.android.settings.wifi.WifiPickerActivity");
				 if(dr.findElementById("com.android.settings:id/switch_text").getText().equals("On"))  
					 dr.findElementById("com.android.settings:id/switch_widget").click();
				
					 
				 Thread.sleep(5000);
				    try{
		   				dr.findElementById("launcher3.android.com.hivelauncher:id/dowload_cancel_btn");
		   			}
		   			catch(Exception e)
		   			{
		   				String cs = timestamp();
		   				excel(" Download interrupted",cs);
		   		   					
		   			}

			   		WebDriverWait wait = new WebDriverWait(dr,1000);
			   		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.systemui:id/airplane")));
			   		Thread.sleep(3000);
			   	 dr.sendKeyEvent(AndroidKeyCode.HOME);		 
				 dr.startActivity("com.android.settings", "com.android.settings.wifi.WifiPickerActivity");
				 if(dr.findElementById("com.android.settings:id/switch_text").getText().equals("Off"))  
					 dr.findElementById("com.android.settings:id/switch_widget").click();
			  		dr.openNotifications();
					 
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/notification_title")));
						
			}
			
		}
	}
@Test()
void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
campaignDownloadStarted();
downloadCancelled();	
//	campaignInstallStarted();
//	campaignInstallSuccess();
    
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
			capabilities.setCapability("noReset", true);

			capabilities.setCapability("appPackage","com.android.settings");
			capabilities.setCapability("appActivity","com.android.settings.Settings");
			dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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