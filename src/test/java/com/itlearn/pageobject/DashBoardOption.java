package com.itlearn.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardOption extends BaseTest{

	WebDriver driver;
	
	public DashBoardOption(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"learn-press-user-profile\"]/ul/li[3]") WebElement offerAcademies;
	
	@FindBy(xpath="//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button") WebElement subsribebtn;
	
	public void offeracad()
	{
		offerAcademies.click();
	}
	
	public void subscribeClick() {
		subsribebtn.click();
	}
	
	
}
