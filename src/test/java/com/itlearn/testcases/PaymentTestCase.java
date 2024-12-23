package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pageobject.BaseTest;
import com.itlearn.pageobject.DashBoardPage;
import com.itlearn.pageobject.LoginPage;
import com.itlearn.pageobject.PaymentPage;
import com.itlearn.utilities.ReadExcelFile;

public class PaymentTestCase extends BaseTest{
	
String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority =1)
	void testcourses()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginToPortal(username, password);
		
		DashBoardPage dp = new DashBoardPage(driver);
		
		dp.dashboardclick();
		
		PaymentPage pg= new PaymentPage(driver);
		String crdnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expdate=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		
		pg.paymentOption(crdnum, expdate, cvcnum);
		
	}

}
