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


public class NewMinusOne {
	// **version 3.1.135_test**

	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
	String time;
	String timestamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String cs=dateFormat.format(date).toString();
		return cs;
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
	void excel(String event, String Time,String URL) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream("C://Users/Nakul/Desktop/NewMinusOne.xlsx");
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet s3=wb.getSheet("Sheet3");
	    int row=s3.getLastRowNum()+1;
	    s3.createRow(row).createCell(0).setCellValue(event);
	    s3.getRow(row).createCell(1).setCellValue(Time);
	    if(!URL.equals(""))
	    	s3.getRow(row).createCell(2).setCellValue(URL);
	    	
	    FileOutputStream fos=new FileOutputStream("C://Users/Nakul/Desktop/NewMinusOne.xlsx");
	    wb.write(fos);
	}
	 
	
	void landedOnMinusOne() throws IOException, InterruptedException{
		try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		}
		
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		 Thread.sleep(4000);
		 dr.swipe(57,418,389,372,2000);
		 try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("Landed on Minus One page",time,"");
		 }
		 catch(Exception e)
		 {
			 landedOnMinusOne();
		 }
	}
	void exitFromMinusOne() throws IOException, InterruptedException{
		try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 dr.sendKeyEvent(AndroidKeyCode.HOME);
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		 }
		 catch(Exception e)
		 {
			 landedOnMinusOne();
			 exitFromMinusOne();
		 }
	}
	@SuppressWarnings("unchecked")
	void newsClick() throws IOException, InterruptedException{
		try{
			
			 try{
					dr.findElementById("launcher3.android.com.hivelauncher:id/language_relative_layout");
					 
				 dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
				 time = getMobTime();
				 excel("language change button click",time,"");
		
				}
				catch(Exception e)
				{
					
				}
				try{
					dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn");
					
					 dr.findElementById("launcher3.android.com.hivelauncher:id/category_swap_button").click();
					 time = getMobTime();
					 excel("category change button click",time,"");

				}
				catch(Exception e)
				{
								
				}
	 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
		List<WebElement> news = dr.findElementsById("launcher3.android.com.hivelauncher:id/half_feed");
		news.get(0).click();
		time = getMobTime();
		/*while(true)
		{
			try
			{
				dr.findElementById("com.android.chrome:id/menu_button").click();
				dr.findElementById("com.android.chrome:id/button_two").click();
				
				String q = dr.findElementById("com.android.chrome:id/website_settings_url").getText();
				excel("News Click",time,q);
		break;
			}
			catch(Exception e)
			{
				
			}
		}*/
		WebDriverWait wait = new WebDriverWait(dr,1000);
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.chrome:id/menu_button")));
	  	dr.findElementById("com.android.chrome:id/menu_button").click();
	  	wait = new WebDriverWait(dr,1000);
	  	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.chrome:id/button_two")));
	  	dr.findElementById("com.android.chrome:id/button_two").click();
	  	String q = dr.findElementById("com.android.chrome:id/website_settings_url").getText();
		excel("News Click",time,q);
		}
		catch(Exception e)
		{
			landedOnMinusOne();
			newsClick();
		}
	}
	void pullToRefresh() throws IOException, InterruptedException{
		try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 try{
					dr.findElementById("launcher3.android.com.hivelauncher:id/language_relative_layout");
					 
				 dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
				 time = getMobTime();
				 excel("language change button click",time,"");
		
				}
				catch(Exception e)
				{
					
				}
				try{
					dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn");
					
					 dr.findElementById("launcher3.android.com.hivelauncher:id/category_swap_button").click();
					 time = getMobTime();
					 excel("category change button click",time,"");

				}
				catch(Exception e)
				{
								
				}
				goToTopButtonClick();
			 dr.swipe(227,342,235,746,1000);
			 time = getMobTime();
			 excel("pull to refresh",time,"");
		 }
		 catch(Exception e)
		 {
			 landedOnMinusOne();
			 pullToRefresh();
		 }
	}
	void goToTopButtonClick() throws IOException, InterruptedException{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			try{
				 dr.findElementById("launcher3.android.com.hivelauncher:id/go_to_top").click();
				 time = getMobTime();
				 excel("go to top Button click",time,"");
			 }
			 catch(Exception e){
				dr.swipe(239,756,236,151,1000); 
				 time = getMobTime();
				 excel(" Scroll ",time,"");
				goToTopButtonClick();
			 }
		}
		catch(Exception e)
		{
			landedOnMinusOne();
			goToTopButtonClick();
		}
	}
	void languageSelectionButtonClick() throws IOException, InterruptedException{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/language_relative_layout");
				return;
			}
			catch(Exception e){
				
			}
			try{
				 dr.findElementById("launcher3.android.com.hivelauncher:id/go_to_top").click();
				 time = getMobTime();
				 excel("go to top Button click",time,"");
			 }
			 catch(Exception e){
				 goToTopButtonClick();
						 
			 }
			dr.findElementById("launcher3.android.com.hivelauncher:id/language_swap_button").click();
			 time = getMobTime();
			 excel("language change button click",time,"");
		}
		catch(Exception e)
		{
			landedOnMinusOne();
			languageSelectionButtonClick();
		}
	}
	void categorySelectionButtonClick() throws IOException, InterruptedException{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn");
				 return;
			}
			catch(Exception e){
				
			}
			try{
				 dr.findElementById("launcher3.android.com.hivelauncher:id/go_to_top").click();
				 time = getMobTime();
				 excel("go to top Button click",time,"");
			 }
			 catch(Exception e){
				 
			 }
			 goToTopButtonClick();
			 dr.findElementById("launcher3.android.com.hivelauncher:id/category_swap_button").click();
			 time = getMobTime();
			 excel("category change button click",time,"");
		}
		catch(Exception e)
		{
			landedOnMinusOne();
			categorySelectionButtonClick();
		}

	
	}	
	
	void onLanguageSelection() throws IOException, InterruptedException{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/language_relative_layout");
			List<WebElement> languageOptions  = dr.findElementsById("launcher3.android.com.hivelauncher:id/search_keyword_text");
					int randomNum = (int)(Math.random()*(languageOptions.size()-2 )+ 1);

			languageOptions.get(randomNum).click();
			
			time = getMobTime();
			 excel("On language Selection",time,"");
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();

			languageSelectionButtonClick();
			onLanguageSelection();
		}
	}
	void onCategorySelection() throws IOException, InterruptedException{
			
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn");
			List<WebElement> languageOptions  = dr.findElementsById("launcher3.android.com.hivelauncher:id/category_text");
			int randomNum = (int)(Math.random()*(languageOptions.size()-2 )+ 1);

			languageOptions.get(randomNum).click();
			 dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();
			
			 time = getMobTime();
			 excel("On category selection",time,"");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

			categorySelectionButtonClick();
			onCategorySelection();
		}

	}
	
	void facebookScroll() throws InterruptedException
	{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		}
		try{
			   dr.sendKeyEvent(AndroidKeyCode.HOME);
				  		
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Facebook\"))");
	     dr.findElementByName("Facebook").click();
	     time = getMobTime();
		 excel("Facebook launched",time,"");
			
			
	     Thread.sleep(15000);
	  	 for(int r=0;r<10;r++)
	  		dr.swipe(239,756,236,151,1000); 
			

//    dr.swipe(478,1005,368,149,5000);
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	     time = getMobTime();
		 excel("Facebook closed",time,"");
		
			
		}
		catch(Exception e)
		{
			System.out.println("Fb Not executed");
		}
	}

	@SuppressWarnings("rawtypes")
	void instaScroll() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		}
	try{
	dr.sendKeyEvent(AndroidKeyCode.HOME);
	dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
        ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Instagram\"))");
	     String s5=dr.findElementByName("Instagram").getText();
	     System.out.println(s5);
	   	 dr.findElementByName("Instagram").click(); 
	     time = getMobTime();
		 excel("Insta launched",time,"");
		
	   	 Thread.sleep(10000);
	  	 for(int r=0;r<10;r++)
	  		dr.swipe(239,756,236,151,1000); 
			
//    dr.swipe(478,1005,368,149,5000);
	     dr.sendKeyEvent(AndroidKeyCode.HOME);
	     time = getMobTime();
		 excel("Insta closed",time,"");
	}
	catch(Exception e)
	{
		
	}
	}

	void applySystemWallpaper() throws InterruptedException
	{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		}
	try{
		   dr.sendKeyEvent(AndroidKeyCode.HOME);
			  
			WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
			new TouchAction((MobileDriver) dr).longPress(fn).perform();
			 dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
			 dr.findElementByName("Black Hole").click();
			 dr.findElementByName("Set wallpaper").click();
				
			 System.out.println("First wallpaper applied Succesfully");
			  time = getMobTime();
				 excel("Wallpaper set successfully",time,"");
				
			 Thread.sleep(3000); 
				
			  }
			  catch(Exception e)
				{
					System.out.println("Some Error while applying First wallpaper " + e);
					dr.sendKeyEvent(AndroidKeyCode.HOME);
					Thread.sleep(3000);
				}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void youtube()
	  {
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		} 
		try{
			  
			    
			
		dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
			dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))").click();
			  time = getMobTime();
				 excel("youtube launched",time,"");
		
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
			  time = getMobTime();
				 excel("youtube closed",time,"");
		
  
			  
		  }
		  catch(Exception e)
		  {
			  
		  }
	  }
	  
	@SuppressWarnings("unchecked")
	void appLaunchFromAppDrawer() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
			 time = getMobTime();
			 excel("exit from Minus One page",time,"");
		}
		catch(Exception e)
		{
			
		}
		 
		
		try{
		dr.sendKeyEvent(AndroidKeyCode.HOME); 
			 
		  
			  
			
		  List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
			 for(int i=0;i<4;i++)
				  
			  {
				  int w= (int)(Math.random() * 10);
				
				  dr.findElementByName(ca.get(w).getText()).click();
				  time = getMobTime();
					 excel(ca.get(w).getText()+" app launched",time,"");
					  dr.sendKeyEvent(AndroidKeyCode.HOME);
					  dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
						
			  }
			
		}
		catch(Exception e)
		{
			
		}
	}
	 
	
	void facebookAdInMinusOne() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
		}
		catch(Exception e)
		{
			landedOnMinusOne();
		}
		try{
			goToTopButtonClick();
			 Thread.sleep(3000);
				
			dr.findElementById("launcher3.android.com.hivelauncher:id/fb_ad_container");
			  time = getMobTime();
				 excel(" Fb Ad shown ",time,"");
				 Thread.sleep(1000);
				 
		}
		catch(Exception e)
		{
			  time = getMobTime();
				 excel(" Fb Ad not shown ",time,"");
			
		}
		try{
			dr.findElementById("launcher3.android.com.hivelauncher:id/fb_ad_container").click();
			  time = getMobTime();
				 excel(" Fb Ad clicked ",time,"");
			
		}
		catch(Exception e){
			
		}
	}

	void youtubeVideoInMinusOne() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		try{
			 dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
		}
		catch(Exception e)
		{
			landedOnMinusOne();
		}
		goToTopButtonClick();
		Thread.sleep(1000);
	
		int i=0;
		while(i<=20)
		{
			try{
				dr.findElementById("launcher3.android.com.hivelauncher:id/card_view_feed").click();
				time = getMobTime();
				 excel(" youtube video in minus one clicked ",time,"");
				 break;
				}
			catch(Exception e)
			{
				dr.swipe(250, 635, 253, 163, 1000);
				 time = getMobTime();
				 excel(" Scroll ",time,"");
			
			i++;
			}
		}
	}
	void minusonescroll() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		int i=0;
		int tmp=16;
		int arr[]=new int[16];
		  while(i<160)
		  {
			  int tmp1=(int)(Math.random()*16);
			  
			  while(tmp==tmp1)
				  {
				  tmp1=(int)(Math.random()*16);
				  }
			  tmp=tmp1;
			  System.out.println(tmp1 + "in minusonescroll"+" "+ i);
			  if(arr[tmp1]<10)
			  {
					 switch(tmp)
					 {
						 case 0:
							 landedOnMinusOne();
							 Thread.sleep(5000);
							 break;
							
							case 1:
							exitFromMinusOne();
							 Thread.sleep(2000);
							 
								
							break;
							
							case 2: 
								categorySelectionButtonClick();
								 Thread.sleep(2000);
									
								break;
								
							case 3:
								 languageSelectionButtonClick();
								 Thread.sleep(2000);
									
								 break;
									
							 case 4:
							 onCategorySelection();
							 Thread.sleep(2000);
											
								 break;
								 
							 case 5:
							 onLanguageSelection();
							 Thread.sleep(2000);
								
							 break;
								
							 case 6:
								 newsClick();
								 Thread.sleep(2000);
									
								 break;
							 
							 case 7:
								 goToTopButtonClick();
								 Thread.sleep(2000);
									
								 break;
								 
							 case 8:
								 pullToRefresh();
								 Thread.sleep(2000);
									
								 break;
							 case 9:
								 youtube();
								 Thread.sleep(2000);
									
								 break;
							 case 10:
								 instaScroll();
								 Thread.sleep(2000);
									
								 break;
							 case 11:
								 facebookScroll();
								 Thread.sleep(2000);
									
								 break;
							 case 12:
								 applySystemWallpaper();
								 Thread.sleep(2000);
									
								 break;
							 case 13:
								 appLaunchFromAppDrawer();
								 Thread.sleep(2000);
									
								 break;
							 case 14:
								 facebookAdInMinusOne();
								 Thread.sleep(2000);
								 break;
								 
							 case 15:
								 youtubeVideoInMinusOne();
								 Thread.sleep(2000);
								 break;
					 }
					  

				 arr[tmp1]++; 
				 i++;
			  }
			
		  }
	}
	@Test()
	void test() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException{
		minusonescroll();
	  
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
