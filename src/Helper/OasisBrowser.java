package Helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.im.InputContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class OasisBrowser 
{
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static InputContext ctx;
	public static Robot rb;
	public static Actions builder; 
	public static AutoItX bot;	
	
	
	
	@BeforeSuite
	public static void setup() throws InterruptedException, FileNotFoundException, AWTException 
	{
		//IEDriver launch Oasis
		  
		System.setProperty("webdriver.ie.driver", "C://Users//ukccs1tsa//Downloads//Tushar CC//Tools//Selenium//IEDriver//IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		//cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		driver = new InternetExplorerDriver(cap); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		  
		driver.get(Constants.URL);
		Thread.sleep(2000);
		
		wait = new WebDriverWait(driver, 30);
		builder = new Actions(driver);
		rb = new Robot();
		String jacobDllVersionToUse = "jacob-1.18-x64.dll";
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		bot = new AutoItX();
		 
		  for(String winHandle : driver.getWindowHandles())
			    {driver.switchTo().window(winHandle);}
		   
		  driver.switchTo().frame("main");
		  
		  WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))); 
		  Username.sendKeys(Constants.Username);
		  
		  WebElement Password =  wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		  Password.clear();
		  Password.sendKeys(Constants.Password);
		
		  driver.findElement(By.id("btnLogin")).click();
		  
		  Thread.sleep(3000);
		  driver.switchTo().frame("main");
		  driver.manage().window().maximize();
		 
		  
		  WebElement theOasisTitle = wait.until(ExpectedConditions.elementToBeClickable(By.id("theOasisTitle"))); 
		  WebElement theGreeting =  wait.until(ExpectedConditions.elementToBeClickable(By.id("theGreeting"))); 
		  
		  if (theOasisTitle.isDisplayed()&&theGreeting.isDisplayed())
		  {
			  Reporter.log("Home page text - "+ theOasisTitle.getText());
			  Reporter.log("User Logged in - "+ theGreeting.getText());
		  }
		  
		  Constants.parentHandle = driver.getWindowHandle();
	}

	
	@AfterSuite
	public static void teardown()
	{
		driver.switchTo().window(Constants.parentHandle);
		//driver.quit();
	}

	public static void switchtoParent()
	{
		driver.switchTo().window(Constants.parentHandle);
	}

}
