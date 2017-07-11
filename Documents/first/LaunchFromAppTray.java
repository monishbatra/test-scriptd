package first;


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
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 class Excel {
	
	


	public void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
  //      Excel e=new Excel();
		

        
	}
	String path="C://Users/Nakul/Desktop/dbid.xlsx";

	void installed(String Appname,String  dateTime) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("path");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		//++row;
		
		int row=s.getLastRowNum()+1;
		s.createRow(row).createCell(0).setCellValue(Appname);
		s.getRow(row).createCell(1).setCellValue("Install");
		s.getRow(row).createCell(2).setCellValue(dateTime);
		FileOutputStream fos=new FileOutputStream("path");
		wb.write(fos);
	}
	
	void launched(String Appname,String  dateTime) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("path");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet2");
		//++row;
		int row=s.getLastRowNum()+1;
		s.createRow(row).createCell(0).setCellValue(Appname);
		s.getRow(row).createCell(1).setCellValue("Launch");
		s.getRow(row).createCell(2).setCellValue(dateTime);
		FileOutputStream fos=new FileOutputStream("path");
		wb.write(fos);
		
	}
	
	void uninstalled(String Appname,String  dateTime) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("path");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet3");
		//++row;
		int row=s.getLastRowNum()+1;
		s.createRow(row).createCell(0).setCellValue(Appname);
		s.getRow(row).createCell(1).setCellValue("uninstall");
		s.getRow(row).createCell(2).setCellValue(dateTime);
		FileOutputStream fos=new FileOutputStream("path");
		wb.write(fos);
	}
	
	
	void installedFromPlaystore(String Appname,String  dateTime) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("path");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet4");
		//++row;
		int row=s.getLastRowNum()+1;
		s.createRow(row).createCell(0).setCellValue(Appname);
		s.getRow(row).createCell(1).setCellValue("InstalledFromPlaystore");
		s.getRow(row).createCell(2).setCellValue(dateTime);
		FileOutputStream fos=new FileOutputStream("path");
		wb.write(fos);
	}
	
	
	void launchedFromAppTray(String Appname,String  dateTime) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("path");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet5");
		//++row;
		int row=s.getLastRowNum()+1;
		s.createRow(row).createCell(0).setCellValue(Appname);
		s.getRow(row).createCell(1).setCellValue("LaunchedFromAppTray");
		s.getRow(row).createCell(2).setCellValue(dateTime);
		FileOutputStream fos=new FileOutputStream("path");
		wb.write(fos);
	}
	
}

public class LaunchFromAppTray extends Excel{
	Excel e=new Excel();


	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @SuppressWarnings("rawtypes")
@Test()
  public void LaunchAppsFromAppTray() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	  

	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  @SuppressWarnings("unchecked")
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
		  int ca2=ca.size();
		
		  for(int i=0;i<ca2;i++)
		  {
			  String s=ca.get(i).getText();
			  dr.findElementByName(s).click();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				String dateTime=dateFormat.format(date).toString();
				System.out.println(dateTime); //2014/08/06 15:59:48
				e.launchedFromAppTray(s, dateTime);
			  System.out.println("App  " +(i+1) +"   "  +s   +"  Launched");
			  Thread.sleep(5000);
			    dr.sendKeyEvent(AndroidKeyCode.HOME);
			    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			    
			 
		  }
		 
		    dr.sendKeyEvent(AndroidKeyCode.HOME);
	  }
	  catch(Exception e)
		{
			System.out.println("Exception While launching the apps (1st Set) " + e);
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
		}
	  
	  try{
		  
		  
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  System.out.println("********------- Launching Second set of apps -----------******");
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
		  @SuppressWarnings("unchecked")
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
		  int ca2=ca.size();
		
		  System.out.println("Apps Present =" +ca2); 
		  for(int i=0;i<ca2;i++)
		  {
			  String s=ca.get(i).getText();
			  dr.findElementByName(s).click();
			  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				String dateTime=dateFormat.format(date).toString();
				System.out.println(dateTime); //2014/08/06 15:59:48
				e.launchedFromAppTray(s, dateTime);	 
			  System.out.println("App  " +(i+1) +"   "  +s   +"  Launched");
			  Thread.sleep(5000);
			    dr.sendKeyEvent(AndroidKeyCode.HOME);
			    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			    ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
	
		  }
		 
		  dr.sendKeyEvent(AndroidKeyCode.HOME);
	  }
	  catch(Exception e)
		{
			System.out.println("Exception While launching the apps (2nd Set) " + e);
		    dr.sendKeyEvent(AndroidKeyCode.HOME);
		}
	  
	
	  
	
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

