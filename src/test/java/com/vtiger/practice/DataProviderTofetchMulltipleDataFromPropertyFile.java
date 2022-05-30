package com.vtiger.practice;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.PropertyFileUtility;

public class DataProviderTofetchMulltipleDataFromPropertyFile {
@Test(dataProvider = "loginData")
	
	public void practiceTest(String userName,String password) {
		Reporter.log(userName+" -->"+password,true);
		
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException{
		 PropertyFileUtility propertFile = new PropertyFileUtility();
		 propertFile.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		 Object[][] data=new Object[5][2];
		 data[0][0]=propertFile.getDataFromPropertFile("url");
		 data[0][1]=propertFile.getDataFromPropertFile("browser");
		 data[1][0]=propertFile.getDataFromPropertFile("username");
		 data[1][1]=propertFile.getDataFromPropertFile("pasword");
		 data[2][0]=propertFile.getDataFromPropertFile("timeout");
		 data[2][1]=propertFile.getDataFromPropertFile("dbusername");
		 data[3][0]=propertFile.getDataFromPropertFile("dbDatabase");
		 data[3][1]=propertFile.getDataFromPropertFile("contact");
		 data[4][0]=propertFile.getDataFromPropertFile("title");
		 data[4][0]=propertFile.getDataFromPropertFile("title");
		 
		 
		return data;
	}

}
