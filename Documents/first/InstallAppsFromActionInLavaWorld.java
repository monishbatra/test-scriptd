package first;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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



public class InstallAppsFromActionInLavaWorld {
	 Dimension size;
	
	public AndroidDriver dr;
	
	public class LaunchApps {
		int CountAppsLaunched=0;
		int AppsPresent=0;
		@SuppressWarnings("rawtypes")
		public AndroidDriver dr;

  @Test()
  public void SearchAnApp() throws InterruptedException {
	  
	  
	//Again Open Lava World to download	
		 dr.findElementById("launcher3.android.com.hivelauncher:id/hotseat").click();
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lava World\"))").click();

		 dr.findElementById("com.hiveinside.gamestore:id/action_search").click(); 
		 dr.findElementByName("social").click();
		     
		  
	
		  
		  List<WebElement> ca=dr.findElementsById("com.hiveinside.gamestore:id/text_name");
		  for(int i=0;i<ca.size();i++){
			    System.out.println(ca.get(i));
			} 
		  int ca2=ca.size();
		  ca2 -=4;
		  if(ca2>=9)
			  ca2++;
		  AppsPresent=ca2;
		  System.out.println("Apps Present in first set =" +ca2); 
	/*int q=190;
	int w=401;
	int e=222;
	int r=433;
//		  dr.findElementById("com.hiveinside.gamestore:id/title").click();
		 
		  for(int i=0;i<ca2;i++)
		  {
			  if(i==0)
			  {
				  
			  }
			  else if(i%3==0)
			  {
				if(i==3)
				{
					q=190;
					w=742;
					e=222;
					r=774;
				}
				if(i==6)
				{
					q=190;
					w=1084;
					e=222;
					r=1116;
				}
				if(i==9)
				{
					q=190;
					w=1164;
					e=222;
					r=1196;
				}
			  }
			  
			  else
			  {
				  q+=232;
				  e+=232;
			  }
			  String s=ca.get(i).getText();
			  System.out.println(s);
			  dr.findElementByName(s);
			  dr.findElement(By.xpath("//android.widget.ImageView[@bounds='["+q+","+w+"]["+e+","+r+"]']")).click();
			  dr.findElementById("com.hiveinside.gamestore:id/title").click();
			  System.out.println("App  " +(i+1) +"   "  +s   +"  Downloading");
			//  Thread.sleep(5000);
			  if(i==8)
			  {
				  
			  }
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
				dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
				dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
			if (dr != null) {
				dr.quit();
			}
		
	  }

		}}

  