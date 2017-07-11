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


public class AgeingLAvaWorld {
	 Dimension size;
	
	
	
	String Time;
	public AndroidDriver dr;
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public String TimeStamp()
	{
		Date date = new Date();
		  String a = dateFormat.format(date).toString();
		
		  return a;
	}
	
	
	public class LaunchApps {
		int index=1;
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;
		
		List<String> arr = new ArrayList<String>();
		String l="Launch";
		
		@SuppressWarnings({ "rawtypes", "unused" })
		int ou=0;
		void appName(String Appname) throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			ou++;
		Time=TimeStamp();
		FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int row=s.getLastRowNum()+1;
		
		    try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+Appname+"\"))");
			 WebElement fn=dr.findElementByName(Appname);
			 new TouchAction((MobileDriver) dr).longPress(dr.findElementByName(Appname)).moveTo(431, 851).release().perform();
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 Thread.sleep(2000);
			if(ou==5)
			{
			 s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Folder creation");
			 s.getRow(row).createCell(2).setCellValue("Home Screen");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
			 index++;
			 row++;
			}
		    }
		    catch(Exception e)
		    {
		    if(ou==5)
		    {
		    	s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Folder creation");
				 s.getRow(row).createCell(2).setCellValue("Home Screen");
				 s.getRow(row).createCell(3).setCellValue("");
				 s.getRow(row).createCell(4).setCellValue("Fail");
				 s.getRow(row).createCell(5).setCellValue("Not Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
		    index++;
		    row++;
		    }
		    }
		    FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			wb.write(fos);
		}

	void singleAppFromAction() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Time=TimeStamp();
		FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int row=s.getLastRowNum()+1;
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
		 dr.findElementByName("action").click();
		 String str6= dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
		  System.out.println(str6);
		  dr.findElementById("com.hiveinside.gamestore:id/menu_container").click();
		  dr.findElementById("com.hiveinside.gamestore:id/title").click();
		  
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			wb.write(fos);
	}

		@SuppressWarnings({ "rawtypes", "unused" })
		void facebookScroll() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Time=TimeStamp();
			FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet1");
			int row=s.getLastRowNum()+1;
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
		  	System.out.println("Fb executed");
			s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Facebook Scroll");
			 s.getRow(row).createCell(2).setCellValue("Facebook");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		     dr.sendKeyEvent(AndroidKeyCode.HOME);
			}
			catch(Exception e)
			{
				System.out.println("Fb Not executed");
				s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Facebook Scroll");
				 s.getRow(row).createCell(2).setCellValue("Facebook");
				 s.getRow(row).createCell(3).setCellValue("");
				 s.getRow(row).createCell(4).setCellValue("Fail");
				 s.getRow(row).createCell(5).setCellValue("Not Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
		    index++;
		    row++;
			}
			FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			wb.write(fos);
		}
		
		void instaScroll() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Time=TimeStamp();
			FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet1");
			int row=s.getLastRowNum()+1;
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		try{
	        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
		     String s5=dr.findElementByName("Instagram").getText();
		     System.out.println(s5);
		   	 dr.findElementByName("Instagram").click(); 
		   	 Thread.sleep(10000);
		  	 for(int r=0;r<15;r++)
		  		 dr.swipe(375,892,360,212,3000);
//	    dr.swipe(478,1005,368,149,5000);
			  	System.out.println("Instagram executed");
		  	s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Instagram Scroll");
			 s.getRow(row).createCell(2).setCellValue("Instagram");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		}
		catch(Exception e)
		{
			s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Instagram Scroll");
			 s.getRow(row).createCell(2).setCellValue("Instagram");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		}
		     dr.sendKeyEvent(AndroidKeyCode.HOME);
		     FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		 	wb.write(fos);
		}


		@SuppressWarnings("rawtypes")
		void launchAppFromLavaWorld() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Time=TimeStamp();
			FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet1");
			int row=s.getLastRowNum()+1;
		try
		{
			dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
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
		  Thread.sleep(4000);
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
		  Thread.sleep(4000);
		  s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Downloading apps from App World ");
			 s.getRow(row).createCell(2).setCellValue("App World");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		}
		catch(Exception e)
		{
			s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Downloading apps from App World ");
			 s.getRow(row).createCell(2).setCellValue("App World");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		}
		  FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			wb.write(fos);
		  }

	void applySystemWallpaper() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Time=TimeStamp();
		FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int row=s.getLastRowNum()+1;
	try{
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
			new TouchAction((MobileDriver) dr).longPress(fn).perform();
			
			 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
			 dr.findElementByName("Black Hole").click();
			 dr.findElementByName("Set wallpaper").click();
			 System.out.println("First wallpaper applied Succesfully");
			 Thread.sleep(3000);
			 s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Applying system wallpaper");
			 s.getRow(row).createCell(2).setCellValue("Wallpapers");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
				FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
				wb.write(fos);
	    index++;
	    row++;
			   
			  }
			  catch(Exception e)
				{
					System.out.println("Some Error while applying First wallpaper " + e);
					
					s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Applying system wallpaper");
					 s.getRow(row).createCell(2).setCellValue("Wallpapers");
					 s.getRow(row).createCell(3).setCellValue("");
					 s.getRow(row).createCell(4).setCellValue("Fail");
					 s.getRow(row).createCell(5).setCellValue("Not Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
		
					index++;
					 row++;
					FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
					wb.write(fos);
					dr.sendKeyEvent(AndroidKeyCode.HOME);
					Thread.sleep(3000);
				}
		
	
	}

	@SuppressWarnings("unchecked")
	void downloadMultileAppsFromActionInLavaWorld() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Time=TimeStamp();
		FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int row=s.getLastRowNum()+1;
	try{
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
	         dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
	         dr.findElementById("com.hiveinside.gamestore:id/cancel_icon").click();
			 dr.findElementByName("action").click();
			 Thread.sleep(4000);
			  List<WebElement> ca=dr.findElementsById("com.hiveinside.gamestore:id/text_name"); 
//			  int ca2=ca.size();
//			  ca2= ca2-4;
//			  if(ca2>=8)
//				  ca2++;
			  
//			  System.out.println("Apps Present in first set =" +ca2); 
			  for(int i=0;i<3;i++)
			  {
				  String s1=ca.get(i).getText();
				  System.out.println(s1);
				  arr.add(s1);
				  dr.findElementByName(s1).click();
				  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
				  while (true)
				  {
					  try{
				  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
				  break;
				  }
				  catch(Exception e)
				  {
					  
				  }
				  }
				  dr.sendKeyEvent(AndroidKeyCode.BACK);
//				  dr.sendKeyEvent(AndroidKeyCode.BACK);
				  System.out.println("App  " +(i+1) +"   "  +s1  +"  Downloading");
				  Thread.sleep(4000);
				  
		     }
			  s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Downloading from search of App World");
				 s.getRow(row).createCell(2).setCellValue("App World");
				 s.getRow(row).createCell(3).setCellValue("Pass");
				 s.getRow(row).createCell(4).setCellValue("");
				 s.getRow(row).createCell(5).setCellValue("Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
		    index++;
		    row++;
	}
	  catch(Exception e){
		  System.out.println("fail to download" +e);
		  s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Downloading from search of App World");
			 s.getRow(row).createCell(2).setCellValue("App World");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
	  }
	FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
	wb.write(fos);
	}
		
		void homeScreen() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Time=TimeStamp();
			FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet1");
			int row=s.getLastRowNum()+1;
			  dr.sendKeyEvent(AndroidKeyCode.HOME); 
				 int qwe=0;
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
					  String s1=ca.get(w).getText();
					  System.out.println(s1);
					  dr.findElementByName(s1).click();
					  System.out.println("App  " +(w) +"   "  +s1   +"  Launched");
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
					qwe++;
				}
			  if(qwe>0)
			  {
				  s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Launching random apps from app drawer");
					 s.getRow(row).createCell(2).setCellValue("App drawer");
					 s.getRow(row).createCell(3).setCellValue("");
					 s.getRow(row).createCell(4).setCellValue("Fail");
					 s.getRow(row).createCell(5).setCellValue(qwe+" apps not launched");
						s.getRow(row).createCell(6).setCellValue(Time);
			    index++;
			    row++;
			  }
			  else
			  {
				  s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Launching random apps from app drawer");
					 s.getRow(row).createCell(2).setCellValue("App drawer");
					 s.getRow(row).createCell(3).setCellValue("Pass");
					 s.getRow(row).createCell(4).setCellValue("");
					 s.getRow(row).createCell(5).setCellValue("Executed");
						s.getRow(row).createCell(6).setCellValue(Time);
			    index++;
			    row++;
				  
			  }
			  FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
				wb.write(fos);
		}

  @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
@Test()
  public void SearchAnApp() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
  {
	  
	  Time=TimeStamp();
		
	  Thread.sleep(3000);
	
//    dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();

//    Random downloading from Apps & Games of App World
	launchAppFromLavaWorld();	
	//row++;
//Launching apps from App drawer
homeScreen();
//row++;  
//Open Facebook and scrolling	  
facebookScroll();
//row++;
//Open Instagram and scrolling	  
	    instaScroll();
	//    row++;

	 
//Again Open App World to download	
	 downloadMultileAppsFromActionInLavaWorld();
//	dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  
// TO apply system wallpaper 
  applySystemWallpaper();  
  //row++;
//Again Launching apps from App drawer
		homeScreen();
		//row++;  
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
		
		FileInputStream fis = new FileInputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int row=s.getLastRowNum()+1;

		
		
//Changing Font Size
		
		 try
		 {
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Display\"))").click();
//		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Font Size\"))").click();
		 dr.findElementByXPath("//android.widget.LinearLayout[@index='6']").click();	
		 dr.findElementByName("Huge").click();
		 Time=TimeStamp();
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 s.createRow(row).createCell(0).setCellValue(index);
		 s.getRow(row).createCell(1).setCellValue("Changing font size");
		 s.getRow(row).createCell(2).setCellValue("Font size");
		 s.getRow(row).createCell(3).setCellValue("Pass");
		 s.getRow(row).createCell(4).setCellValue("");
		 s.getRow(row).createCell(5).setCellValue("Executed");
			s.getRow(row).createCell(6).setCellValue(Time);
    index++;
    row++;
		 }
		 catch(Exception e)
		 {
			 Time=TimeStamp();
			 s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Changing font size");
			 s.getRow(row).createCell(2).setCellValue("Font size");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;
		 }
		  
	//Downloading Barfi from App World  
		 try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				
//					 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				 
				 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
			    dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
			    dr.findElementById("com.hiveinside.gamestore:id/cancel_icon").click(); 
			    dr.findElementById("com.hiveinside.gamestore:id/search_text").sendKeys("Barfi");
				  String s1= "Barfi";
//				  Thread.sleep(5000);
				  WebDriverWait wait = new WebDriverWait(dr,200);
			 	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.hiveinside.gamestore:id/search_auto_complete_item_text")));	 
				  dr.findElementById("com.hiveinside.gamestore:id/search_auto_complete_item_text").click();
				  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
				  String s2=dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
				  System.out.println(s2);
				  arr.add(s2);
					  
					         System.out.println("Barfi found");
					  //       dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
					         dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
					         Time=TimeStamp();
					         System.out.println("Barfi downloading");
//					         dr.findElementById("com.hiveinside.gamestore:id/app_container").click();
//					         dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
//					         
					        
					         
//					         Testing purpose
					         
					         //while (true)
//								  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals(l))
//								  break;
//								  else
//									  Thread.sleep(10000);
					         WebDriverWait wait1 = new WebDriverWait(dr,200);
					 		wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("Launch")));	  
					         dr.sendKeyEvent(AndroidKeyCode.BACK);
					        dr.sendKeyEvent(AndroidKeyCode.BACK);
					         dr.sendKeyEvent(AndroidKeyCode.BACK);
					    	 dr.sendKeyEvent(AndroidKeyCode.HOME);
					    	 s.createRow(row).createCell(0).setCellValue(index);
							 s.getRow(row).createCell(1).setCellValue("Downloading Barfi from App World");
							 s.getRow(row).createCell(2).setCellValue("App World");
							 s.getRow(row).createCell(3).setCellValue("Pass");
							 s.getRow(row).createCell(4).setCellValue("");
							 s.getRow(row).createCell(5).setCellValue("Executed");
								s.getRow(row).createCell(6).setCellValue(Time);
					    index++;
					    
row++;
		  
				 }
				 catch(Exception e)
				 {
					 Time=TimeStamp();
					 System.out.println("exception while downloading Barfi ");
					 s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Downloading Barfi from App World");
					 s.getRow(row).createCell(2).setCellValue("App World");
					 s.getRow(row).createCell(3).setCellValue("");
					 s.getRow(row).createCell(4).setCellValue("Fail");
					 s.getRow(row).createCell(5).setCellValue("Not Executed");
						s.getRow(row).createCell(6).setCellValue(Time);
			    index++;
			    row++;
				 }

	
		 
//	    Network Switching
		/* dr.startActivity("com.android.settings", "com.android.settings.wifi.WifiPickerActivity");
		 dr.findElementById("com.android.settings:id/switch_widget").click();
	    dr.startActivity("com.android.phone", "com.android.phone.MobileNetworkSettings");
	    dr.findElementByName("Preferred network type").click();
	    dr.findElementByName("WCDMA only").click();
	    System.out.print("Downloading in 3G");
	    Time=TimeStamp();
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
	    s.createRow(row).createCell(0).setCellValue(index);
		 s.getRow(row).createCell(1).setCellValue("switching to 3G");
		 s.getRow(row).createCell(2).setCellValue("Network switch");
		 s.getRow(row).createCell(3).setCellValue("Pass");
		 s.getRow(row).createCell(4).setCellValue("");
		 s.getRow(row).createCell(5).setCellValue("Executed");
			s.getRow(row).createCell(6).setCellValue(Time);
	index++;
	row++;
	    Thread.sleep(5000);
//	    3G
	    dr.startActivity("com.android.phone", "com.android.phone.MobileNetworkSettings");
	    dr.findElementByName("Preferred network type").click();
	    dr.findElementByName("GSM only").click();
	    System.out.print("Downloading in 2G");
	    Time=TimeStamp();
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
	    Thread.sleep(9000);
	    s.createRow(row).createCell(0).setCellValue(index);
		 s.getRow(row).createCell(1).setCellValue("switching to 2G");
		 s.getRow(row).createCell(2).setCellValue("Network switch");
		 s.getRow(row).createCell(3).setCellValue("Pass");
		 s.getRow(row).createCell(4).setCellValue("");
		 s.getRow(row).createCell(5).setCellValue("Executed");
			s.getRow(row).createCell(6).setCellValue(Time);
	index++;
	row++;
		 
*/
	   
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
		  if(dr.findElementsById("com.android.vending:id/buy_button").size()>0)
			 {
				  dr.findElementById("com.android.vending:id/buy_button").click();
			 }
		 
		  }
		  
	 
		  Time=TimeStamp();
		  Thread.sleep(2000);
		  s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("creating loops in Play store");
			 s.getRow(row).createCell(2).setCellValue("Play store");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++;
}
catch(Exception e)
{
	Time=TimeStamp();
	System.out.println("exception in loops");
	s.createRow(row).createCell(0).setCellValue(index);
	 s.getRow(row).createCell(1).setCellValue("creating loops in Play store");
	 s.getRow(row).createCell(2).setCellValue("Play store");
	 s.getRow(row).createCell(3).setCellValue("");
	 s.getRow(row).createCell(4).setCellValue("Fail");
	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		s.getRow(row).createCell(6).setCellValue(Time);
index++;
row++;
}
	   dr.sendKeyEvent(AndroidKeyCode.HOME);
		  
	   
	   
//	 Clearing Recents
	   try
	    {
	   dr.sendKeyEvent(AndroidKeyCode.HOME);
	   Thread.sleep(2000);
	   dr.sendKeyEvent(187);
		  Thread.sleep(5000);
		  dr.findElement(By.id("com.android.systemui:id/recents_remove_all")).click();
		  Thread.sleep(1000);
		  dr.sendKeyEvent(187);
		  String s5=dr.findElementByName("Your recent screens appear here").getText();
		  System.out.println(s5);
		  Time=TimeStamp();
	   
		  s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("clearing recents");
			 s.getRow(row).createCell(2).setCellValue("recent list");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++;
	    }
		catch(Exception e)
		{
			Time=TimeStamp();
			System.out.println("exception in loops");
			s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("clearing recents");
			 s.getRow(row).createCell(2).setCellValue("Play store");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++;
		}
			   dr.sendKeyEvent(AndroidKeyCode.HOME);
	
			   
//Opening -1 page and multiple times refreshing	
			   try
			    {
			      Thread.sleep(2000);
				  dr.swipe(80,796,572,758,2000);
				  Thread.sleep(2000);
				  for(int r=0;r<5;r++)
				  dr.swipe(346,416,368,577,1000);
				  dr.sendKeyEvent(AndroidKeyCode.HOME);
	   
				  Time=TimeStamp();
				   
				  s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Opening -1 page and multiple times refreshing	");
					 s.getRow(row).createCell(2).setCellValue("recent list");
					 s.getRow(row).createCell(3).setCellValue("Pass");
					 s.getRow(row).createCell(4).setCellValue("");
					 s.getRow(row).createCell(5).setCellValue("Executed");
						s.getRow(row).createCell(6).setCellValue(Time);
				index++;
				row++;
			    }
				catch(Exception e)
				{
					Time=TimeStamp();
					System.out.println("exception in loops");
					s.createRow(row).createCell(0).setCellValue(index);
					 s.getRow(row).createCell(1).setCellValue("Opening -1 page and multiple times refreshing	");
					 s.getRow(row).createCell(2).setCellValue("Play store");
					 s.getRow(row).createCell(3).setCellValue("");
					 s.getRow(row).createCell(4).setCellValue("Fail");
					 s.getRow(row).createCell(5).setCellValue("Not Executed");
						s.getRow(row).createCell(6).setCellValue(Time);
				index++;
				row++;
				}
					   dr.sendKeyEvent(AndroidKeyCode.HOME);
	   
//	Multiple times Landing and Exit from -1 page
//	 landing on -1 page
					   try
					    {
					   for(int i=0;i<=3;i++){
					   dr.sendKeyEvent(AndroidKeyCode.HOME);
					   Thread.sleep(4000);
					   dr.swipe(80,796,572,758,2000);
//	exit from -1
					   Thread.sleep(4000);
					   dr.swipe(572,758,80,796,2000);
					   }
	   
					   Time=TimeStamp();
					   
						  s.createRow(row).createCell(0).setCellValue(index);
							 s.getRow(row).createCell(1).setCellValue("Multiple times Landing and Exit from -1 page");
							 s.getRow(row).createCell(2).setCellValue("recent list");
							 s.getRow(row).createCell(3).setCellValue("Pass");
							 s.getRow(row).createCell(4).setCellValue("");
							 s.getRow(row).createCell(5).setCellValue("Executed");
								s.getRow(row).createCell(6).setCellValue(Time);
						index++;
						row++;
					    }
						catch(Exception e)
						{
							Time=TimeStamp();
							System.out.println("exception in loops");
							s.createRow(row).createCell(0).setCellValue(index);
							 s.getRow(row).createCell(1).setCellValue("Multiple times Landing and Exit from -1 page");
							 s.getRow(row).createCell(2).setCellValue("Play store");
							 s.getRow(row).createCell(3).setCellValue("");
							 s.getRow(row).createCell(4).setCellValue("Fail");
							 s.getRow(row).createCell(5).setCellValue("Not Executed");
								s.getRow(row).createCell(6).setCellValue(Time);
						index++;
						row++;
						}
							   dr.sendKeyEvent(AndroidKeyCode.HOME);
	   
//	 Go to Top clicks on -1 page
							   try
							    {
						    Thread.sleep(2000);
							dr.swipe(80,796,572,758,2000);
							Thread.sleep(2000);
							for(int j=0;j<5;j++){
							for(int i=0;i<5;i++)
	                         dr.swipe(375,892,360,212,1000);
							  
								   dr.findElementById("launcher3.android.com.hivelauncher:id/go_to_top").click();
							  }
							 Time=TimeStamp();
							   
							  s.createRow(row).createCell(0).setCellValue(index);
								 s.getRow(row).createCell(1).setCellValue("Go to Top clicks on -1 page");
								 s.getRow(row).createCell(2).setCellValue("recent list");
								 s.getRow(row).createCell(3).setCellValue("Pass");
								 s.getRow(row).createCell(4).setCellValue("");
								 s.getRow(row).createCell(5).setCellValue("Executed");
									s.getRow(row).createCell(6).setCellValue(Time);
							index++;
							row++;
							}
									catch(Exception e)
									{
										Time=TimeStamp();
										System.out.println("exception in loops");
										s.createRow(row).createCell(0).setCellValue(index);
										 s.getRow(row).createCell(1).setCellValue("Go to Top clicks on -1 page");
										 s.getRow(row).createCell(2).setCellValue("Play store");
										 s.getRow(row).createCell(3).setCellValue("");
										 s.getRow(row).createCell(4).setCellValue("Fail");
										 s.getRow(row).createCell(5).setCellValue("Not Executed");
											s.getRow(row).createCell(6).setCellValue(Time);
									index++;
									row++;
					 				}
										   dr.sendKeyEvent(AndroidKeyCode.HOME);
										   
										   
// Language selection in -1 page
										   try
										    {
										   for(int i=0;i<=3;i++){
										   dr.sendKeyEvent(AndroidKeyCode.HOME);
										   Thread.sleep(4000);
										   dr.swipe(80,796,572,758,2000);	
										   dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
										   dr.findElementByName("English").click();
										   dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();
										   dr.findElementByName("Videos").click();
										   dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
										   System.out.println("Landed on -1 page");
										   }
										   Time=TimeStamp();
										   
											  s.createRow(row).createCell(0).setCellValue(index);
												 s.getRow(row).createCell(1).setCellValue("Language selection in -1 page");
												 s.getRow(row).createCell(2).setCellValue("recent list");
												 s.getRow(row).createCell(3).setCellValue("Pass");
												 s.getRow(row).createCell(4).setCellValue("");
												 s.getRow(row).createCell(5).setCellValue("Executed");
													s.getRow(row).createCell(6).setCellValue(Time);
											index++;
											row++;
											}
										   catch(Exception e)
											{
											   Time=TimeStamp();
												System.out.println("exception in loops");
												s.createRow(row).createCell(0).setCellValue(index);
												 s.getRow(row).createCell(1).setCellValue("Language selection in -1 page");
												 s.getRow(row).createCell(2).setCellValue("Play store");
												 s.getRow(row).createCell(3).setCellValue("");
												 s.getRow(row).createCell(4).setCellValue("Fail");
												 s.getRow(row).createCell(5).setCellValue("Not Executed");
													s.getRow(row).createCell(6).setCellValue(Time);
											index++;
											row++;
											}
	   
										   
//	Language selection in -1 page after Landing
										   
										   Thread.sleep(2000);
										   try
										   {
										   for(int i=0;i<=3;i++){
										   dr.sendKeyEvent(AndroidKeyCode.HOME);
										   Thread.sleep(4000);
										   dr.swipe(80,796,572,758,2000);	
										   dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
										   dr.findElementByName("English").click();
										   dr.findElementById("launcher3.android.com.hivelauncher:id/language_selection_completion_btn").click();
										   dr.findElementByName("Videos").click();
										   dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
										   System.out.println("Landed on -1 page");
										   }
										   Time=TimeStamp();
										   
											  s.createRow(row).createCell(0).setCellValue(index);
												 s.getRow(row).createCell(1).setCellValue("Language selection in -1 page");
												 s.getRow(row).createCell(2).setCellValue("recent list");
												 s.getRow(row).createCell(3).setCellValue("Pass");
												 s.getRow(row).createCell(4).setCellValue("");
												 s.getRow(row).createCell(5).setCellValue("Executed");
													s.getRow(row).createCell(6).setCellValue(Time);
											index++;
											row++;
										   }
										   catch(Exception e)
										   {
											   Time=TimeStamp();
												System.out.println("exception in loops");
												s.createRow(row).createCell(0).setCellValue(index);
												 s.getRow(row).createCell(1).setCellValue("Language selection in -1 page");
												 s.getRow(row).createCell(2).setCellValue("Play store");
												 s.getRow(row).createCell(3).setCellValue("");
												 s.getRow(row).createCell(4).setCellValue("Fail");
												 s.getRow(row).createCell(5).setCellValue("Not Executed");
													s.getRow(row).createCell(6).setCellValue(Time);
											index++;
											row++;
										   }									   
						   
	 
	   
	 //Clear Data of App World 
										   
	    try
	    {
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
		 Time=TimeStamp();	
		 s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue("clearing data of App World");
		   	 s.getRow(row).createCell(2).setCellValue("clear data");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
	    }
	    catch(Exception e)
	    {
	    	Time=TimeStamp();
	    	System.out.println("clear data not done");
	    	s.createRow(row).createCell(0).setCellValue(index);
	   	 s.getRow(row).createCell(1).setCellValue("clearing data of App World");
	   	 s.getRow(row).createCell(2).setCellValue("clear data");
	   	 s.getRow(row).createCell(3).setCellValue("");
	   	 s.getRow(row).createCell(4).setCellValue("Fail");
	   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
	   		s.getRow(row).createCell(6).setCellValue(Time);
	   index++;
	   row++;
	    }
	    
	    
//	 Tapping on GAMES and APPS section in App World multiple times   
	    
	    try
	    {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
		  for(int r=0;r<3;r++)
		  {
			  if(r%2==0)
				  dr.findElementByName("Games").click();
			  else
				  dr.findElementByName("APPS").click();
		  }
		  Time=TimeStamp();
		  s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue("tapping on games and apps");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
	    }
	    catch(Exception e)
	    {
	    	Time=TimeStamp();
	    	s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue("tapping on games and apps");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("");
		   	 s.getRow(row).createCell(4).setCellValue("Fail");
		   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
	    row++;
	    }
	    
	    
//  Launching App World and Pressing Home button multiple times
	    try
	    {
	    	 for(int r=0;r<2;r++)
			  {
	    dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		  dr.findElementByName("App World").click();
	  
		  }
	    	 Time=TimeStamp();
		  s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue(" Launching App World and Pressing Home button multiple times");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
		   System.out.println("opening App World multiple times");
	    }
	    catch(Exception e)
	    {
	    	Time=TimeStamp();
	    	s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue(" Launching App World and Pressing Home button multiple times");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("");
		   	 s.getRow(row).createCell(4).setCellValue("Fail");
		   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
	    row++;
	    System.out.println("exception while opening App World multiple times");
	    
	    }
	    
	    
 
	    
	    
// Downloading Bollywood game from App World	    
	    try{
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
	        try
	        {
			 dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
	        }
	        catch(Exception e)
	        {
	        	
	        }
			 dr.findElementById("com.hiveinside.gamestore:id/cancel_icon").click();
			 dr.findElementByName("bollywood").click();
			 Thread.sleep(4000);
			  List<WebElement> ca=dr.findElementsById("com.hiveinside.gamestore:id/text_name"); 
//			  int ca2=ca.size();
//			  ca2= ca2-4;
//			  if(ca2>=8)
//				  ca2++;
			  
//			  System.out.println("Apps Present in first set =" +ca2); 
			  for(int i1=0;i1<1;i1++)
			  {
				  String s1=ca.get(i1).getText();
				  System.out.println(s1);
				  arr.add(s1);
				  dr.findElementByName(s1).click();
				  dr.findElementById("com.hiveinside.gamestore:id/button_download").click();
				  while (true)
				  {
					  try{
				  if(dr.findElementById("com.hiveinside.gamestore:id/button_download").getText().equals("Launch"))
				  break;
				  }
				  catch(Exception e)
				  {
					  
				  }
				  }
				  dr.sendKeyEvent(AndroidKeyCode.BACK);
				  dr.sendKeyEvent(AndroidKeyCode.BACK);
				  dr.sendKeyEvent(AndroidKeyCode.BACK);
				  dr.sendKeyEvent(AndroidKeyCode.HOME);
				  System.out.println("App  " +(i1+1) +"   "  +s1  +"  Downloading");
				  Thread.sleep(4000);
				  
		     }
			  s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Downloading Bollywood games from App World");
				 s.getRow(row).createCell(2).setCellValue("App World");
				 s.getRow(row).createCell(3).setCellValue("Pass");
				 s.getRow(row).createCell(4).setCellValue("");
				 s.getRow(row).createCell(5).setCellValue("Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
		    index++;
		    row++;
	}
	  catch(Exception e){
		  System.out.println("fail to download" +e);
		  s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Downloading Bollywood games from App World");
			 s.getRow(row).createCell(2).setCellValue("App World");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
	    index++;
	    row++;

	}
	    
	   
// App world Banner scrolling
	    
	    try{
	    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))");
		  dr.findElementByName("App World").click();
		  Thread.sleep(2000);

		  
		  for (int i=0;i<=3;i++){
			  
		  Dimension size = dr.manage().window().getSize();
	      System.out.println(size);
	      

	      
	      //Find swipe start and end point from screen's with and height.
	      //Find startx point which is at right side of screen.
	      int startx = (int) (size.width * 0.70);
	      //Find endx point which is at left side of screen.
	      int endx = (int) (size.width * 0.10);
	      //Find vertical point where you wants to swipe. It is in middle of screen height.
	      int starty = size.height/4;
	      System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

	      //Swipe from Right to Left.
	      dr.swipe(startx, starty, endx, starty, 3000);
	     
	      Thread.sleep(2000);
	      dr.findElementByName("Games").click();
	      int startx1 = (int) (size.width * 0.70);
	      int endx1 = (int) (size.width * 0.10);
	      int starty1 = size.height/4;
	      System.out.println("startx = " + startx1 + " ,endx = " + endx1 + " , starty = " + starty1);
	      dr.swipe(startx1, starty1, endx1, starty1, 3000);
	      dr.findElementByName("APPS").click();
		  }   
		   Thread.sleep(2000);
		   dr.sendKeyEvent(AndroidKeyCode.HOME);
		   dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		  
	 
	    }
		  catch(Exception e)
		  {
		  	Time=TimeStamp();
		  	System.out.println("App world Banner scrolling");
		  	s.createRow(row).createCell(0).setCellValue(index);
		  	 s.getRow(row).createCell(1).setCellValue("App world Banner scrolling");
		  	 s.getRow(row).createCell(2).setCellValue("App World");
		  	 s.getRow(row).createCell(3).setCellValue("");
		  	 s.getRow(row).createCell(4).setCellValue("Fail");
		  	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		  		s.getRow(row).createCell(6).setCellValue(Time);
		  index++;
		  row++;
		  }    
	    
	    
	    
	    
//Opening My Games in App world multiple times
	    try{
	    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))");
		  dr.findElementByName("App World").click();
		  Thread.sleep(2000);
		  for (int i=0;i<=3;i++){
		  dr.findElementById("com.hiveinside.gamestore:id/action_my_downloads").click();
		  dr.sendKeyEvent(AndroidKeyCode.BACK);
		  }
		  Time=TimeStamp();
		  s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue(" Launching App World and Pressing Home button multiple times");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
	    }
	    catch(Exception e)
		  {
		  	Time=TimeStamp();
		  	System.out.println("App world Banner scrolling");
		  	s.createRow(row).createCell(0).setCellValue(index);
		  	 s.getRow(row).createCell(1).setCellValue("App world Banner scrolling");
		  	 s.getRow(row).createCell(2).setCellValue("App World");
		  	 s.getRow(row).createCell(3).setCellValue("");
		  	 s.getRow(row).createCell(4).setCellValue("Fail");
		  	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		  		s.getRow(row).createCell(6).setCellValue(Time);
		  index++;
		  row++;
		  }   
// Downloading from Banner from Apps of App world
	    try
	    {
	    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))");
		  dr.findElementByName("App World").click();
		  Thread.sleep(2000);
		dr.swipe(702, 478, 200, 478, 0);
	      Thread.sleep(2000);
	      dr.findElementById("com.hiveinside.gamestore:id/banner_container").click();
	      Thread.sleep(2000);
	     if (dr.findElementsById("com.hiveinside.gamestore:id/button_download").size()>0)
	     {
	    	 (dr.findElementById("com.hiveinside.gamestore:id/button_download")).click();
	     }
	     else
	     {
	    dr.sendKeyEvent(AndroidKeyCode.BACK);
	     }
	     Time=TimeStamp();
	     System.out.println("Downloading from Banner of App world");
		  s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue(" Downloading from Banner of App world");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
	    }
	    catch(Exception e)
		  {
		  	Time=TimeStamp();
		  	System.out.println("Not Downloading from Banner of App world");
		  	s.createRow(row).createCell(0).setCellValue(index);
		  	 s.getRow(row).createCell(1).setCellValue("Downloading from Banner of App world");
		  	 s.getRow(row).createCell(2).setCellValue("App World");
		  	 s.getRow(row).createCell(3).setCellValue("");
		  	 s.getRow(row).createCell(4).setCellValue("Fail");
		  	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		  		s.getRow(row).createCell(6).setCellValue(Time);
		  index++;
		  row++;
		  }   
	    
	 // Downloading from Banner from Games of App world
	    try
	    {
	    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))");
		  dr.findElementByName("App World").click();
		  dr.findElementByName("Games").click();
		  Thread.sleep(2000); 
		dr.swipe(702, 478, 200, 478, 0);
	      Thread.sleep(2000);
	      dr.findElementById("com.hiveinside.gamestore:id/banner_container").click();
	      Thread.sleep(2000);
	     if (dr.findElementsById("com.hiveinside.gamestore:id/button_download").size()>0)
	     {
	    	 (dr.findElementById("com.hiveinside.gamestore:id/button_download")).click();
	     }
	     else
	     {
	    dr.sendKeyEvent(AndroidKeyCode.BACK);
	     }
	     Time=TimeStamp();
	     System.out.println("Downloading from Banner from Games of App world");
		  s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue("Downloading from Banner from Games of App world");
		   	 s.getRow(row).createCell(2).setCellValue("App World");
		   	 s.getRow(row).createCell(3).setCellValue("Pass");
		   	 s.getRow(row).createCell(4).setCellValue("");
		   	 s.getRow(row).createCell(5).setCellValue("Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
	    }
	    catch(Exception e)
		  {
		  	Time=TimeStamp();
		  	System.out.println("Not Downloading from Banner from Games of App world");
		  	s.createRow(row).createCell(0).setCellValue(index);
		  	 s.getRow(row).createCell(1).setCellValue("Downloading from Banner from Games of App world");
		  	 s.getRow(row).createCell(2).setCellValue("App World");
		  	 s.getRow(row).createCell(3).setCellValue("");
		  	 s.getRow(row).createCell(4).setCellValue("Fail");
		  	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		  		s.getRow(row).createCell(6).setCellValue(Time);
		  index++;
		  row++;
		  }   

	    
	 // Creating Loop inside App World

	    try{
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
				 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
				  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
				 Thread.sleep(4000);

				 dr.findElementByName("GAMES").click();
				  dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
				  dr.findElementById("com.hiveinside.gamestore:id/text_name").click();
				  Thread.sleep(1000);
			   for(int i1= 0; i1<=20;i1++)
			   {
						 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"MORE\"))").click();
						
						 List<WebElement> q = dr.findElementsById("com.hiveinside.gamestore:id/app_container");
						 int count=0;
						
							 List<WebElement> w = dr.findElementsById("com.hiveinside.gamestore:id/install_menu");
							 
							 for(WebElement t : w){
							 try{
								 t.click();
								 dr.findElementByName("Install");
								 Thread.sleep(2000);
								 dr.sendKeyEvent(AndroidKeyCode.BACK);
								 break;
							 }
							 catch(Exception e)
							 {
								 dr.sendKeyEvent(AndroidKeyCode.BACK);
								count++;
							 }
							 }
							 System.out.println(count);
							 int tmp=0;
						 
							 for(WebElement t : q){
						 
						 if(tmp!=count)
							 {
							 tmp++;
							 continue;
							 }
						 else
						 {
							 t.click();
							 break;
						 }
						 
							 }
						 
				
							 
						 String s1=dr.findElementById("com.hiveinside.gamestore:id/text_name").getText();
						  System.out.println(s1);
						
						  if(dr.findElementsByName("Launch").size()>0)
							 {
								i1--;
							 }
						  else if(dr.findElementsByName("Download").size()>0){
							  (dr.findElementByName("Download")).click();
						  }
						  else{
							  (dr.findElementByName("Install")).click();							  }
//						  }
					  
				  String s3= "Similar apps";
			      System.out.println(s3);
			}
			 
			   Thread.sleep(2000);
			   dr.sendKeyEvent(AndroidKeyCode.HOME);
			   dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
			   s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Changing Device Language");
				 s.getRow(row).createCell(2).setCellValue("Settings");
				 s.getRow(row).createCell(3).setCellValue("Pass");
				 s.getRow(row).createCell(4).setCellValue("");
				 s.getRow(row).createCell(5).setCellValue("Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
			index++;
			row++;
	  } 
		
		catch(Exception e)
		{
			Time=TimeStamp();
			System.out.println("exception in App World loop");
			s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Changing Device Language");
			 s.getRow(row).createCell(2).setCellValue("Settings");
			 s.getRow(row).createCell(3).setCellValue("");
			 s.getRow(row).createCell(4).setCellValue("Fail");
			 s.getRow(row).createCell(5).setCellValue("Not Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++; 
		}

		 
//Changing Device Language

		 try
		 {
		 	 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 	 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();

		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings\"))").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Language & input\"))").click();
		 dr.findElementByName("Language").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Italiano\"))").click();
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		 Thread.sleep(1000);
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();

		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Impostazioni\"))").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lingua e immissione\"))").click();
		 dr.findElementByName("Lingua").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"English (India)\"))").click();
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.BACK);
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 Time=TimeStamp();
		   Thread.sleep(2000);
		   dr.sendKeyEvent(AndroidKeyCode.HOME);
		   dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		   s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("Changing Device Language");
			 s.getRow(row).createCell(2).setCellValue("Settings");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++;
		 }

		 catch(Exception e)
		 {
			 Time=TimeStamp();
				System.out.println("exception in App World loop");
				s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Changing Device Language");
				 s.getRow(row).createCell(2).setCellValue("Settings");
				 s.getRow(row).createCell(3).setCellValue("");
				 s.getRow(row).createCell(4).setCellValue("Fail");
				 s.getRow(row).createCell(5).setCellValue("Not Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
			index++;
			row++; 

		 }
		 
		 //Clear Data of App World 
		   
		    try
		    {
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
			 Time=TimeStamp();	
			 s.createRow(row).createCell(0).setCellValue(index);
			   	 s.getRow(row).createCell(1).setCellValue("clearing data of App World");
			   	 s.getRow(row).createCell(2).setCellValue("clear data");
			   	 s.getRow(row).createCell(3).setCellValue("Pass");
			   	 s.getRow(row).createCell(4).setCellValue("");
			   	 s.getRow(row).createCell(5).setCellValue("Executed");
			   		s.getRow(row).createCell(6).setCellValue(Time);
			   index++;
			   row++;
		    }
		    catch(Exception e)
		    {
		    	Time=TimeStamp();
		    	System.out.println("clear data not done");
		    	s.createRow(row).createCell(0).setCellValue(index);
		   	 s.getRow(row).createCell(1).setCellValue("clearing data of App World");
		   	 s.getRow(row).createCell(2).setCellValue("clear data");
		   	 s.getRow(row).createCell(3).setCellValue("");
		   	 s.getRow(row).createCell(4).setCellValue("Fail");
		   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
		   		s.getRow(row).createCell(6).setCellValue(Time);
		   index++;
		   row++;
		    }
		 
// Scrolling in App World
		 try{
			 
		 
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"App World\"))").click();
		 dr.findElementByName("Games").click();
		 for(int i11=0;i11<5;i11++){
		 	if(i11%2==0)
		 	{
		 		Thread.sleep(800);
		 	dr.swipe(375,892,375,216,500);
		 	dr.swipe(375,892,375,216,500);
		 	
		 	}
		 	else
		 	{
		 		Thread.sleep(800);
		 		dr.swipe(375,216,375,892,500);
		 		dr.swipe(375,216,375,892,500);
		 }}
		 dr.findElementById("com.hiveinside.gamestore:id/text_more").click();
		 Time=TimeStamp();
		   Thread.sleep(2000);
		   dr.sendKeyEvent(AndroidKeyCode.HOME);
		   dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		   s.createRow(row).createCell(0).setCellValue(index);
			 s.getRow(row).createCell(1).setCellValue("creating loops in App World");
			 s.getRow(row).createCell(2).setCellValue("App World");
			 s.getRow(row).createCell(3).setCellValue("Pass");
			 s.getRow(row).createCell(4).setCellValue("");
			 s.getRow(row).createCell(5).setCellValue("Executed");
				s.getRow(row).createCell(6).setCellValue(Time);
		index++;
		row++;
		 }
		 catch(Exception e)
		 {
			 Time=TimeStamp();
				System.out.println("exception in App World loop");
				s.createRow(row).createCell(0).setCellValue(index);
				 s.getRow(row).createCell(1).setCellValue("Changing Device Language");
				 s.getRow(row).createCell(2).setCellValue("Settings");
				 s.getRow(row).createCell(3).setCellValue("");
				 s.getRow(row).createCell(4).setCellValue("Fail");
				 s.getRow(row).createCell(5).setCellValue("Not Executed");
					s.getRow(row).createCell(6).setCellValue(Time);
			index++;
			row++; 

		 }

	    
  
 //validating apps in app drawer
				 try
				 {
					 for(int r=0;r<arr.size();r++)
					 {
					int o=0;
					  String s1 = arr.get(r);
					  String[] words = s1.split("\\s+");
					  for(int w=0;w<words.length;w++)
					  {
					  try{
						  String tmp = "";
						  if(w==1)
						  {
							  tmp=words[0];
						  }
						  else
						  {
						  for(o=0;o<w;o++)
							 if(o==0)
							  tmp = words[o];
							 else
								 tmp=tmp+" "+words[o];
						  }
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
					 Time=TimeStamp();
					 s.createRow(row).createCell(0).setCellValue(index);
				   	 s.getRow(row).createCell(1).setCellValue("Validation of apps in app drawer");
				   	 s.getRow(row).createCell(2).setCellValue("validation");
				   	 s.getRow(row).createCell(3).setCellValue("Pass");
				   	 s.getRow(row).createCell(4).setCellValue("");
				   	 s.getRow(row).createCell(5).setCellValue("Executed");
				   		s.getRow(row).createCell(6).setCellValue(Time);
				   index++;
				   row++;
				 }
				 catch(Exception e)
				 {
					 Time=TimeStamp();
					 s.createRow(row).createCell(0).setCellValue(index);
				   	 s.getRow(row).createCell(1).setCellValue("Validation of apps in app drawer");
				   	 s.getRow(row).createCell(2).setCellValue("validation");
				   	 s.getRow(row).createCell(3).setCellValue("");
				   	 s.getRow(row).createCell(4).setCellValue("Fail");
				   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
				   		s.getRow(row).createCell(6).setCellValue(Time);
				   index++;
				   row++;
				 }
				 
				  FileOutputStream fos=new FileOutputStream("C://Users/vishal gupta/Desktop/LavaWorldAging.xlsx");
					wb.write(fos);
										   					
					
					
//Notification clicking	
					
	 try{
							
						  dr.openNotifications();
						  List<WebElement> ca=dr.findElementsById("android:id/title");
			              int ca2= ca.size();
			              System.out.println("Notification Present =" +ca2); 
			              

						  for(int i=0;i<3;i++)
						  {
							  dr.openNotifications();
				              Thread.sleep(2000);
				              
				              List<WebElement> ca1=dr.findElementsById("android:id/title");
				              
							  String s1=ca1.get(0).getText();
							  dr.findElementByName(s1).click();
							  System.out.println("App  " +(i+1) +"   "  +s1   +"  Clicked");
							  
 
						  Thread.sleep(3000);
							    
							   int CountNotificationclicked = 0;
							++CountNotificationclicked;
							   
							   dr.sendKeyEvent(AndroidKeyCode.HOME);  
						  }
						  Time=TimeStamp();
							 s.createRow(row).createCell(0).setCellValue(index);
						   	 s.getRow(row).createCell(1).setCellValue("Notification clicking");
						   	 s.getRow(row).createCell(2).setCellValue("Notification");
						   	 s.getRow(row).createCell(3).setCellValue("Pass");
						   	 s.getRow(row).createCell(4).setCellValue("");
						   	 s.getRow(row).createCell(5).setCellValue("Executed");
						   		s.getRow(row).createCell(6).setCellValue(Time);
						   index++;
						   row++;
					 
					  }
					  catch(Exception e)
						{
							System.out.println("Error " + e);
					
					
					    	Time=TimeStamp();
					    	s.createRow(row).createCell(0).setCellValue(index);
						   	 s.getRow(row).createCell(1).setCellValue("Notification clicking");
						   	 s.getRow(row).createCell(2).setCellValue("Notification");
						   	 s.getRow(row).createCell(3).setCellValue("");
						   	 s.getRow(row).createCell(4).setCellValue("Fail");
						   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
						   		s.getRow(row).createCell(6).setCellValue(Time);
						   index++;
					    row++;
					    System.out.println("exception while opening App World multiple times");
					    
					    }

					 
					 
					 
//		Boost Dashboard validation
					 
		/*			 try{
							dr.sendKeyEvent(AndroidKeyCode.HOME);
							dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
							//new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Boost")).moveTo(230, 102).release().perform();
							dr.findElementByName("Boost").click();
							Thread.sleep(10000);
							String tmp1=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_battery_endurance_id").getText();
							System.out.println("Battery status: " +tmp1);
							String tmp2=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_ram_status_id").getText();
							System.out.println("RAM status: " +tmp2);
							String tmp3=dr.findElementById("launcher3.android.com.hivelauncher:id/dashboard_storage_status_id").getText();
							System.out.println("Storage status: " +tmp3);
							String tmp4="";
							int i=0;
									if(tmp1.equals(tmp4)&&tmp2.equals(tmp4)&&tmp3.equals(tmp4))
										System.out.println("Dashboard is empty");
									else
					
					  Time=TimeStamp();
						 s.createRow(row).createCell(0).setCellValue(index);
					   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
					   	 s.getRow(row).createCell(2).setCellValue("Boost");
					   	 s.getRow(row).createCell(3).setCellValue("Pass");
					   	 s.getRow(row).createCell(4).setCellValue("");
					   	 s.getRow(row).createCell(5).setCellValue("Executed");
					   		s.getRow(row).createCell(6).setCellValue(Time);
					   index++;
					   row++;
				 
				  }
				  catch(Exception e)
					{
						System.out.println("Error " + e);
				
				
				    	Time=TimeStamp();
				    	s.createRow(row).createCell(0).setCellValue(index);
					   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
					   	 s.getRow(row).createCell(2).setCellValue("Boost");
					   	 s.getRow(row).createCell(3).setCellValue("");
					   	 s.getRow(row).createCell(4).setCellValue("Fail");
					   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
					   		s.getRow(row).createCell(6).setCellValue(Time);
					   index++;
				    row++;
				    System.out.println("exception while opening App World multiple times");
				    
				    }
					 
					 
//					 Clicking on Fab button of Boost
					 try{
							dr.sendKeyEvent(AndroidKeyCode.HOME);
							dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
							
							dr.findElementByName("Boost").click();
						
								dr.findElementById("launcher3.android.com.hivelauncher:id/fab");
								String tmp="true";
								String b=dr.findElementById("launcher3.android.com.hivelauncher:id/fab").getAttribute("clickable");
								if(tmp.equals(b))
									dr.findElementById("launcher3.android.com.hivelauncher:id/fab").click();
									System.out.println("Fab Button is Present and working ");
									 Time=TimeStamp();
									 s.createRow(row).createCell(0).setCellValue(index);
								   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
								   	 s.getRow(row).createCell(2).setCellValue("Boost");
								   	 s.getRow(row).createCell(3).setCellValue("Pass");
								   	 s.getRow(row).createCell(4).setCellValue("");
								   	 s.getRow(row).createCell(5).setCellValue("Executed");
								   		s.getRow(row).createCell(6).setCellValue(Time);
								   index++;
								   row++;
							}
							catch(Exception e)
							{
								Time=TimeStamp();
						    	s.createRow(row).createCell(0).setCellValue(index);
							   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
							   	 s.getRow(row).createCell(2).setCellValue("Boost");
							   	 s.getRow(row).createCell(3).setCellValue("");
							   	 s.getRow(row).createCell(4).setCellValue("Fail");
							   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
							   		s.getRow(row).createCell(6).setCellValue(Time);
							   index++;
						    row++;
						
								System.out.println("Fab Button Not Present");
							}
					
					 
// Deonach widget placing on Homescreen					 
					 Thread.sleep(2000);

					 try{
					 	dr.sendKeyEvent(AndroidKeyCode.HOME);
					 	WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
					 		new TouchAction((MobileDriver) dr).longPress(fn).perform();
					 		
					 		 dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
					 		((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Deonach\"))");
					 		 WebElement fn1=dr.findElementByName("Deonach");
					 		  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Deonach")).moveTo(126, 194).release().perform();
					 		 
					 		 System.out.println("Deonach widget placed on homescreen");
					 		 Time=TimeStamp();
							 s.createRow(row).createCell(0).setCellValue(index);
						   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
						   	 s.getRow(row).createCell(2).setCellValue("Boost");
						   	 s.getRow(row).createCell(3).setCellValue("Pass");
						   	 s.getRow(row).createCell(4).setCellValue("");
						   	 s.getRow(row).createCell(5).setCellValue("Executed");
						   		s.getRow(row).createCell(6).setCellValue(Time);
						   index++;
						   row++;
					 }
						catch(Exception e)
						{
							Time=TimeStamp();
					    	s.createRow(row).createCell(0).setCellValue(index);
						   	 s.getRow(row).createCell(1).setCellValue("Boost Dashboard validation");
						   	 s.getRow(row).createCell(2).setCellValue("Boost");
						   	 s.getRow(row).createCell(3).setCellValue("");
						   	 s.getRow(row).createCell(4).setCellValue("Fail");
						   	 s.getRow(row).createCell(5).setCellValue("Not Executed");
						   		s.getRow(row).createCell(6).setCellValue(Time);
						   index++;
					    row++;
					
							System.out.println("Fab Button Not Present");
						}
						*/
				
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

	}}
