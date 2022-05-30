
package com.vtiger.contactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.vtiger.ObjectRep.ContactInformationPage;
import com.vtiger.ObjectRep.ContactPage;
import com.vtiger.ObjectRep.CreateNewContactInformationPage;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;

public class CreateContactwithOrganizationTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public  void createContactwithOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String Organization_name = msExcelUtility.getDataFromExcel("Contacts", 2, 1)+Random;
		System.out.println(Organization_name);
		String contact = msExcelUtility.getDataFromExcel("Contacts", 2, 1)+Random;
		System.out.println(contact);
		OrganizationPage op = new OrganizationPage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		CreateNewContactInformationPage cncip= new CreateNewContactInformationPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);
		hp.homePageOrganizationAction();
		op.createNewOrganization();
		cnop.enterTheOrganizationName(Organization_name);
		cnop.saveTheOrganization();
		String org_name =oip.getcreatedOrgnizationName();
		System.out.println(org_name);
		jutil.assertionThroughIfCondition(org_name, Organization_name, Organization_name);
		hp.HomePageContactLink();

		cp.contactPageAction();

		cncip.contactInformationPageAction(contact);


		String Parent_id = driver.getWindowHandle();
		System.out.println(Parent_id);
		cncip.addOrganizationTocontact();
		cncip.switchchild(driver,"Accounts&action",timeouts);
		cncip.enterOrganizationNameEnter(Organization_name);
		Thread.sleep(2000);
		cncip.switchToParent(driver, "Contacts&action");
		cncip.contactSave();
		String text =cip.ContactInformationPageAction();
		jutil.assertionThroughIfCondition(text, contact, contact);



	}


}

