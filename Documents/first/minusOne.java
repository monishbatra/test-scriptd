package first;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class minusOne {
	
	String Time;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void youtube()
	  {
		  try{
			  
			  FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s3=wb.getSheet("Sheet3");
				int row=s3.getLastRowNum()+1;
				
			    
			
		dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))").click();
			Time=getMobTime();
			
			s3.createRow(row).createCell(0).setCellValue("youtube Launched");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("youtube"));
			
		row++;

			for(int i=0;i<5;i++)
			{
				if(i==0){
				List<WebElement> sa=dr.findElementsById("com.google.android.youtube:id/thumbnail");
				
				sa.get(0).click();
				}
				Thread.sleep(1000);
				dr.swipe(329,1182,451, 470, 1000);
				Thread.sleep(10000);
				dr.findElementById("com.google.android.youtube:id/thumbnail").click();
				Thread.sleep(10000);
				
			}
			
			dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			Time=getMobTime();
			s3.createRow(row).createCell(0).setCellValue("youtube exit");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("youtube"));
			
		row++;

		FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);

  
			  
		  }
		  catch(Exception e)
		  {
			  
		  }
	  }
	  
	  
	  
	  @SuppressWarnings("rawtypes")
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
			dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("PayZapp");
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
			Time = getMobTime();
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
			
			s3.createRow(row).createCell(0).setCellValue("PayZapp downloaded from playstore ");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("PayZapp"));
			
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
			
			Time = getMobTime();
			
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
			 s3.createRow(row).createCell(0).setCellValue("Jigsaw puzzel downloaded from playstore ");
				s3.getRow(row).createCell(1).setCellValue(Time);
				s3.getRow(row).createCell(2).setCellValue(packageName("Jigsaw"));
			 dr.sendKeyEvent(AndroidKeyCode.HOME);	
			 
			  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				 		
			 		
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while downloading games");
		  }
			
			
		  
		  
		  
	  }
	
	public String packageName(String a){
		 String line="";
		 String o="";
		try{
			int count=0;
//			  Runtime.getRuntime().exec("adb kill-server");
//			  Thread.sleep(1000);
//			  Runtime.getRuntime().exec("adb start-server");
//			  Thread.sleep(1000);
		  String []q=a.split("\\s");
			  Process p = Runtime.getRuntime().exec("adb shell pm list packages | grep -i "+q[0]);
			  BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			  ArrayList<String> ans= new ArrayList<String>();  
	 while ((line = input.readLine()) != null) {
		    	  if(line.toLowerCase().contains("daemon"))
		    	  continue;
		    	  if(line.toLowerCase().contains("adb"))
			    	  continue;
		    	  ans.add(line);
		    	  count++;
		    	  o=o+line;
		      }
	// System.out.println(o+" gfdgdfgdfgdfd"+ " "+ count);
		      if(count>2)
		      {
		    	  o="";
		    	  
		    	 	
		    	  for(String w : ans) {
		    		    for(int i=0;i<q.length;i++)
		   		    	  {
		    		    	if(q.length>1)
		    		    		continue;
		//    		    	System.out.println(w+"     "+q[i]);
		   		    		  if(w.toLowerCase().contains(q[i].toLowerCase()))
		   		    		  {
		   		    			  
		   		    		  o=o+w;
		   		    		  count=100;
		   		    		  break;
		   		    		  }
		   		    	  }
		    	  if(count==100)
		    		  break;
		      }
		      }
		      
		      input.close();
			    if(o.equals(""))
			    {
			    o=ans.get(0);	
			    }
		
		}
		catch(Exception e)
		{
			o="package could not be received";
			System.out.println("exception while retreiving package name");
		}
	//	System.out.println(o);
		return o;
	}
	
	
	public String TimeStamp()
	{
		Date date = new Date();
		  String a = dateFormat.format(date).toString();
		  System.out.println(a);
		  return a;
	}
	
	public String getMobTime() throws IOException, InterruptedException{
		String line;
//		  Runtime.getRuntime().exec("adb kill-server");
//		  Thread.sleep(1000);
//		  Runtime.getRuntime().exec("adb start-server");
//		  Thread.sleep(1000);
		  Process p = Runtime.getRuntime().exec("adb shell date");
		  BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String o="";
	while ((line = input.readLine()) != null) {
		if(line.toLowerCase().contains("daemon"))
	  	  continue;
	  	  if(line.toLowerCase().contains("adb"))
		    	  continue;
		o=line;  
		break;
	}
	System.out.println(o);
	return o;
	}
	
	
	@SuppressWarnings("unchecked")
	void appLaunchFromAppDrawer() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		  dr.sendKeyEvent(AndroidKeyCode.HOME); 
			 
		  
			  
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		  FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s3=wb.getSheet("Sheet3");
			int row=s3.getLastRowNum()+1;
			
		  List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
			 for(int i=0;i<4;i++)
				  
			  {
				  int w= (int)(Math.random() * 20);
				
				  dr.findElementByName(ca.get(w).getText()).click();
				  Time = getMobTime();
					 
		//		  System.out.println("App  " +ca.get(w).getText() +"   "+"  Launched");
				//  Thread.sleep(5000);
				    dr.sendKeyEvent(AndroidKeyCode.HOME);
				    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				    s3.createRow(row).createCell(0).setCellValue("App launch event - "+ca.get(w).getText());
					s3.getRow(row).createCell(1).setCellValue(Time);
					s3.getRow(row).createCell(2).setCellValue(packageName(ca.get(w).getText()));
					
					row++;
				    
			  }
			  dr.sendKeyEvent(AndroidKeyCode.HOME);
			  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
		  
	}
	
	@SuppressWarnings("rawtypes")
	void message()
	{
		try
		{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Messaging\"))").click();
		dr.findElementById("com.android.messaging:id/start_new_conversation_button").click();
		dr.findElementById("com.android.messaging:id/recipient_text_view").sendKeys("08871558179");
		dr.findElementByName("Frequents").click();
		dr.findElementById("com.android.messaging:id/compose_message_text").sendKeys("Testing in progress");
		dr.findElementById("com.android.messaging:id/self_send_icon").click();
		Time = getMobTime();
		
	    
		Thread.sleep(5000);
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s3=wb.getSheet("Sheet3");
		int row=s3.getLastRowNum()+1;
		
	    s3.createRow(row).createCell(0).setCellValue("Message send event");
				s3.getRow(row).createCell(1).setCellValue(Time);
				
			    
		  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);
	
		}
		catch(Exception e)
		{
			System.out.println("could not send sms");
		}
		
	}
	
	
	
	void call()
	{
		try
		{
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		  dr.findElementByName("Phone").click();
			dr.findElementById("com.android.dialer:id/floating_action_button").click();
			dr.findElementById("com.android.dialer:id/digits").sendKeys("08871558179");
			dr.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();
			Time = getMobTime();
		    
			Thread.sleep(5000);
		try{
			dr.findElementById("com.android.dialer:id/floating_end_call_action_button").click();
		}
		catch(Exception e)
		{
			
		}
			 
			Thread.sleep(10000);
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s3=wb.getSheet("Sheet3");
			int row=s3.getLastRowNum()+1;
			s3.createRow(row).createCell(0).setCellValue("Call event");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("Phone"));
			
		    
	  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
		wb.write(fos);

			 
			
		// ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Appname + "\"))");
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	void setAlarm(){
		try{
			  dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
				dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
				((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Clock\"))").click();
				dr.findElementByClassName("android.widget.ImageView").click();
				dr.findElementById("com.android.deskclock:id/fab").click();
				List<WebElement> ca = dr.findElementsByClassName("android.widget.RadialTimePickerView$RadialPickerTouchHelper");
				dr.findElementById("android:id/hours").click();
				ca.get(6).click();
				dr.findElementById("android:id/minutes").click(); 
				ca.get(0).click();
				
				dr.findElementById("android:id/button1").click();
				dr.sendKeyEvent(AndroidKeyCode.BACK);
				Time=getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s3=wb.getSheet("Sheet3");
				int row=s3.getLastRowNum()+1;
				s3.createRow(row).createCell(0).setCellValue("set alarm event");
				s3.getRow(row).createCell(1).setCellValue(Time);
				s3.getRow(row).createCell(2).setCellValue(packageName("Clock"));
				
			    
		FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);
		 
				Thread.sleep(2000);
				dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
				

			
		}
		catch(Exception e)
		{
			System.out.println("Exception while setting alarm");
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void setTime(int h,int m)
	{
		try
		{
			m=m/5;
			if(m>6)
			m++;
			if(m>12)
				m=0;
			dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Date & time\"))").click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Set time\"))").click();
			List<WebElement> ca = dr.findElementsByClassName("android.widget.RadialTimePickerView$RadialPickerTouchHelper");
			dr.findElementById("android:id/hours").click();
			ca.get(h).click();
			dr.findElementById("android:id/minutes").click(); 
			ca.get(m).click();
			dr.findElementById("android:id/button1").click();
			Thread.sleep(2000);
			dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while setting time");
			
		}
	}
	@SuppressWarnings("rawtypes")
	public void uninstallApps()
	{
		try
		{
			  FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s3=wb.getSheet("Sheet3");
				int row=s3.getLastRowNum()+1;
			
  dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			  
			  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"PayZapp\"))");
			  WebElement fn=dr.findElementByName("PayZapp");
				 String tmp1 = packageName("PayZapp");
			  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("PayZapp")).moveTo(122, 198).release().perform();
			  dr.findElementByName("OK").click();
			  Time = getMobTime();
			  s3.createRow(row).createCell(0).setCellValue("PayZapp  uninstalled");
				s3.getRow(row).createCell(1).setCellValue(Time);
				s3.getRow(row).createCell(2).setCellValue(tmp1);
				
				row++;
			  
			  
dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			  
			  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Jigsaw\"))");
			  fn=dr.findElementByName("Jigsaw");
				tmp1 = packageName("jigsaw");
			  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Jigsaw")).moveTo(122, 198).release().perform();
			  dr.findElementByName("OK").click();
			  Time = getMobTime();
			  
			  s3.createRow(row).createCell(0).setCellValue("jigsaw puzzle uninstalled");
				s3.getRow(row).createCell(1).setCellValue(Time);
				s3.getRow(row).createCell(2).setCellValue(tmp1);
				
			    
		  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);
				
			  
			
			
		}
		catch(Exception e)
		{
			
		}
		
	}
	@SuppressWarnings("rawtypes")
	void facebookScroll() throws InterruptedException
	{
		try{
	//dr.sendKeyEvent(AndroidKeyCode.HOME);
			  FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s3=wb.getSheet("Sheet3");
				int row=s3.getLastRowNum()+1;
				
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Facebook\"))");
	     dr.findElementByName("Facebook").click();
	     Time = getMobTime();
	     s3.createRow(row).createCell(0).setCellValue("Facebook Launched");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("facebook"));
			
			row++;
			
			
	     Thread.sleep(15000);
	  	 for(int r=0;r<10;r++)
		   	    dr.swipe(375,892,360,212,3000);

//    dr.swipe(478,1005,368,149,5000);
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	     Time = getMobTime();
	     
	    	s3.createRow(row).createCell(0).setCellValue("Facebook exit");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("facebook"));
			
		    
	  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
		wb.write(fos);

			
		}
		catch(Exception e)
		{
			System.out.println("Fb Not executed");
		}
	}
	
	@SuppressWarnings("rawtypes")
	void instaScroll() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		 FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s3=wb.getSheet("Sheet3");
			int row=s3.getLastRowNum()+1;
		
	dr.sendKeyEvent(AndroidKeyCode.HOME);
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
	     String s5=dr.findElementByName("Instagram").getText();
	     System.out.println(s5);
	   	 dr.findElementByName("Instagram").click(); 
	   	Time = getMobTime();
		
	   	s3.createRow(row).createCell(0).setCellValue("Insta Launched");
		s3.getRow(row).createCell(1).setCellValue(Time);
		s3.getRow(row).createCell(2).setCellValue(packageName("instagram"));
		
		row++;
	   	 Thread.sleep(10000);
	  	 for(int r=0;r<10;r++)
	  		 dr.swipe(375,892,360,212,3000);
//    dr.swipe(478,1005,368,149,5000);
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	     Time = getMobTime();
			
	    	s3.createRow(row).createCell(0).setCellValue("Insta exit");
			s3.getRow(row).createCell(1).setCellValue(Time);
			s3.getRow(row).createCell(2).setCellValue(packageName("instagram"));
		    
	  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
		wb.write(fos);

	}

	void applySystemWallpaper() throws InterruptedException
	{

	try{
			WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
			new TouchAction((MobileDriver) dr).longPress(fn).perform();
			 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
			 dr.findElementByName("Black Hole").click();
			 dr.findElementByName("Set wallpaper").click();
			 Time = getMobTime();
				
			 System.out.println("First wallpaper applied Succesfully");
			 Thread.sleep(3000);
			 FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s3=wb.getSheet("Sheet3");
				int row=s3.getLastRowNum()+1;
				s3.createRow(row).createCell(0).setCellValue("System Wallpaper set");
				s3.getRow(row).createCell(1).setCellValue(Time);
				
			    
		  FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);
				
			  }
			  catch(Exception e)
				{
					System.out.println("Some Error while applying First wallpaper " + e);
					dr.sendKeyEvent(AndroidKeyCode.HOME);
					Thread.sleep(3000);
				}
		
	}

	
	
	
@SuppressWarnings("unchecked")
public void LandedOnMinusOnePage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{	
	int o=0;
	//if presently on langauage selection page
	try
	{
		dr.findElementByName("Welcome to Everfeed!");
		o++;
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
		String tmp=ca.get((int)Math.random()*7).getText();
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();
		ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/category_text");
		tmp=ca.get((int)Math.random()*(ca.size()-1)+1).getText();
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
		while(true)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
				Time = getMobTime();
				break;
			}
			catch(Exception e)
			{
			
			}
		}
		
	}
	catch(Exception e)
	{
		
	}
	// if presently on category selection page 
	try
	{
		dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
		o++;
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/category_text");
		String tmp=ca.get(2).getText();
		System.out.println(tmp);
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
		while(true)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
				Time = getMobTime();
				break;
			}
			catch(Exception e)
			{
			
			}
		}
	}
	catch(Exception e)
	{
		
	}
	//if presently on any other workspace
	if(o==0)
	{
	try{
		
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 Thread.sleep(4000);
		 dr.swipe(80,796,572,758,2000);
		 Time = getMobTime();
	   }
	catch(Exception e)
	{
		LandedOnMinusOnePage();
	}
	}
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Landed on minus one page");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	
}
public void exitFromMinusOnePageSwipe() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	dr.swipe(572,758,80,796,2000);
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("exit from minus one page through swipe");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	

}
public void exitFromMinusOnePageHome() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}dr.sendKeyEvent(AndroidKeyCode.HOME);
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("exit from minus one page through home button");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	

}
public void newsClick() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	Thread.sleep(1000);
	dr.swipe(360, 1161, 367, 280, 1000);
	dr.findElementById("launcher3.android.com.hivelauncher:id/tv_feed_content").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("news click event");
	s.getRow(row).createCell(1).setCellValue(Time);
	try{
		dr.findElementByName("Always").click();
		}
		catch(Exception e)
		{
			
		}
	while(true)
	{
		try
		{
			dr.findElementById("com.android.chrome:id/menu_button").click();
			dr.findElementById("com.android.chrome:id/button_two").click();
			
			String q = dr.findElementById("com.android.chrome:id/website_settings_url").getText();
			s.getRow(row).createCell(2).setCellValue(q);
	break;
		}
		catch(Exception e)
		{
			
		}
	}
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	

	}


@SuppressWarnings("unchecked")
public void landedOnCategoryPage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	int o=0;
	//if presently on language selection page
	try
	{	
		dr.findElementByName("Welcome to Everfeed!");
		o++;
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
		String tmp=ca.get((int)Math.random()*7).getText();
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();  
		while(true)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
				Time = getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet("Sheet2");
				int row=s.getLastRowNum()+1;
				
				s.createRow(row).createCell(0).setCellValue("landed On Category Page event");
				s.getRow(row).createCell(1).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				

				break;
			}
			catch(Exception e)
			{
				
			}
		}

	}
	catch(Exception e)
	{
		
	}
	//if presently on homescreen
	try
	{
		dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
		o++;
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
		String tmp=ca.get((int)Math.random()*7).getText();
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();  
		while(true)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
				Time = getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet("Sheet2");
				int row=s.getLastRowNum()+1;
				
				s.createRow(row).createCell(0).setCellValue("landed On Category Page event");
				s.getRow(row).createCell(1).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				

				break;
			}
			catch(Exception e)
			{
				
			}
		}
	
	}
	catch(Exception e)
	{
		
	}
	//if presently on any other workspace
	if(o==0)
	{
	try
	{
		LandedOnMinusOnePage();
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
		String tmp=ca.get((int)Math.random()*7).getText();
		dr.findElementByName(tmp).click();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();  
		while(true)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
				Time = getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet("Sheet2");
				int row=s.getLastRowNum()+1;
				
				s.createRow(row).createCell(0).setCellValue("landed On Category Page event");
				s.getRow(row).createCell(1).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				

				break;
			}
			catch(Exception e)
			{
				
			}
		}

	}
	
	catch(Exception e)
	{
		landedOnCategoryPage();
	}
	}	
}

public void landedOnLanguagePage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	int o=0;
	//if presently on home screen
	try
	{
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		
	dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
	o++;
	while(true)
	{
		try{
			dr.findElementByName("Welcome to Everfeed!");
			Time = getMobTime();
			FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet2");
			int row=s.getLastRowNum()+1;
			
			s.createRow(row).createCell(0).setCellValue("landed On Language Page event");
			s.getRow(row).createCell(1).setCellValue(Time);
			FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
			wb.write(fos);
			
			break;
		}
		catch(Exception e)
		{
			goToTopButtonClick();
			dr.swipe(302, 530, 338, 917, 1000);
			
		}
	}
	}
	catch(Exception e)
	{
		
	}
	//if presently on category selection page
		try
		{
			dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
			o++;
			dr.sendKeyEvent(AndroidKeyCode.BACK);
			while(true)
			{
				try{
					dr.findElementByName("Welcome to Everfeed!");
					Time = getMobTime();
					FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
					
					Workbook wb=WorkbookFactory.create(fis);
					Sheet s=wb.getSheet("Sheet2");
					int row=s.getLastRowNum()+1;
					
					s.createRow(row).createCell(0).setCellValue("landed On Language Page event");
					s.getRow(row).createCell(1).setCellValue(Time);
					FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
					wb.write(fos);
					
					break;
				}
				catch(Exception e)
				{
					
				}
			}
			
			
		}
		catch(Exception e)
		{
			
		}

	// if presently on any other workspace 
	if(o==0)
	{
	try
	{
		LandedOnMinusOnePage();
		dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
		
		while(true)
		{
			try{
				dr.findElementByName("Welcome to Everfeed!");
				Time = getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet("Sheet2");
				int row=s.getLastRowNum()+1;
				
				s.createRow(row).createCell(0).setCellValue("landed On Language Page event");
				s.getRow(row).createCell(1).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		
	}
	catch(Exception e)
	{
		landedOnLanguagePage();
	}
	}
}

public void onLoadNextPage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	Thread.sleep(1000);
	for(int i=0;i<15;i++)
		dr.swipe(375,892,360,212,500);
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("On Load Next event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	
	
}

@SuppressWarnings("unchecked")
public void onCategorySelection() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{	
try{
	dr.findElementById("launcher3.android.com.hivelauncher:id/category_select_text");
	
		
	}
	catch(Exception e)
	{
		landedOnCategoryPage();	
	}
	
	List<WebElement>ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/category_text");
	String tmp=ca.get(2).getText();
	System.out.println(tmp);
	dr.findElementByName(tmp).click();
	dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("On Category Selection event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
}
	  
@SuppressWarnings("unchecked")
public void onLanguageSelection() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementByName("Welcome to Everfeed!");
		
	}
	catch(Exception e)
	{
		landedOnLanguagePage();	
	}
	
	List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
	String tmp=ca.get((int)Math.random()*7).getText();
	dr.findElementByName(tmp).click();
	dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click(); 
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("On Language selection event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
}

public void languageChangeButtonClick() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Language change button click event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	
}

@SuppressWarnings("unchecked")
public void astroSignChange() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	int o=0;
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	try
	{
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		o=0;
		dr.findElementByName("Select your Sunsign");
		o++;
	while(true)
	{
		try{
	dr.findElementByName("Select your Sunsign").click();
	List<WebElement> ca=dr.findElementsById("android:id/text1");
	ca.get((int)Math.random()*(ca.size()-1)+1).click();
	dr.findElementByName("Done").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Astro sign change event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	break;
		}
		catch(Exception e)
		{
			
		}
		
	}
	}
	catch(Exception e)
	{
		
	}
	if(o==0)
	{
		while(true)
		{
			try{
				dr.findElementByName("Change Sign").click();
				List<WebElement> ca=dr.findElementsById("android:id/text1");
				String tmp=ca.get((int)Math.random()*12+1).getText();
				dr.findElementByName(tmp).click();
				dr.findElementById("android:id/button1").click();
				
				Time = getMobTime();
				FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
		
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet("Sheet2");
				int row=s.getLastRowNum()+1;
		
				s.createRow(row).createCell(0).setCellValue("Astro sign change event");
				s.getRow(row).createCell(1).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
				wb.write(fos);
				
				break;
			}
			catch(Exception e)
			{
				
			}
		
		}
	}
	
	
}

public void astroMoreClicked() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	try{
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		dr.findElementByName("Select your Sunsign");
		astroSignChange();
	}
	catch(Exception e)
	{
		
	}
	while(true)
	{
		try{
			goToTopButtonClick();
			dr.swipe(302, 530, 338, 917, 1000);
			System.out.println("tvuvtv");
	
			while(true){
				try{
	dr.findElementById("launcher3.android.com.hivelauncher:id/astro_more_text").click();
	//System.out.println("dafsdfdws");
	Time = getMobTime();
	break;
	}
				catch(Exception e)
				{
					
				}
				
			}
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Astro More Clicked event");
	s.getRow(row).createCell(1).setCellValue(Time);
	try{
	dr.findElementByName("Always").click();
	}
	catch(Exception e)
	{
		
	}
	while(true)
	{
		try
		{
			dr.findElementById("com.android.chrome:id/menu_button").click();
			dr.findElementById("com.android.chrome:id/button_two").click();
			
			String q = dr.findElementById("com.android.chrome:id/website_settings_url").getText();
			s.getRow(row).createCell(2).setCellValue(q);
			break;
		}
		catch(Exception e)
		{
			
		}
	}
	//System.out.println("fewdsfsdf");
		FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	break;
		}
		catch(Exception e)
		{
			
		}
		
		}
	
}

public void removingOfServiceCard() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	try{
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		dr.findElementByName("Select your Sunsign");
		astroSignChange();
	}
	catch(Exception e)
	{
		
	}
	
	while(true)
	{
		try{
	dr.findElementById("launcher3.android.com.hivelauncher:id/astro_card_overflow_button").click();
	dr.findElementByName("Remove card").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Removing of service card event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
	break;
		}
		catch(Exception e)
		{
			goToTopButtonClick();
			dr.swipe(302, 530, 338, 917, 1000);
			
		}
		
		}
	
}

public void goToTopButtonClick() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	Thread.sleep(1000);
	for(int i=0;i<5;i++)
	dr.swipe(375,892,360,212,1000);
	dr.findElementById("launcher3.android.com.hivelauncher:id/go_to_top").click();
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Go to top button click event");
	s.getRow(row).createCell(1).setCellValue(Time);
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
}
	  
public void topNewsClick() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	try{
		dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			
	}
	catch(Exception e)
	{
	LandedOnMinusOnePage();
	}
	Thread.sleep(1000);
	goToTopButtonClick();
	dr.swipe(302, 530, 338, 917, 1000);
	
	dr.findElementById("launcher3.android.com.hivelauncher:id/iv_feed_image_first").click();
	
	Time = getMobTime();
	FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Sheet2");
	int row=s.getLastRowNum()+1;
	
	s.createRow(row).createCell(0).setCellValue("Top news click event");
	s.getRow(row).createCell(1).setCellValue(Time);
	try{
		dr.findElementByName("Always").click();
		}
		catch(Exception e)
		{
			
		}
	while(true)
	{
		try
		{
			dr.findElementById("com.android.chrome:id/menu_button").click();
			dr.findElementById("com.android.chrome:id/button_two").click();
			
			String q = dr.findElementById("com.android.chrome:id/website_settings_url").getText();
			s.getRow(row).createCell(2).setCellValue(q);
	break;
	}
	catch(Exception e)	
		{
		goToTopButtonClick();
		dr.swipe(302, 530, 338, 917, 1000);
		
		}
	}
	FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/minusOne.xlsx");
	wb.write(fos);
	
}
void minusonescroll() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	int i=0;
	int tmp=15;
	int arr[]=new int[14];
	  while(i<50)
	  {
		  int tmp1=(int)(Math.random()*14);
		  
		  while(tmp==tmp1)
			  {
			  tmp1=(int)(Math.random()*14);
			  }
		  tmp=tmp1;
		  System.out.println(tmp1 + "in minusonescroll"+" "+ i);
		  if(arr[tmp1]<5)
		  {
				 switch(tmp)
				 {
					 case 0:
						 LandedOnMinusOnePage();
						 break;
						
						case 1:
						exitFromMinusOnePageSwipe();
						break;
						
						case 2:
						exitFromMinusOnePageHome();
						break;
						
						 case 3:
						 newsClick();
						 break;
						 
						 case 4:
						 landedOnLanguagePage();
						 break;
						 
						 case 5:
						 landedOnCategoryPage();
						 break;
						 
						 case 6:
						 onLoadNextPage();
						 break;
						 
						 case 7:
						 onCategorySelection();
						 break;
						 
						 case 8:
						 onLanguageSelection();
						 break;
						 
						 case 9:
						 languageChangeButtonClick();
						 break;
						 
						 case 10:
						 astroSignChange();
						 break;
						 
						 case 11:
						 astroMoreClicked();
						 break;
						 
						 case 14:
						 removingOfServiceCard();
						 break;
						 
						 case 13:
						 goToTopButtonClick();
						 break;
						 
						 case 12:
						 topNewsClick();
						 break;
						 
						 
				 }
				  

			 arr[tmp1]++; 
			 i++;
		  }
		
	  }
}


void appscroll() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	int i=0;
	int tmp=9;
	int arr[]=new int[9];
	  while(i<40)
	  {
		  int tmp1=(int)(Math.random()*9);
		  
		  while(tmp==tmp1)
			  {
			  tmp1=(int)(Math.random()*9);
			  }
		  tmp=tmp1;
		  System.out.println(tmp1+" in appscroll "+ i);
		  if(arr[tmp1]<4)
		  {
				 switch(tmp)
				 {
					 case 0:
						 appLaunchFromAppDrawer();
						 break;
						
						case 1:
							call();
						break;
						
						case 2:
							setAlarm();
							break;
						
						 case 3:
							// playstore();
								break;
						 
						 case 4:
							 uninstallApps();
								break;
						 
						 case 5:
							 facebookScroll();
								break;
						 
						 case 6:
							 instaScroll();
								break;
						 
						 case 7:
							 applySystemWallpaper();
								break;
						 
						 case 8:
							 youtube();
							 break;
						 
						 
				 }
				  

			 arr[tmp1]++; 
			 i++;
		  }
		
	  }
}

  @SuppressWarnings({ "unchecked", "rawtypes" })
@Test()
  public void SearchAnApp() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
//	 	  try{
//			  setTime(14,0); 
//		  }
//		  catch(Exception e){
//			  
//		  }
//	  try{
//			  minusonescroll(); 
//		  }
//		  catch(Exception e){
//			  
//		  }
	  //try{
//			  appscroll(); 
//		  }
//		  catch(Exception e){
//			  
//		  }
	  //try{
//			  setTime(21,0); 
//		  }
//		  catch(Exception e){
//			  
//		  }
//	  try{
//		  appscroll(); 
//	  }
//	  catch(Exception e){
//		  
//	  }
//	  try{
//		  appscroll(); 
//	  }
//	  catch(Exception e){
//		  
//	  }
	  
	  dr.swipe(100,200,300,400,1000);
	  	
	  
	  }
  
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException, InterruptedException  {
	  
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
			Thread.sleep(5000);
  }

  @AfterMethod
  public void afterMethod() {
	  
		if (dr != null) {
			dr.quit();
		}
	
  }

	}

