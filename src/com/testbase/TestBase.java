package com.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver=null;
	public static String filename="E:\\Selenium_Practice\\singleton pattern\\src\\com\\resources\\config.properties";
	public static FileInputStream fi;
	public static Properties prop;
	public static void initialization()
	{
		try
		{
			fi=new FileInputStream(filename);
			prop=new Properties();
			prop.load(fi);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(driver==null)
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Practice\\Practice_Selenium\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else
			{
				driver=new FirefoxDriver();
			}
			
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void quit()
	{
		driver.quit();
		driver=null;
	}
	
	
	public static void close()
	{
		driver.close();
		driver=null;
	}

}
