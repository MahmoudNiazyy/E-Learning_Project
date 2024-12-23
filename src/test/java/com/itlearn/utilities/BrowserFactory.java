package com.itlearn.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
	{
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver2.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
	         driver = new ChromeDriver(op);
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
	         driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
	         driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser ");
		}

		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		return driver;

	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
