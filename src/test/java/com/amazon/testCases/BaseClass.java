package com.amazon.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.amazon.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig ();
	//public String baseurl="https://www.amazon.in/";
	//public String ssearch="iphone12";
	public String baseurl=readconfig.getApplicationURL();
	public String ssearch =readconfig.getSsearch();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{
	
             
             logger = Logger.getLogger("amazon");
             PropertyConfigurator.configure("Log4j.properties");
             
           //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
   		   //System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
                //driver = new ChromeDriver();
             if(br.equals("chrome"))
             {
            	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
                 driver = new ChromeDriver();
 		
             }
             else if(br.equals("firefox"))
             {
            	 System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            	 driver = new FirefoxDriver();
             }
             
             else if(br.equals("ie"))
             {
            	 System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
            	 driver = new InternetExplorerDriver();
             }
             
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             driver.get(baseurl);
		
		
	}
	
	
	
	
	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	 
	

}
