package testBase;

import java.time.Duration;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameters;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;      //Log4j

public class BaseClass {
	
	
public WebDriver driver;

public Logger logger;  //log4j2 to logs the automation logs for test cases
	
	@BeforeClass
	@parameters({"os","browser"})
	public void setup(String os, String br)
	{
		
		logger=LogManager.getLogger(this.getClass());    // It will automatically get log4j2 file 
		
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver(); break;
		case "forefox":driver=new FirefoxDriver();break;
		default : System.out.print("Invalid browser name..");return;
				
		}
		
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.opencart.com/");
		driver.manage().window().maximize();
						
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	 public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphanumeric(5);
		return generatedstring;
		
	}
	
	
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
		
	}
	
	
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+ generatednumber);
		
		
	}
	 
	
	
	

}
