
package com.vtiger.DocumentsTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.SDET34L1.genricutility.JavaUtility;
import com.vtiger.ObjectRep.CreateNewDocumentPage;
import com.vtiger.ObjectRep.DocumentInformationPage;
import com.vtiger.ObjectRep.DocumentPages;

public class CreateDocumentTitleTest extends BaseClass{
	@Test(groups={"sanity","regression"})
	public void createDocumentTitleTest() throws IOException, InterruptedException, AWTException {
		JavaUtility jutil = new JavaUtility();
		String DocumentTitle = msExcelUtility.getDataFromExcel("Document", 2, 1)+Random;
		String Document_description = msExcelUtility.getDataFromExcel("Document", 2, 2);
		String Document_path = msExcelUtility.getDataFromExcel("Document", 2, 3);
		System.out.println(DocumentTitle);
		

        
		DocumentPages dp = new DocumentPages(driver);
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		DocumentInformationPage dcip = new DocumentInformationPage(driver);
         if(driver.getTitle().contains("vtiger")) {
			System.out.println("naie");
			msExcelUtility.setDataintoExcel("Document", 5, 4, "homepage is dislpayed");
			msExcelUtility.setDataintoExcel("Document", 5, 5, "pass");
		}
		//Click on the Document
		hp.homePageDocumentLink();
		
		//click on the create new document
		dp.createNewDocumentBtn();
		
		//Enter all mandatory field
		cndp.documentPageActions(driver, 0, DocumentTitle, Document_description,Document_path);
		String text =dcip.DocumentInformationPageAction();
	    jutil.assertionThroughIfCondition(text, DocumentTitle, DocumentTitle);
	    
		
		
	}
}
