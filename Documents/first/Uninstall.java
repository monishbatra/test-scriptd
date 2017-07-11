package first;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Uninstall{
	

	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @Test()
  public void UninstallApp() throws InterruptedException, IOException {
	  
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 1; j < 6; j++) {
			list.add(new Integer(j));
		}
//		Collections.shuffle(list);
		for (int i = 0; i < 5; i++) {
		//	System.out.println(list.get(i));
			int r = list.get(i);
			System.out.print(r +" ");
			
			Thread.sleep(2000);
		try{
			switch(r){
				 
			    case 1 :
				   launchit("Amazon Shopping");
				   break;
				   
			    case 2 :
				   launchit("BeautyPlus Me");
				   break;
				   
			    case 3 :
				   launchit("Browser");
				   break;
				   
			    case 4 :
				   launchit("Clock");
				   break;
				   
			    case 5 :
				   launchit("Drive");
				   break;
				  
						 								       
				//default : //Optional
		       //Statements
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing " +r  +"th " +"case statement");
			dr.sendKeyEvent(AndroidKeyCode.HOME);
		}
		
		}
	  
	 
  }
  
  @SuppressWarnings("rawtypes")
private void launchit(String Appname) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	// TODO Auto-generated method stub
	  
	  try{
	 
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			
		     
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Appname + "\"))");
		  
		  WebElement fn=dr.findElementByName(Appname);
		  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName(Appname)).moveTo(122, 198).release().perform();
		  dr.findElementByName("OK").click();
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  Date date = new Date();
		  String dateTime=dateFormat.format(date).toString();
		  System.out.println(dateTime); //2014/08/06 15:59:48
//		  e.uninstalled(Appname, dateTime);
		  Thread.sleep(2000);
		  System.out.println("Going to press home");
		  dr.sendKeyEvent(AndroidKeyCode.HOME);		  		
  }
  catch(Exception e)
  {
	  System.out.println("Exception while uninstalling "   +Appname +" ******-------*******   "  +e);
	
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

