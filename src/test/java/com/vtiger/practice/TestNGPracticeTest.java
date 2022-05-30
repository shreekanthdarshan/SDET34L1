package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest  extends TestNGBasicConfigurationTest{
	@Test(groups = {"smoke","regression"})
	public void step1Test() {

		// SoftAssert softAssert = new SoftAssert();
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Assert.assertEquals("aba", "ahggv");
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		//softAssert.fail();
		Assert.fail("practic fail");
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);


	}

	@Test(groups = "sanity")
	public void step2Test() {
		Reporter.log("Test2",true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Assert.assertEquals("aba", "kk");
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
	}
	@Test(groups = "regression")

	public void step3Test() {
		Reporter.log("Test3",true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
	}
	@Test(groups = "regression")
	public void step4Test() {
		Reporter.log("Test4",true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
		Reporter.log("Test1" ,true);
	}

}
