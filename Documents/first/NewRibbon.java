package first;
//import android.graphics.Bitmap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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



public class NewRibbon {
	
	public AndroidDriver dr;

	String timestamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String cs=dateFormat.format(date).toString();
		return cs;
	}
	
	public static boolean compareImage(File fileA, File fileB) {        
	    try {
	        // take buffer data from botm image files //
	        BufferedImage biA = ImageIO.read(fileA);
	        DataBuffer dbA = biA.getData().getDataBuffer();
	        int sizeA = dbA.getSize();                      
	        BufferedImage biB = ImageIO.read(fileB);
	        DataBuffer dbB = biB.getData().getDataBuffer();
	        int sizeB = dbB.getSize();
	        // compare data-buffer objects //
	        if(sizeA == sizeB) {
	            for(int i=0; i<sizeA; i++) { 
	                if(dbA.getElem(i) != dbB.getElem(i)) {
	                    return false;
	                }
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    } 
	    catch (Exception e) { 
	        System.out.println("Failed to compare image files ...");
	        return  false;
	    }
	}	
void storeScreenshots(WebElement ele) throws IOException{

	//with new ribbon
	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

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
	

	ele.click();
	dr.sendKeyEvent(AndroidKeyCode.HOME);
		
	//new ribbon removed
	// Get entire page screenshot
	screenshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	point = ele.getLocation();

	// Get width and height of the element
	eleWidth = ele.getSize().getWidth();
	eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png", screenshot);

	// Copy the element screenshot to disk
	screenshotLocationnew = new File("C:\\Users\\Nakul\\Desktop\\abc1.png");
	FileUtils.copyFile(screenshot, screenshotLocationnew);	

}
	
	
	
@Test()
void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	
     
	
	dr.sendKeyEvent(3);
	WebDriverWait wait = new WebDriverWait(dr,500);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/workspace")));
	 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
	 
	 ((AndroidDriver<WebElement>) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Fake ID Maker\"))");

	WebElement ele = dr.findElementByName("Fake ID Maker");



	
	File q1 = new File("C:\\Users\\Nakul\\Desktop\\abc1.png");
    File q2 = new File("C:\\Users\\Nakul\\Desktop\\abc.png");


System.out.println(compareImage(q1,q2));




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