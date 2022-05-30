package com.vtiger.organizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.SDET34L1.genricutility.JavaUtility;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;

public class CreateOrganizationandaAddIndustryaandTypeTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public  void createOrganizationandaAddIndustryaandTypeTest() throws IOException, InterruptedException {
		JavaUtility jutil=new JavaUtility();
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OraganizationName = msExcelUtility.getDataFromExcel("Organization",2 , 1)+Random;

		
		
		if(driver.getTitle().contains("vtiger")) {
			System.out.println("naie");
			msExcelUtility.setDataintoExcel("Organization", 16, 4,"homepage is displayed" );
			msExcelUtility.setDataintoExcel("Organization", 19, 5,"pass" );
		}
		
		hp.homePageOrganizationAction();	
		op.createNewOrganization();
		
		cnop.enterTheOrganizationName(OraganizationName);
		
		cnop.industryDropDown("Education");
		
		
		
		cnop.accounttypeDropDown("Press");
		
		
		cnop.saveTheOrganization();
		
		
		String text= oip.getcreatedOrgnizationName();
		System.out.println(text);
		jutil.assertionThroughIfCondition(text, OraganizationName, OraganizationName);
		
		
		
	
		
		
	}

}
