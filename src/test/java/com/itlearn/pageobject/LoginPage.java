package com.itlearn.pageobject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BaseTest{

	WebDriver driver;
	//constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id=\"loginlabel\"]") WebElement loginclick;
	
	
@FindBy(name="log") WebElement uname;
	
	@FindBy(name="pwd") WebElement pass;
	
	@FindBy(name="wp-submit") WebElement loginButton;

	@FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement logoutimage;
	
	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;



	public void loginToPortal(String username, String password) {
		// TODO Auto-generated method stub
		loginclick.click();
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
		
	}

	public void logout()
	{
		logoutimage.click();
		logoutclick.click();
	}
	public void dashboardportal(String dash) throws IOException
	{
		String actualdash= driver.findElement(By.xpath("//*[@id=\"login-list\"]/li[1]/a")).getText();
		System.out.println(actualdash);
		
		if(actualdash.equals(dash))
			{
				System.out.println("Test Passed");
				
			}
			else
			{
				captureScreenShot(driver,"fetchDashboardText");
			}
		assertEquals(dash, actualdash);
//		String actualdash= "Dashboard";
		
	}
}
