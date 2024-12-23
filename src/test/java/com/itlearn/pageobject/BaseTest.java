package com.itlearn.pageobject;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.itlearn.utilities.BrowserFactory;
import com.itlearn.utilities.ConfigDataProviders;
import com.itlearn.utilities.ReadExcelFile;






public class BaseTest {
	
	public WebDriver driver;
	public ConfigDataProviders config;
	public ReadExcelFile excel;
	
	@BeforeSuite
	public void setUpSuite()
	{
		config=new ConfigDataProviders();
		excel =new ReadExcelFile();
	}
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	
 @AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
 
 public void captureScreenShot(WebDriver driver,String testName) throws IOException
 {
	 // Convert webdriver object to TakesScreenshot interface
	 TakesScreenshot screenshot= ((TakesScreenshot)driver);
	 
	 // Step 2 :call getScreenshotAs method to capture image file
	 
	 File src= screenshot.getScreenshotAs(OutputType.FILE);
	 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
	 
	 // Step 3 : copy image file to destination 
	 FileUtils.copyFile(src, srcpath);
	 
 }

}
