package com.vtiger.practice;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.MsExcelUtility;

public class DataProviderToFetchTheMulltipleDataFromExcel {
	
	@Test(dataProvider = "loginData")
	
	public void practiceTest(String userName,String password) {
		Reporter.log(userName+" -->"+password,true);
		
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException{
		MsExcelUtility msExcelUtility = new MsExcelUtility();
		msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		
		
		
	
		return msExcelUtility.getMultipleDataFromExcel("Multiple");
	}

}
