package com.itlearn.testcases;



import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pageobject.BaseTest;
import com.itlearn.pageobject.LoginPage;
import com.itlearn.utilities.ReadExcelFile;


public class LoginTestDataDrivenTesting extends BaseTest {
	
//	 System.out.println(System.getProperty("user.dir"));
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

	@Test(priority =1,dataProvider="LoginDataProvider")
	public void VerifyLogin(String userEmail,String userPwd) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
//		String username ="Demo12";
//		String password ="Test123456$";
		lp.loginToPortal(userEmail, userPwd);
		
		if(userEmail.equals(userEmail) && userPwd.equals(userPwd))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority =2)
	public void fetchDashboardText() throws IOException
	{
		LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		String as= excel.getStringData("dash", 0, 0);
		System.out.println("This is excel data "+as);
		lp.dashboardportal(excel.getStringData("dash", 0, 0));
		
//		String actualdash= driver.findElement(By.xpath("//*[@id=\"login-list\"]/li[1]/a")).getText();
//		System.out.println(actualdash);
//		if(actualdash.equals(expectedDash))
//		{
//			System.out.println("Test Passed");
//			
//		}
//		else
//		{
//			captureScreenShot(driver,"fetchDashboardText");
//		}
//		assertEquals(dashtext, actualdash);
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}

	
	
	
	
}
