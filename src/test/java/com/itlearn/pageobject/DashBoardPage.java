package com.itlearn.pageobject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseTest{

	WebDriver driver;
	//constructor
	public DashBoardPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id=\"login-list\"]/li[1]/a") WebElement dash;
	
	public void dashboardportal(String dashtext) throws IOException
	{
		String actualdash= dash.getText();
		System.out.println(actualdash);
		
		if(actualdash.equals(dashtext))
			{
				System.out.println("Test Passed");
				
			}
			else
			{
				captureScreenShot(driver,"fetchDashboardText");
			}
		assertEquals(dashtext, actualdash);

	}
	
	public void dashboardclick()
	{
		dash.click();	}
}
