package com.vtiger.contactsTest;


import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.vtiger.ObjectRep.ContactInformationPage;
import com.vtiger.ObjectRep.ContactPage;
import com.vtiger.ObjectRep.CreateNewContactInformationPage;

public class CreateContactsTest  extends BaseClass{
@Test(groups={"sanity","regression"})
	public  void createContactsTest () throws SQLException, IOException {

		String contact = msExcelUtility.getDataFromExcel("Contacts", 2, 1)+Random;

		ContactPage cp = new ContactPage(driver);
		CreateNewContactInformationPage cncip= new CreateNewContactInformationPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);

		hp.HomePageContactLink();
		cp.contactPageAction();
		cncip.contactInformationPageAction(contact);
		cncip.contactSave();
		String contacts = cip.ContactInformationPageAction();
	    System.out.println(contacts);
	    
		jutil.assertionThroughIfCondition(contacts, contact, contact);

	}

}

