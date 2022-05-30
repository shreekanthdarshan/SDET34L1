package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBasicConfigurationTest {
	@BeforeSuite(groups = "baseClass")
	public void beforeSuite1Test() {
		Reporter.log("beforeSiute1",true);
	}
	
	@AfterSuite(groups = "baseClass")
	public void afterSuite1Test() {
		Reporter.log("beforeSiute1",true);
	}
	
	@BeforeTest(groups = "baseClass")
	public void beforeTest1Test() {
		Reporter.log("beforeTest1",true);
	}
	
	@AfterTest(groups = "baseClass")
	public void afterTest1Test() {
		Reporter.log("beforeTest1",true);
	}
	
	@BeforeClass(groups = "baseClass")
	public void beforeClass1Test() {
		Reporter.log("beforeClass1",true);
		
	}
	
	
	@AfterClass(groups = "baseClass")
	public void afterClass1Test() {
		Reporter.log("bafterClass1",true);
		
	}
	@BeforeMethod(groups = "baseClass")
	public void beforeMethod1Test() {
		Reporter.log("beforeMethod1",true);
		
	}
	
	@AfterMethod(groups = "baseClass")
	public void afterMethod2Test() {
		Reporter.log("afterMethod2",true);
		
	}
	
	
	




}
