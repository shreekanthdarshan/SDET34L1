package com.vtiger.organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.SDET34L1.genricutility.JavaUtility;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;

public class CreaterOganizationusingExcelTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public void createrOganizationusingExcelTest() throws EncryptedDocumentException, IOException {
		JavaUtility jutili = new JavaUtility();
		String organizationaName = msExcelUtility.getDataFromExcel("Organization", 2, 1)+Random;


		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oIP = new OrganizationInformationPage(driver);


		if(driver.getTitle().contains("Home")) {
			msExcelUtility.setDataintoExcel("Organization", 8, 6, "Home page is display");
			msExcelUtility.setDataintoExcel("Organization", 8, 7, "pass");
		}

		hp.homePageOrganizationAction();

		String text = driver.getTitle();
		System.out.println(text);
		if(driver.getTitle().contains("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM")) {
			msExcelUtility.setDataintoExcel("Organization", 9, 6, "organization page is displayed");
			msExcelUtility.setDataintoExcel("Organization", 9, 7, "pass");

		}
		op.createNewOrganization();



		if(driver.getTitle().contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM")) {
			msExcelUtility.setDataintoExcel("Organization", 10, 6, "create new organization page is displayed");
			msExcelUtility.setDataintoExcel("Organization", 10, 7, "pass");


		}
		cnop.enterTheOrganizationName(organizationaName);

		cnop.saveTheOrganization();


		if(driver.getTitle().contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM")) {
			msExcelUtility.setDataintoExcel("Organization", 11, 6, "create organization name created");
			msExcelUtility.setDataintoExcel("Organization", 11, 7, "pass");

		}
		//step4 ==>Validate the data

		//WebElement ele= driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
		String text5=oIP.getcreatedOrgnizationName();
		System.out.println(text5);
		jutili.assertionThroughIfCondition(text5, organizationaName, organizationaName);


		if(driver.getTitle().contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM")) {
			msExcelUtility.setDataintoExcel("Organization", 12, 6, "Logout from the application");
			msExcelUtility.setDataintoExcel("Organization", 12, 7, "pass");

		}

		

		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM")) {
			msExcelUtility.setDataintoExcel("Organization", 13, 6, "create organization page is displayed");
			msExcelUtility.setDataintoExcel("Organization", 13, 7, "pass");

		}

	}


}


