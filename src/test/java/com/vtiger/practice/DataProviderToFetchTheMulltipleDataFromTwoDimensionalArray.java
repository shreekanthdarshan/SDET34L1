package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderToFetchTheMulltipleDataFromTwoDimensionalArray
{
	@Test(dataProvider = "logindata")
	public void loginPageAction(String username,String password) {
		Reporter.log(username+"  ------>  "+password,true);
		
	}
	
	
	@DataProvider
	public Object[][] logindata(){
		Object[][] data=new Object[5][2];
		data[0][0]="userName";
		data[0][1]="password";
		
		data[1][0]="userName1";
		data[1][1]="password1";
		
		data[2][0]="userName2";
		data[2][1]="password2";
		
		data[3][0]="userName3";
		data[3][1]="password3";
		
		data[4][0]="userName4";
		data[4][1]="password4";
		
		return data;
	}
	

}
