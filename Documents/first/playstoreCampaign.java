package first;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class playstoreCampaign {
	
	Excel e=new Excel();
	
	public AndroidDriver dr;

	void campaignShown(){
		try {
		dr.openNotifications();
   		WebDriverWait wait = new WebDriverWait(dr,500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/notification_title")));        
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String cs=dateFormat.format(date).toString();
		System.out.println(cs+" campaign shown");
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
					DateFormat dateF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date2 = new Date();
			     String cd=dateF.format(date2).toString();
			     System.out.println(cd+" campaign dismissed");
			     dr.sendKeyEvent(AndroidKeyCode.HOME);		  
			     }
		         
		   	  catch(Exception e)
		 		{
		 			System.out.println("Exception occured " + e);
		 			 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 		}
	}
	
	
	void campaignClicked()
	{
		 campaignShown();
		 dr.findElementById("launcher3.android.com.hivelauncher:id/notification_title").click();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String cs=dateFormat.format(date).toString();
			System.out.println(cs+" campaign clicked");

	}
	 void campaignVerification() throws IOException
	 {
		campaignShown();
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		WebElement ele = dr.findElementById("launcher3.android.com.hivelauncher:id/notification_icon");
		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocationnew = new File("C:\\Users\\Nakul\\Desktop\\abc.png");
		FileUtils.copyFile(screenshot, screenshotLocationnew);	

	 }
	
@Test()
void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
    campaignVerification();
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